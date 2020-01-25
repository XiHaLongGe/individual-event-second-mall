package com.nf.controller.background;

import com.nf.entity.CustomerIndividualEntity;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerIndividualService;
import com.nf.service.port.CustomerLoginService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: LJP
 * @Classname PersonalDataController
 * @Date: 2020-01-19 15:55
 * @Description: 后台：用户个人资料的控制器
 */
@Controller
@RequestMapping("/mall/background/personal")
public class PersonalDataController {
    /**
     * FILE_DIRECTORY: 文件上传的路径   相对路径
     */
    private static final String FILE_DIRECTORY = "\\static\\background\\upload-file\\headIconImage";

    @Autowired
    private CustomerLoginService customerLoginService;
    @Autowired
    private CustomerIndividualService customerIndividualService;

    /**
     * 个人资料视图
     * @param model 通过该对象将个人资料信息存放至请求域中
     * @param request 通过当前请求对象来获得会话对象，用来获取当前登录用户信息
     * @return
     */
    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取用户登录id
        Integer loginId = (Integer) session.getAttribute("loginId");
        //根据用户登录id查出用户登录表数据，并存放至请求域
        model.addAttribute("customerLoginEntity", customerLoginService.getByLoginId(loginId));
        //根据用户登录id查出用户信息表数据，并存放至请求域
        model.addAttribute("customerIndividualEntity", customerIndividualService.getByLoginId(loginId));
        return "background/personal/list";
    }

    /**
     * 修改密码视图
     * @return
     */
    @GetMapping("/edit/password")
    public String editPassword(){
        return "background/personal/editPassword";
    }

    /**
     * 用来验证用户输入的原密码是否正确
     * @param request 根据请求对象获取到当前会话中用户的登录id
     * @param frontPassword 用来接收用户输入的原密码
     * @return
     */
    @PostMapping("/equals/password")
    @ResponseBody
    public ResponseVo equalsPassword(HttpServletRequest request, String frontPassword){
        boolean result;
        Integer loginId = getSessionLoginId(request);
        //拿到数据库中与当前用户密码对比，得到验证结果
        result = customerLoginService.equalsPassword(loginId, frontPassword);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "原密码通过验证" : "原密码验证失败")
                .data(result)
                .build();
    }

    /**
     * 更新用户密码
     * @param request 根据请求对象获取到当前会话中用户的登录id
     * @param password 用来接收用户输入的新密码
     * @return
     */
    @PostMapping("/update/password")
    @ResponseBody
    public ResponseVo updatePassword(HttpServletRequest request, String password){
        boolean result;
        Integer loginId = getSessionLoginId(request);
        result = customerLoginService.updatePassword(loginId, password);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "密码更新成功" : "密码更新失败")
                .data(result)
                .build();
    }

    /**
     * 用于获取当前会话中用户的登录id
     * @param request 根据请求对象获取到当前会话中用户的登录id
     * @return
     */
    private Integer getSessionLoginId(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (Integer) session.getAttribute("loginId");
    }

    /**
     * 更新用户的个人资料
     * @param multipartFile 包含上传过来的对象的数据，这里也就是用户更改头像的数据
     * @param customerIndividualEntity 通过该实体类来接收前台传输过来的数据
     * @return
     */
    @PostMapping("/head/update")
    @ResponseBody
    public ResponseVo headIconUpdate(HttpServletRequest request, MultipartFile multipartFile, CustomerIndividualEntity customerIndividualEntity) {
        boolean result = false;
        //获取到文件上传的路径
        String path = getFilePath(multipartFile);
        //如果上传对象为空
        if(path.isEmpty()){
            //将原来头像路径拿到，也就是头像不做修改
            path = customerIndividualEntity.getHeadIconUrl();
        }else{
            //将系统为上传文件生成的路径赋给customerIndividualEntity对象中
            customerIndividualEntity.setHeadIconUrl(path);
            try {
                //获取到项目的Resource目录路径
                String classPath = this.getClass().getClassLoader().getResource("/").getPath();
                //把文件上传的路径赋给文件对象
                File file = new File(classPath + path);
                //通过CommonsMultipartFile对象的方法直接写文件
                multipartFile.transferTo(file);
            } catch (IOException e) {
                result = false;
                e.printStackTrace();
            }
        }
        //将文件路径存至数据库中
        if(updateCustomer(request, customerIndividualEntity)){
            result = true;
        }
        return ResponseVo.newBuilder()
                    .code(result ? 200 : 500)
                    .message(result ? "用户个人资料更新成功" : "用户个人资料更新失败")
                    .data(result)
                .build();
    }

    /**
     * 获取到文件上传路径的方法
     * @param multipartFile 包含上传过来的对象的数据
     * @return 文件上传路径
     */
    private String getFilePath(MultipartFile multipartFile){
        //如果上传文件为空，返回空字符串
        if (multipartFile == null || multipartFile.isEmpty()){return "";}
        //得到一个随机文件名
        String fileName = UUID.randomUUID().toString().replace( "-", "" );
        //获取到上传文件的文件名
        String uploadFileName = multipartFile.getOriginalFilename();
        //得到上传过来文件的后缀名
        String suffix = uploadFileName.substring(uploadFileName.lastIndexOf('.'));
        //将文件名拼接到路径后
        //File.separator 就是 '\'符号
        return FILE_DIRECTORY + File.separator + fileName + suffix;
    }

    /**
     * 更新用户信息的方法
     * @param customerIndividualEntity 更新实体内容
     * @return 更新结果
     */
    private boolean updateCustomer(HttpServletRequest request, CustomerIndividualEntity customerIndividualEntity){
        HttpSession session = request.getSession();
        //获取到当前登录用户所在会话中的的登录id
        Integer loginId = (Integer) session.getAttribute("loginId");
        //将登录id写入实体类
        customerIndividualEntity.setLoginId(loginId);
        //获取到用户登录实体类对象
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder().build();
        //将customerIndividualEntity中属于用户登录实体类对象的数据copy到customerLoginEntity
        BeanUtils.copyProperties(customerIndividualEntity, customerLoginEntity);
        return (customerLoginService.updatePersonal(customerLoginEntity) && customerIndividualService.updateCustomer(customerIndividualEntity)) ? true : false;
    }
}
