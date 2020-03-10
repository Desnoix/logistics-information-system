package com.yjq.goodsTest;

import com.yjq.goods.dao.GoodsMapper;
import com.yjq.goods.dao.GoodsTypeMapper;
import com.yjq.goods.pojo.Goods;
import com.yjq.goods.pojo.GoodsType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @ClassName goodsTest
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/7 23:51
 * @Version 1.0
 */
@SpringBootTest
public class goodsTest {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @Test
    public void test1(){
        Goods goods = new Goods();
        goods.setCreateTime(new Date());
        goods.setGoodsName("测试物品1");
        goods.setDeptId(1);
        goods.setGoodsNumber(new Date().toString());

//        int insert = goodsMapper.insert(goods);

        Goods goods1 = goodsMapper.selectById(1);
        System.out.println(
                goods1
        );
    }
    @Test
    public void test2(){
        Goods goods = new Goods();

//        goods.setDeptId(1);

        goods.setDeptId(1);

        List<Goods> goods1 = goodsMapper.selectGoodsList(goods);

        System.out.println(
                goods1
        );
    }
    @Test
    public void test3(){
        GoodsType goodsType = new GoodsType();
        goodsType.setDeleted(0);
        goodsType.setTypeName("测试1");
        goodsType.setCreateTime(new Date());

        int insert = goodsTypeMapper.insert(goodsType);
        System.out.println(insert);
    }
    @Test
    public void test4(){
        Goods goods = new Goods();
        goods.setId(1);
        goods.setCreateTime(new Date());
        goods.setGoodsName("测试物品2");
        goods.setDeptId(2);
        goods.setGoodsNumber(new Date().toString());

        int insert = goodsMapper.updateGoods(goods);
        System.out.println(insert);
    }
}
