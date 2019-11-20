package com.binge.sx2.serviceimpl;

import com.binge.sx2.beans.Product;
import com.binge.sx2.beans.ShowProduct;
import com.binge.sx2.commons.AjaxResult;
import com.binge.sx2.commons.Page;
import com.binge.sx2.mapper.ProductMapper;
import com.binge.sx2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService  {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Page queryPage(Map paramMap) {
        Page page = new Page((Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));
        Integer startIndex = page.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<ShowProduct> datas = productMapper.queryList(paramMap);
        Integer totalsize = productMapper.querycount(paramMap);
        page.setDatas(datas);
        page.setTotalsize(totalsize);
        return page;
    }

    @Override
    public AjaxResult tosave(Product product) {
        AjaxResult result = new AjaxResult();
        if(product.getPrice()>0) {
            productMapper.tosave(product);
            result.setSuccess(true);
            result.setMessage("添加成功");
        }else {
            result.setSuccess(false);
            result.setMessage("商品价格不能小于等于0");
        }
        return result;
    }

    @Override
    public void dodelete(int id) {
        productMapper.dodelete(id);
    }

    @Override
    public Product queryProductById(Integer id) {
       return  productMapper.queryProductById(id);

    }

    @Override
    public AjaxResult update(Product product) {
        AjaxResult result = new AjaxResult();
        if(product.getPrice()>0) {
            productMapper.update(product);
            result.setSuccess(true);
            result.setMessage("修改成功");
        }else {
            result.setMessage("商品价格不能小于等于0");
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public List<ShowProduct> selectAll() {
        return productMapper.selectAll();
    }
}
