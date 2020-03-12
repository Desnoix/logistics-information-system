package com.yjq.goods.controller;

import com.yjq.common.Controller.BaseController;
import com.yjq.common.ResultVO;
import com.yjq.common.utils.DateUtils;
import com.yjq.goods.pojo.GoodsType;
import com.yjq.goods.service.GoodsTypeService;
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
 * @Date 2020/3/11 21:29
 * @Version 1.0
 */

@Api(tags = "货物类型接口")
@RestController
@RequestMapping("/goodsTypes")
public class GoodsTypeController extends BaseController {

    @Autowired
    GoodsTypeService goodsTypeService;

    @Autowired
    DateUtils dateUtils;

    @PostMapping
    @ApiOperation("增加物品类型接口")
    public Map<String,Object> addGoods(@RequestBody GoodsType goodsType){
        goodsType.setCreateTime(new Date());
        goodsType.setDeleted(0);
        int insert = goodsTypeService.insert(goodsType);
        return toResult(insert);
    }

    @GetMapping
    @ApiOperation("获取物品类型列表")
    public Map<String,Object> goodsTypeList(@Validated GoodsType goodsType){
        startPage();
        List<GoodsType> goodsTypeList = goodsTypeService.selectGoodsTypeList(goodsType);
        return ResultVO.success(goodsTypeList);
    }
    @GetMapping("/{goodsTypeId}")
    @ApiOperation("获取物品类型列表")
    public Map<String,Object> goodsTypeList(@PathVariable("goodsTypeId") Integer id ){
        GoodsType goodsType = goodsTypeService.selectById(id);
        return ResultVO.success(goodsType);
    }

    @PutMapping
    @ApiOperation("修改物品类型信息")
    public  Map<String,Object> updateGoods(@RequestBody GoodsType goodsType){
        int i = goodsTypeService.updateGoods(goodsType);
        return  toResult(i);
    }

}
