package com.nf.controller.background;

import com.nf.entity.PictureInfEntity;
import com.nf.entity.ProductInfEntity;
import com.nf.service.port.PictureInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: LJP
 * @Classname PictureInfController
 * @Date: 2020-02-05 10:24
 * @Description: 图片信息控制器
 */
@Controller
@RequestMapping("/mall/background/picture/inf")
public class BackgroundPictureInfController {
    /**
     * FILE_DIRECTORY: 文件上传的路径   相对路径
     */
    private static final String FILE_DIRECTORY = "\\static\\background\\upload-file\\product-inf-image";
    @Autowired
    private PictureInfService pictureInfService;
    /**
     * 根据商品id获得该商品的图片信息
     * @param pictureInfEntity 用来接收商品id
     * @return
     */
    @GetMapping("/product/picture")
    @ResponseBody
    public ResponseVo productPicture(PictureInfEntity pictureInfEntity){
        boolean result = true;
        List<PictureInfEntity> pictureInfEntities = null;
        try {
            pictureInfEntities = pictureInfService.getByProInf(pictureInfEntity);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "获取商品图片成功" : "获取商品图片失败")
                .data(pictureInfEntities)
                .build();
    }

    /**
     * 批量上传及修改商品图片
     * @param multipartFile
     * @param productInfId
     * @return
     */
    @PostMapping("/batch/upload")
    @ResponseBody
    public ResponseVo batchUpload(@RequestParam("multipartFile") MultipartFile multipartFile, Integer productInfId, Integer order){
        boolean result = true;
        //获得传入商品id在图片信息表中的id
        List<PictureInfEntity> pictureInfEntityList = pictureInfService.getByProInf(PictureInfEntity.newBuilder().productInfId(productInfId).build());
        //这个布尔值是用来判断对数据库的操作是添加还是修改
        //false:添加
        //true:修改
        boolean editOfAdd = true;
        /*如果根据商品id没有在图片信息表中获得数据，则对数据库进行添加操作*/
        if(pictureInfEntityList.isEmpty()){
            editOfAdd = false;
        }
        try {
            /*用来接收图片信息表id*/
            Integer pictureInfId = null;
            //如果为修改则拿到根据商品id获取到的图片信息表id
            if(editOfAdd){
                pictureInfId = pictureInfEntityList.get(order).getPictureInfId();
            }
            PictureInfEntity pictureInfEntity = PictureInfEntity.newBuilder()
                                                                    .pictureInfId(pictureInfId)
                                                                    .pictureInfMaster(++order == 1 ? Byte.valueOf("1") : Byte.valueOf("0"))
                                                                .build();
            //获取到文件上传的路径，带文件名
            String filePath = getFilePath(multipartFile);
            //如果上传对象为空
            if(filePath.isEmpty()){
                //将原来路径拿到，也就是不做修改
//                    filePath = customerIndividualEntity.getHeadIconUrl();
                result = false;
            }else{
                //将系统为上传文件生成的路径赋给customerIndividualEntity对象中
                pictureInfEntity.setPictureInfUrl(filePath);
                try {
                    //获取到项目的Resource目录路径，如下：
//                  /D:/学习文件/项目/个人项目/商城项目(重写)/mall/mall-controller/target/mall-controller-1.0-SNAPSHOT/WEB-INF/classes/
                    String classPath = this.getClass().getClassLoader().getResource("/").getPath();
                    //把文件上传的路径赋给文件对象
                    File file = new File(classPath + filePath);
                    //通过CommonsMultipartFile对象的方法直接写文件
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    result = false;
                    e.printStackTrace();
                }
            }
            if(editOfAdd){
                pictureInfService.batchUpdate(pictureInfEntity);
            }else {
                pictureInfService.batchInsert(pictureInfEntity);
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "操作成功" : "操作失败")
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
}
