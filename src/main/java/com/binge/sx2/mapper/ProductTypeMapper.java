package com.binge.sx2.mapper;

import com.binge.sx2.beans.ProductType;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类别mapper
 */
public interface ProductTypeMapper {

    /**
     * 查询所有分类
     * @return
     */
    @Select("select * from producttotype")
    List<ProductType> queryall();


    int saveType(ProductType productType);

    @ResultType(String.class)
    @Select("select typename from producttotype")
    List<String> queryTypeName();
}
