package com.yjq.logistics.service.impl;

import com.yjq.logistics.dao.LogisticsMapper;
import com.yjq.logistics.pojo.Logistics;
import com.yjq.logistics.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LogisticsServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/17 17:31
 * @Version 1.0
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    LogisticsMapper logisticsMapper;

    @Override
    public Logistics selectLogisticsById(Integer id) {
        return logisticsMapper.selectLogisticsById(id);
    }

    @Override
    public int insert(Logistics logistics) {
        return logisticsMapper.insert(logistics);
    }

    @Override
    public int updateLogistics(Logistics logistics) {
        return logisticsMapper.updateLogistics(logistics);
    }
}
