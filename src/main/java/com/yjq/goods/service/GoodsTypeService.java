package com.yjq.goods.service;

import com.yjq.goods.pojo.GoodsType;

import java.util.List;

/**
 * @ClassName GoodsTypeService
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/9 21:16
 * @Version 1.0
 */
public interface GoodsTypeService {

    public int insert(GoodsType goodsType);

    public int updateGoods(GoodsType goodsType);

    public GoodsType selectById(Integer id);

    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType);
}
