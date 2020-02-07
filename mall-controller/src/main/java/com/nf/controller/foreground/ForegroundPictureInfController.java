package com.nf.controller.foreground;

import com.nf.entity.PictureInfEntity;
import com.nf.entity.ProductInfEntity;
import com.nf.service.port.PictureInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ForegroundPictureInfController
 * @Date: 2020-02-07 09:56
 * @Description: 前台 图片信息表控制器
 */
@Controller
@RequestMapping("/mall/foreground/picture/inf")
public class ForegroundPictureInfController {
    @Autowired
    private PictureInfService pictureInfService;


    /**
     * 根据商品id获得该商品的图片信息
     * @param pictureInfEntity 用来接收商品id
     * @return
     */
    @GetMapping("/product/data")
    @ResponseBody
    public ResponseVo productData(PictureInfEntity pictureInfEntity){
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
     * 获取轮播图片
     * @return
     */
    @GetMapping("/carousel")
    @ResponseBody
    public ResponseVo getCarousel(){
        boolean result = true;
        List<PictureInfEntity> pictureInfEntities = null;
        try {
            pictureInfEntities = pictureInfService.getCarousel();
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
}
