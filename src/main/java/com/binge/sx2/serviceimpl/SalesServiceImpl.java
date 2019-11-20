package com.binge.sx2.serviceimpl;

import com.binge.sx2.beans.Sales;
import com.binge.sx2.mapper.SalesMapper;
import com.binge.sx2.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;
    @Override
    public boolean querybysales(Sales sales) {
        if (salesMapper.querybysales(sales) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void setsalesbySales(Sales sales) {
        salesMapper.setsalebySales(sales);
    }

    @Override
    public void insert(Sales sales) {

        salesMapper.insert(sales);
    }

    @Override
    public List<Integer> querybyTypeId(Integer id) {
        return salesMapper.querybyTypeId(id);
    }
}
