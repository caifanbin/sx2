package com.binge.sx2;

import com.binge.sx2.beans.ProductType;
import com.binge.sx2.beans.Sales;
import com.binge.sx2.services.ProductTypeService;
import com.binge.sx2.services.RegionService;
import com.binge.sx2.services.SalesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Sx2ApplicationTests {

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    SalesService salesService;

    @Autowired
    RegionService regionService;


    @Test
    void inn(){
        List<String> list = regionService.queryRegionName();
        for (String p:list) {
            System.out.println(p);
        }

    }

    @Test
    void contextLoads() {

        List<ProductType> queryall = productTypeService.queryall();
        Map<String,Object> map = new HashMap<>();
        for(ProductType productType :queryall){
            map.put(productType.getTypename(),productType);
        }
        ProductType p = new ProductType();
        p.setTypename("电话");
        int i = productTypeService.saveType(p);
        System.out.println(i);
        System.out.println(p.getId());
    }

}
