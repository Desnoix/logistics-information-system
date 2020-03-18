package com.yjq.logistics.service;

import com.yjq.logistics.pojo.Logistics;

public interface LogisticsService {

    public Logistics selectLogisticsById(Integer id);

    public int insert(Logistics logistics);

    public int updateLogistics(Logistics logistics);

}
