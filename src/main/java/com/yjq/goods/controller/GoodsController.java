package com.yjq.goods.controller;

import com.github.pagehelper.PageInfo;
import com.yjq.common.Controller.BaseController;
import com.yjq.common.ResultVO;
import com.yjq.common.utils.DateUtils;
import com.yjq.goods.pojo.Goods;
import com.yjq.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsController
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/9 21:29
 * @Version 1.0
 */

@Api(tags = "货物接口")
@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    DateUtils dateUtils;

    @PostMapping
    @ApiOperation("增加物品接口")
    public Map<String,Object> addGoods(@RequestBody Goods goods){
        goods.setCreateTime(new Date());
        goods.setGoodsNumber(dateUtils.getSystemTime());
        goods.setStatus(1);
        goods.setDeleted(0);
        int insert = goodsService.insert(goods);
        return toResult(insert);
    }

    @GetMapping
    @ApiOperation("获取物品列表")
    public Map<String,Object> goodsList(@Validated Goods goods){
        startPage();
        List<Goods> goodsList = goodsService.selectGoodsList(goods);
        return ResultVO.success(goodsList,(int)new PageInfo(goodsList).getTotal());
    }


    @GetMapping("/{goodsId}")
    @ApiOperation("获取物品列表")
    public Map<String,Object> goodsTypeList(@PathVariable("goodsId") Integer id ){
        Goods goods = goodsService.selectById(id);
        return ResultVO.success(goods);
    }


    @PutMapping
    @ApiOperation("修改物品信息")
    public  Map<String,Object> updateGoods(@RequestBody Goods goods){
        int i = goodsService.updateGoods(goods);
        return  toResult(i);
    }


    @DeleteMapping("/{ids}")
    @ApiOperation("删除物品")
    public Map<String,Object> delGoodsTpe(@PathVariable("ids") Integer[] ids){
        Goods goods = new Goods();
        for(int i = 0;i<ids.length;i++){
            goods.setId(ids[i]);
            goods.setDeleted(1);
            goodsService.updateGoods(goods);
        }
        return ResultVO.success();
    }

}
