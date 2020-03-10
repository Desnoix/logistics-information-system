package com.yjq.goods.service.impl;

import com.yjq.goods.dao.GoodsMapper;
import com.yjq.goods.pojo.Goods;
import com.yjq.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/9 21:17
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public Goods selectById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> selectGoodsList(Goods goods) {
        return goodsMapper.selectGoodsList(goods);
    }
}
