package com.binge.sx2.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.binge.sx2.beans.*;
import com.binge.sx2.commons.AjaxResult;
import com.binge.sx2.commons.Page;
import com.binge.sx2.commons.StringUtil;
import com.binge.sx2.services.ProductService;
import com.binge.sx2.services.ProductTypeService;
import com.binge.sx2.services.RegionService;
import com.binge.sx2.services.SalesService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品操作controller
 */
@Controller
public class ShangxuanController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private ProductService productService;


    @Autowired
    private ProductTypeService productTypeService;


    @Autowired
    private RegionService regionService;

    /**
     * 购买跳转
     * @param id 商品id
     * @param session
     * @return
     */
    @RequestMapping("/toshopping")
    public String toshopping(Integer id,HttpSession session){
        Product product = productService.queryProductById(id);
        System.out.println(product);
        session.setAttribute("p",product);
        List<Region> regions = regionService.queryall();
        session.setAttribute("rgs",regions);
        return "redirect:/shopping";
    }


    @GetMapping("/shopping")
    public String shopping(){
        return "shopping";
    }


    /**
     * 购买操作
     * @param sales 购买商品数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/doshopping")
    public Object doshopping(Sales sales){

        System.out.println(sales);
        AjaxResult  result = new AjaxResult();
        try {
            salesService.setsalesbySales(sales);
            result.setMessage("购买成功");
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("购买失败");
        }
        return result;
    }

    /**
     * 修改跳转
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/toupdate")
    public String update(Integer id, HttpSession session){
        List<ProductType> queryall = productTypeService.queryall();
        session.setAttribute("pts",queryall);
        Product product= productService.queryProductById(id);
        session.setAttribute("pds",product);
        return "redirect:/dotodate";
    }



    @ResponseBody
    @RequestMapping("/echarts")
    public EchartsData columnar(){
        EchartsData echartsData = new EchartsData();
        List<ProductType> queryall = productTypeService.queryall();
        List<String> ptname = new ArrayList<>();
        List<List<Integer>> sales = new ArrayList<>();
        for (ProductType productType: queryall) {
            ptname.add(productType.getTypename());
            List<Integer> salesbyid = salesService.querybyTypeId(productType.getId());
            System.out.println(salesbyid.toString());
            sales.add(salesbyid);
        }
        echartsData.setSaleData(sales);
        echartsData.setLegendData(ptname);
    List<String> regionlist = regionService.queryRegionName();
    echartsData.setxAxisData(regionlist);
        return echartsData;
    }


    @RequestMapping("/sales")
    public String sales(HttpSession session){
        List<ProductType> pt = productTypeService.queryall();
        session.setAttribute("pt",pt);
        return "sales";
    }

    @RequestMapping("/dotodate")
    public String dotoupdate(){
        return "update";
    }

    /**
     * 添加跳转
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model){

        List<ProductType> queryall = productTypeService.queryall();
        model.addAttribute("pts",queryall);
        return "add";
    }

    /**
     * 首页跳转
     * @param model
     * @return
     */
    @RequestMapping({"/","/index"})
    public String index(Model model){
        List<ProductType> queryall = productTypeService.queryall();
        model.addAttribute("pts",queryall);
        System.out.println(queryall.toString());
        return "index";
    }

    /**
     * 展示商品
     * @param pageno
     * @param pagesize
     * @param querytype
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object list(@RequestParam(value="pageno",required = false,defaultValue = "1") Integer pageno,
                       @RequestParam(value = "pagesize",required = false,defaultValue = "10") Integer pagesize
                        ,String querytype){
        AjaxResult result = new AjaxResult();
        Map paramMap = new HashMap();
        paramMap.put("pageno",pageno);
        paramMap.put("pagesize",pagesize);
        if(StringUtil.iNotEmpty(querytype)){
            paramMap.put("querytype",querytype);
            System.out.println(querytype);
        }

        try {
            Page page = productService.queryPage(paramMap);
            result.setPage(page);
            result.setSuccess(true);
            System.out.println("1");
        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("查询失败");
        }
        return result;
    }


    /**
     * 添加操作
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("/toadd")
    public Object toadd(Product product){
        System.out.println(product);
        AjaxResult result = new AjaxResult();
        try{
           result = productService.tosave(product);
        }catch (Exception e){
            result.setSuccess(false);
            e.printStackTrace();
            result.setMessage("保存失败");
        }
        return result;
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("dodelete")
    public Object dodelete(int id) {
        AjaxResult result = new AjaxResult();
        try {
            productService.dodelete(id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return result;
    }

    /**
     * 修改操作
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("/doupdate")
    public Object update(Product product){
        System.out.println(product.toString());
        AjaxResult result = new AjaxResult();
        try{
           result =  productService.update(product);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("修改失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/excelOut")
    public Object excelOut() throws IOException {

        AjaxResult result = new AjaxResult();
        try {
            List<ShowProduct> product =  productService.selectAll();
            ExportParams exportParams = new ExportParams();
            exportParams.setSheetName("商品模块");
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams,ShowProduct.class,product);
            File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
            String desktopPath = desktopDir.getAbsolutePath();
            FileOutputStream fos = new FileOutputStream(desktopPath+"/Products.xls");
            System.out.println(desktopPath);
            workbook.write(fos);
            fos.close();
            result.setMessage("导出成功");
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("导出失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/excelIn")
    public Object excelIn(MultipartFile uploadFile) throws Exception {
        AjaxResult result = new AjaxResult();
        try {
            Map<String,Object> map = new HashMap<>();
            List<ProductType> queryall = productTypeService.queryall();
            for(ProductType productType:queryall){
                map.put(productType.getTypename(),productType);
            }
            List<ShowProduct> list = ExcelImportUtil.importExcel(uploadFile.getInputStream(), ShowProduct.class, new ImportParams());
            Product product = new Product();
            for (ShowProduct showProduct : list) {
                if(map.containsKey(showProduct.getTypeName())){
                    product.setProductname(showProduct.getProductName());
                    product.setPrice(showProduct.getPrice());
                    ProductType productType = (ProductType) map.get(showProduct.getTypeName());
                    product.setType(productType.getId());
                    productService.tosave(product);
                }else {
                    ProductType p = new ProductType();
                    p.setTypename(showProduct.getTypeName());
                    int i =productTypeService.saveType(p);
                    product.setProductname(showProduct.getProductName());
                    product.setPrice(showProduct.getPrice());
                    product.setType(i);
                    productService.tosave(product);
                }
            }
            result.setSuccess(true);
            result.setMessage("上传成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("上传失败");
        }
        return result;
    }

}
