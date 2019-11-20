package com.binge.sx2.beans;

import java.util.List;


/**
 * 图表数据
 */
public class EchartsData {

    /**
     * 类型
     */
    private List<String> legendData;

    /**
     * 地区
     */
    private List<String> xAxisData;

    /**
     * 数据
     */
    private List<List<Integer>> saleData;


    public List<List<Integer>> getSaleData() {
        return saleData;
    }

    public void setSaleData(List<List<Integer>> saleData) {
        this.saleData = saleData;
    }

    public List<String> getLegendData() {
        return legendData;
    }

    public void setLegendData(List<String> legendData) {
        this.legendData = legendData;
    }

    public List<String> getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(List<String> xAxisData) {
        this.xAxisData = xAxisData;
    }

    @Override
    public String toString() {
        return "EchartsData{" +
                "legendData=" + legendData +
                ", xAxisData=" + xAxisData +
                ", saleData=" + saleData +
                '}';
    }
}
