package com.binge.sx2.serviceimpl;

import com.binge.sx2.beans.Region;
import com.binge.sx2.mapper.RegionMapper;
import com.binge.sx2.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> queryall() {
        return regionMapper.queryall();
    }

    @Override
    public List<String> queryRegionName() {
        return regionMapper.queryRegionName();
    }
}
