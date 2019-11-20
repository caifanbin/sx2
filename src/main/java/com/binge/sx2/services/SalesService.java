package com.binge.sx2.services;

import com.binge.sx2.beans.Sales;

import java.util.List;

/**
 * 购买商品数据操作
 */
public interface SalesService {

    boolean querybysales(Sales sales);

    void setsalesbySales(Sales sales);

    void insert(Sales sales);

    List<Integer> querybyTypeId(Integer id);
}
