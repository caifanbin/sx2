package com.binge.sx2.mapper;


import com.binge.sx2.beans.Region;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RegionMapper {

    @Select("select * from region")
    List<Region> queryall();

    @ResultType(String.class)
    @Select("select regionname from region")
    List<String> queryRegionName();
}
