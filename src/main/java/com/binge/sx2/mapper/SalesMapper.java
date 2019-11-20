package com.binge.sx2.mapper;

import com.binge.sx2.beans.Sales;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SalesMapper {

    @Select("select sales from sales where typeid=#{typeid} and regionid=#{regionid}")
    Sales querybysales(Sales sales);


    @Update("update sales set sales=sales+1 where typeid=#{typeid} and regionid=#{regionid}")
    void setsalebySales(Sales sales);

    @Insert("insert into sales (typeid,regionid,sales) values (#{typeid},#{regionid},1)")
    void insert(Sales sales);


    @ResultType(Integer.class)
    @Select("select sales from sales where typeid=#{id} order by regionid asc")
    List<Integer> querybyTypeId(Integer id);
}
