package com.yjq.goods.dao;

import com.yjq.goods.pojo.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsTypeMapper {

    public int insert(GoodsType goods);

    public int updateGoodsType(GoodsType goods);

    public GoodsType selectById(Integer id);

    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType);

}
