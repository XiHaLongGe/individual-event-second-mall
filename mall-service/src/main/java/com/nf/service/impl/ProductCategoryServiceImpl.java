package com.nf.service.impl;

import com.nf.dao.port.ProductCategoryDao;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.PbrService;
import com.nf.service.port.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: LJP
 * @Classname ProductCategoryServiceImpl
 * @Date: 2020-01-29 10:45
 * @Description: 商品类型表的service层
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Autowired
    private BrandInfService brandInfService;
    @Autowired
    private PbrService pbrService;

    @Override
    public List<ProductCategoryEntity> getAllData() {
        return productCategoryDao.getAllData();
    }

    @Override
    public List<ProductCategoryEntity> getPageByCondition(Integer pageNum, Integer pageSize, ProductCategoryEntity productCategoryEntity) {
        return productCategoryDao.getPageByCondition(pageNum, pageSize, productCategoryEntity);
    }

    @Override
    public ProductCategoryEntity getByProductCategoryId(String productCategoryId) {
        return productCategoryDao.getByProductCategoryId(productCategoryId);
    }

    @Override
    public List<ProductCategoryEntity> getByProductCategoryLevel(Integer productCategoryLevel) {
        return productCategoryDao.getByProductCategoryLevel(productCategoryLevel);
    }

    @Override
    public List<ProductCategoryEntity> getExistPbrData() {
        //获取到关联表中所有的商品类型id
        String[] proCategoryIdArray = pbrService.getAllProCategoryId();
        return productCategoryDao.getExistPbrData(proCategoryIdArray);
    }

    @Override
    public String[] getByParentId(String[] parentIdArray) {
        return productCategoryDao.getByParentId(parentIdArray);
    }

    @Override
    public ProductCategoryEntity getBigId(ProductCategoryEntity productCategoryEntity) {
        return productCategoryDao.getBigId(productCategoryEntity);
    }

    @Override
    public Integer getByPbrIdCount(String[] pbrIdArray) {
        //实例化一个set集合
        Set<String> set = new HashSet<>();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < pbrIdArray.length; i++) {
            set.add(pbrIdArray[i]);
        }
        //set.toArray() 得到Set集合的数组形式 object类型
//        return productCategoryDao.getByParentIdCount(set.toArray(pbrIdArray));
        return 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertProductCategory(ProductCategoryEntity productCategoryEntity) {
        //父栏目id算法：
        //商品父栏目id '类型层次id' + '-' + '序号(第几个)'
        //主页父栏目id '类型层次id' + '-' + '序号(第几个)'
        //子栏目id算法：
        //商品子栏目id '父类型id' + '-' + '序号(第几个)'
        //主页子栏目id '父类型id' + '-' + '序号(第几个)'


        //用于接收本次添加数据id的前缀
        String parentId = productCategoryEntity.getParentId();
        //判断父id是否为空，父id为空添加的数据则是商品父栏目
        if(parentId == null || parentId.isEmpty()){
            parentId = productCategoryEntity.getProductCategoryLevel() + "-";
        }else{
            parentId = productCategoryEntity.getParentId() + "-";
        }

        //得到该层级中最后id的序号
        Integer orderNumber = 0;
        //获得该层级最大id，用于生成本次添加数据的id，达到排序的效果，
        //比如之前id为 1-1 现在添加的数据id就应该为 1-2
        String proCategoryId = "";
        //如果所选父类型是新添加的就不会存在子类型
        //getBigId(productCategoryEntity) 就会得到空
        if(getBigId(productCategoryEntity) != null){
            proCategoryId = getBigId(productCategoryEntity).getProductCategoryId();
            orderNumber = Integer.valueOf(proCategoryId.substring(parentId.length()));
        }
        //拼接成本次添加数据的id
        String result = parentId + (orderNumber + 1);
        //写入实体类，通过mapper文件写入数据库
        productCategoryEntity.setProductCategoryId(result);
        return productCategoryDao.insertProductCategory(productCategoryEntity) > 0;
    }

    @Override
    public boolean updateProductCategory(ProductCategoryEntity productCategoryEntity) {
        return productCategoryDao.updateProductCategory(productCategoryEntity) > 0;
    }

    @Override
    public boolean deleteByParentId(String[] pbrIdArray, boolean cascadeDelete) {
        boolean deleteResult = false;
        //获取到传过来的父类型id的子类型有多少条目
        Integer parentNum = 1;//getByParentIdCount(pbrIdArray);
        //验证删除的条目是否  等于  传过来的父类型id的子类型的条目
        deleteResult = productCategoryDao.deleteByParentId(pbrIdArray).equals(parentNum);
        if(cascadeDelete){
            //获得父类型id的子类型id
            String [] parenIdArrays = getByParentId(pbrIdArray);
            if (parenIdArrays != null && parenIdArrays.length > 0) {
                /*将字符串数组类型转换成Integer整数类型数组*/
                Integer [] brandInfIdArrays = new Integer[parenIdArrays.length];
                for (int i = 0; i < pbrIdArray.length; i++) {
                    brandInfIdArrays[i] = Integer.valueOf(parenIdArrays[i]);
                }
                /*删除品牌信息表中的相关数据*/
                deleteResult = brandInfService.batchDeleteBrandInf(brandInfIdArrays, true);
            }
        }
        return deleteResult;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean batchDeleteProductCategory(String[] productCategoryIdArray, boolean cascadeDelete) {
        boolean deleteResult = productCategoryDao.batchDeleteProductCategory(productCategoryIdArray) == productCategoryIdArray.length;
        if(cascadeDelete){
            //删除子类型
            deleteResult = deleteByParentId(productCategoryIdArray, true);
        }
        return deleteResult;
    }
}
