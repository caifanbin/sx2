package com.binge.sx2.beans;


import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.Min;

/**
 * 展示商品
 */
public class ShowProduct {

    /**
     * 商品id
     */
    @Excel(name = "编号",orderNum = "1",type = 10,width = 5)
    private Integer id;
    /**
     * 商品名称
     */
    @Excel(name = "商品名称",orderNum = "2",width = 15)
    private String productName;
    /**
     * 商品售价
     */
    @Excel(name="售价",orderNum = "3",type = 10,width = 10)
    private Integer price;
    /**
     * 商品类别名称
     */
    @Excel(name = "类别",orderNum = "4",width = 15)
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return "ShowProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
