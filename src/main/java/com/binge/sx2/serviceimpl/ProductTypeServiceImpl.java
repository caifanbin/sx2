package com.binge.sx2.serviceimpl;

import com.binge.sx2.beans.ProductType;
import com.binge.sx2.mapper.ProductTypeMapper;
import com.binge.sx2.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> queryall() {
        return productTypeMapper.queryall();
    }

    @Override
    public int saveType(ProductType productType) {
        return productTypeMapper.saveType(productType);
    }

    @Override
    public List<String> queryTypeName() {
        return productTypeMapper.queryTypeName();
    }
}
