package com.yjq.dept.controller;

import com.yjq.common.Controller.BaseController;
import com.yjq.common.ResultEnum;
import com.yjq.common.ResultVO;
import com.yjq.dept.pojo.Department;
import com.yjq.dept.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptController
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/25 0:27
 * @Version 1.0
 */
@Api(tags = "部门接口")
@RestController
@RequestMapping("/depts")
public class DeptController extends BaseController {

    @Autowired
    DeptService deptService;

    @ApiOperation("添加部门")
    @PostMapping
    public Map<String, Object> addDept(@RequestBody @Validated Department dept){
        if(!deptService.checkDeptNameUnique(dept)){
            return ResultVO.failure(ResultEnum.FAILURE.getCode(),"错误！已存在该部门！");
        }else {
            return toResult(deptService.addDept(dept));
        }
    }

    @ApiOperation("获取所有部门")
    @GetMapping
    public Map<String, Object> selectAll(){
        return ResultVO.success(deptService.selectAll());
    }
    @ApiOperation("根据id获取部门")
    @GetMapping("/{deptId}")
    public Map<String, Object> selectByDeptId(@PathVariable("deptId")Integer id){
        return ResultVO.success(deptService.selectByDeptId(id));
    }

    @ApiOperation("根据id删除指定部门")
    @DeleteMapping("/{deptId}")
    public Map<String,Object> deleteByid(@PathVariable("deptId")Integer id){
        int i = deptService.deleteDeptById(id);
        return toResult(i);
    }

    @ApiOperation("更新单个部门信息")
    @PutMapping
    public Map<String,Object> updateDept(@RequestBody @Validated Department dept ){
        int i = deptService.updateDept(dept);
        return toResult(i);
    }

    @ApiOperation("根据部门名称获取部门信息")
    @GetMapping("selectByName")
    public Map<String,Object> selectByName(@Validated Department dept){
        List<Department> department = deptService.selectByname(dept);
        if(StringUtils.isEmpty(dept.getDeptName()) ){
            return ResultVO.success(deptService.selectAll());
        }else{
            return ResultVO.success(department);
        }
    }
}
