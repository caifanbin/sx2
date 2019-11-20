package com.binge.sx2.beans;


/**
 * 类别地区销售
 */
public class Sales {

    /**
     * 商品id
     */
    private Integer typeid;


    /**
     * 地区id
     */
    private Integer regionid;


    /**
     * 数量
     */
    private Integer sales;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "typeid=" + typeid +
                ", regionid=" + regionid +
                ", sales=" + sales +
                '}';
    }
}
