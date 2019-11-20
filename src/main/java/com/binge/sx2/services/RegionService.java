package com.binge.sx2.services;

import com.binge.sx2.beans.Region;

import java.util.List;

/**
 * 发货地区操作
 */
public interface RegionService {
    List<Region> queryall();

    List<String> queryRegionName();
}
