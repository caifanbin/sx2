package com.binge.sx2.mapper;

import com.binge.sx2.beans.Product;
import com.binge.sx2.beans.ShowProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 商品mapper
 */
public interface ProductMapper {

     List<ShowProduct> selectAll();

    /**
     * 查询全部数据
     * @param paramMap
     * @return 返回数据集合
     */
    List<ShowProduct> queryList(Map paramMap);

    /**
     * 查询数据总量
     * @param paramMap
     * @return 返回数据总量
     */
    Integer querycount(Map paramMap);


    /**
     * 插入数据
     * @param product
     * @return
     */
    int tosave(Product product);

    /**
     * 删除数据
     * @param id
     */
    @Delete("delete from product where id=#{id}")
    void dodelete(int id);


    /**
     * 通过id查询数据
     * @param id
     * @return
     */
    Product queryProductById(Integer id);

    /**
     * 修改数据
     * @param product
     */
    @Update("update product set productname=#{productname}, price=#{price},type=#{type} where id=#{id}")
    void update(Product product);
}
