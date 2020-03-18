package com.yjq.logistics.dao;

import com.yjq.logistics.pojo.Logistics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogisticsMapper {

    public Logistics selectLogisticsById(Integer id);

    public int insert(Logistics logistics);

    public int updateLogistics(Logistics logistics);

}
