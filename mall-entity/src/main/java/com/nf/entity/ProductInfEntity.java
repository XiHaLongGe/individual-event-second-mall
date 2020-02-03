package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: LJP
 * @Classname ProductInfEntity
 * @Date: 2020-01-09 22:51
 * @Description: 商品信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfEntity {

    @Override
    public String toString() {
        return "ProductInfEntity{" +
                "productInfId=" + productInfId +
                ", brandInfId=" + brandInfId +
                ", productCategoryId='" + productCategoryId + '\'' +
                ", productInfName='" + productInfName + '\'' +
                ", productInfDescribe='" + productInfDescribe + '\'' +
                ", productInfPrice=" + productInfPrice +
                ", productInfSales=" + productInfSales +
                ", productInfStockpile=" + productInfStockpile +
                '}';
    }

    /**
     * product_inf_id: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * brand_inf_id: 品牌信息表ID
     */
    private Integer brandInfId;
    /**
     * product_category_id: 商品类型表ID
     */
    private String productCategoryId;
    /**
     * product_inf_name: 商品名称
     */
    private String productInfName;
    /**
     * product_inf_describe: 商品描述
     */
    private String productInfDescribe;
    /**
     * product_inf_price: 商品价格
     */
    private BigDecimal productInfPrice;
    /**
     * product_inf_sales: 商品销量
     */
    private Integer productInfSales;
    /**
     * product_inf_stockpile: 商品库存
     */
    private Integer productInfStockpile;


    /*===================================   扩展字段   begin   ================================*/

    /**
     * productCategoryName: 类型名称
     */
    private String productCategoryName;
    /**
     * brandInfName: 品牌名称
     */
    private String brandInfName;
    /**
     * orderField: 排序字段，根据哪个字段来进行排序
     *                      1 : 价格字段
     *                      2 : 销量字段
     *                      3 : 库存字段
     */
    private Integer orderField;
    /**
     * orderType: 排序类型：升序还是降序
     *                      0 : 升序
     *                      1 : 降序
     */
    private Byte orderType;

    /*===================================   扩展字段   end   ==================================*/
}
