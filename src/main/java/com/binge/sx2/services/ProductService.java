package com.binge.sx2.services;

import com.binge.sx2.beans.Product;
import com.binge.sx2.beans.ShowProduct;
import com.binge.sx2.commons.AjaxResult;
import com.binge.sx2.commons.Page;

import java.util.List;
import java.util.Map;

public interface ProductService {

    /**
     * 查询总数据
     * @param paramMap 传入map参数
     * @return 返回page
     */
    Page queryPage(Map paramMap);

    /**
     * 添加数据
     * @param product 传入商品参数
     * @return
     */
    AjaxResult tosave(Product product);

    /**
     * 删除商品
     * @param id 商品id
     */
    void dodelete(int id);

    /**
     * 通过id查找商品
     * @param id
     * @return
     */
    Product queryProductById(Integer id);

    /**
     * 修改商品
     * @param product
     */
    AjaxResult update(Product product);

    List<ShowProduct> selectAll();
}
