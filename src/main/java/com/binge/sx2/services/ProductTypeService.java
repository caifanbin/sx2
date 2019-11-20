package com.binge.sx2.services;

import com.binge.sx2.beans.ProductType;

import java.util.List;

public interface ProductTypeService {
    /**
     * 查询所有分类
     * @return
     */
    List<ProductType> queryall();

    int saveType(ProductType productType);

    List<String> queryTypeName();
}
