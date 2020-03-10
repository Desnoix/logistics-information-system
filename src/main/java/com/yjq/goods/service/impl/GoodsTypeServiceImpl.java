package com.yjq.goods.service.impl;

import com.yjq.goods.dao.GoodsTypeMapper;
import com.yjq.goods.pojo.GoodsType;
import com.yjq.goods.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsTypeServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/9 21:25
 * @Version 1.0
 */

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public int insert(GoodsType goodsType) {
        return goodsTypeMapper.insert(goodsType);
    }

    @Override
    public int updateGoods(GoodsType goodsType) {
        return goodsTypeMapper.updateGoodsType(goodsType);
    }

    @Override
    public GoodsType selectById(Integer id) {
        return goodsTypeMapper.selectById(id);
    }

    @Override
    public List<GoodsType> selectGoodsTypeList(GoodsType goodsType) {
        return goodsTypeMapper.selectGoodsTypeList(goodsType);
    }
}
