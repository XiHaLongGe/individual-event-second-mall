package com.nf.dao.port;

import com.nf.entity.PictureInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureInfDao
 * @Date: 2020-02-05 10:18
 * @Description:
 */
public interface PictureInfDao {
    /**
     * 根据商品id获得该商品的图片信息
     * @param pictureInfEntity 用来接收商品id
     * @return
     */
    List<PictureInfEntity> getByProInf(@Param("pictureInfEntity") PictureInfEntity pictureInfEntity);

    /**
     * 获得商品信息的轮播图
     * @param productInfId 设置为轮播图展示的商品id
     * @return
     */
    List<PictureInfEntity> getCarousel(@Param("productInfIdArray") Integer[] productInfId);


    /**
     * 根据商品id信息获得该商品在图片信息表中的id
     * @param productInfId 商品id
     * @param isMaster 用来判断是否取主图信息
     * @return
     */
    Integer[] getMasterByProInfId(@Param("productInfId") Integer productInfId, @Param("isMaster")boolean isMaster);


    /**
     * 对商品图片进行添加
     * @param pictureInfEntity
     * @return
     */
    Integer batchInsert(@Param("pictureInfEntity") PictureInfEntity pictureInfEntity);

    /**
     * 对商品图片进行修改
     * @param pictureInfEntity
     * @return
     */
    Integer batchUpdate(@Param("pictureInfEntity") PictureInfEntity pictureInfEntity);
}
