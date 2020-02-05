package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname PictureInfEntity
 * @Date: 2020-01-09 22:52
 * @Description: 图片信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureInfEntity {

    @Override
    public String toString() {
        return "PictureInfEntity{" +
                "pictureInfId=" + pictureInfId +
                ", productInfId=" + productInfId +
                ", pictureInfUrl='" + pictureInfUrl + '\'' +
                ", pictureInfMaster=" + pictureInfMaster +
                '}';
    }

    /**
     * picture_inf_id: 图片信息表ID
     */
    private Integer pictureInfId;
    /**
     * product_inf_id: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * picture_inf_url: 图片路径
     */
    private String pictureInfUrl;
    /**
     * pictureInfMaster: 是否为主图(0:"否",1:"是")
     */
    private Byte pictureInfMaster;


    private PictureInfEntity(Builder builder) {
        pictureInfId = builder.pictureInfId;
        productInfId = builder.productInfId;
        pictureInfUrl = builder.pictureInfUrl;
        pictureInfMaster = builder.pictureInfMaster;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PictureInfEntity copy) {
        Builder builder = new Builder();
        builder.pictureInfId = copy.getPictureInfId();
        builder.productInfId = copy.getProductInfId();
        builder.pictureInfUrl = copy.getPictureInfUrl();
        builder.pictureInfMaster = copy.getPictureInfMaster();
        return builder;
    }
    public static final class Builder {
        private Integer pictureInfId;
        private Integer productInfId;
        private String pictureInfUrl;
        private Byte pictureInfMaster;

        private Builder() {
        }

        public Builder pictureInfId(Integer val) {
            pictureInfId = val;
            return this;
        }

        public Builder productInfId(Integer val) {
            productInfId = val;
            return this;
        }

        public Builder pictureInfUrl(String val) {
            pictureInfUrl = val;
            return this;
        }

        public Builder pictureInfMaster(Byte val) {
            pictureInfMaster = val;
            return this;
        }

        public PictureInfEntity build() {
            return new PictureInfEntity(this);
        }
    }
}
