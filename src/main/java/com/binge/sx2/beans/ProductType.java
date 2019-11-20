package com.binge.sx2.beans;


/**
 * 类别
 */
public class ProductType {
    /**
     * 类别id
     */
    private Integer id;
    /**
     * 类别名称
     */
    private String typename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}
