package com.nf.service.port;

import com.nf.entity.PictureInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureInfService
 * @Date: 2020-02-05 10:23
 * @Description: 图片信息表的service层接口
 */
public interface PictureInfService {

    /**
     * 根据商品id获得该商品的图片信息
     * @param pictureInfEntity 用来接收商品id
     * @return
     */
    List<PictureInfEntity> getByProInf(PictureInfEntity pictureInfEntity);


    /**
     * 获得商品信息的轮播图
     * @return
     */
    List<PictureInfEntity> getCarousel();

    /**
     * 根据商品id信息获得该商品在图片信息表中的id
     * @param productInfId 商品id
     * @param isMaster 用来判断是否取主图信息
     * @return
     */
    Integer[] getMasterByProInfId(Integer productInfId, boolean isMaster);

    /**
     * 对商品图片进行批量添加
     * @param pictureInfEntity
     * @return
     */
    Integer batchInsert(PictureInfEntity pictureInfEntity);

    /**
     * 对商品图片进行批量修改
     * @param pictureInfEntity
     * @return
     */
    Integer batchUpdate(PictureInfEntity pictureInfEntity);
}
