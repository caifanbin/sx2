package com.binge.sx2.beans;

/**
 * 商品
 */
public class Product {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String productname;
    /**
     * 商品售价
     */
    private Integer price;
    /**
     * 商品类别
     */
    private Integer type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
