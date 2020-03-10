package com.yjq.goods.dao;

import com.yjq.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    public int insert(Goods goods);

    public int updateGoods(Goods goods);

    public Goods selectById(Integer id);

    public List<Goods> selectGoodsList(Goods goods);
}
