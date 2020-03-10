package com.yjq.goods.service;

import com.yjq.goods.pojo.Goods;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/9 21:16
 * @Version 1.0
 */
public interface GoodsService {

    public int insert(Goods goods);

    public int updateGoods(Goods goods);

    public Goods selectById(Integer id);

    public List<Goods> selectGoodsList(Goods goods);
}
