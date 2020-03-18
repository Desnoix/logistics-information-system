package com.yjq.logistics.controller;

import com.yjq.common.Controller.BaseController;
import com.yjq.common.ResultVO;
import com.yjq.common.utils.DateUtils;
import com.yjq.goods.pojo.Goods;
import com.yjq.goods.service.GoodsService;
import com.yjq.logistics.pojo.Logistics;
import com.yjq.logistics.service.LogisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LogisticsController
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/3/9 17.33
 * @Version 1.0
 */

@Api(tags = "物流接口")
@RestController
@RequestMapping("/logistics")
public class LogisticsController extends BaseController {

    @Autowired
    LogisticsService logisticsService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    DateUtils dateUtils;

    @PostMapping
    @ApiOperation("添加物流信息")
    public Map<String,Object> addLogistics(@RequestBody Map map){

        System.out.println(map.toString());
        Integer toDeptId = (Integer) map.get("toDeptId");
        Integer deptId = (Integer) map.get("deptId");
        List<Integer> ids = (List) map.get("ids");

        Logistics logistics = new Logistics();
        logistics.setCreateTime(new Date());
        logistics.setStatus(0);
        logistics.setDeleted(0);
        logistics.setFromDeptId(deptId);
        for (Integer id : ids) {
            Goods goods = goodsService.selectById(id);
            goods.setStatus(0);
            goodsService.updateGoods(goods);
            logistics.setGooodsId(id);
            logistics.setToDeptId(toDeptId);
            logistics.setGoodsNumber(dateUtils.getSystemTime());
            logisticsService.insert(logistics);
        }

        return ResultVO.success();
    }


    @GetMapping("/{id}")
    @ApiOperation("获取物流信息")
    public Map<String,Object> goodsTypeList(@PathVariable("id") Integer id ){
        Logistics logistics = logisticsService.selectLogisticsById(id);
        return ResultVO.success(logistics);
    }


    @PutMapping
    @ApiOperation("修改物流信息")
    public  Map<String,Object> updateLogistics(@RequestBody Logistics logistics){
        int i = logisticsService.updateLogistics(logistics);
        return  toResult(i);
    }


    @DeleteMapping("/{ids}")
    @ApiOperation("删除物流信息")
    public Map<String,Object> delLogistics(@PathVariable("ids") Integer[] ids){
        Logistics logistics = new Logistics();
        for(int i = 0;i<ids.length;i++){
            logistics.setId(ids[i]);
            logistics.setDeleted(1);
            logisticsService.updateLogistics(logistics);
        }
        return ResultVO.success();
    }

}
