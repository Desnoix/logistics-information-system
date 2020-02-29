package com.yjq.dept.service;

import com.yjq.dept.pojo.Department;

import java.util.List;

/**
 * @ClassName DeptService
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/25 0:21
 * @Version 1.0
 */
public interface DeptService {
    /**
     * 添加部门
     * @param name
     * @return
     */
    public int addDept(Department name);
    /**
     * 获取所有部门
     */
    public List<Department> selectAll();
    /**
     * 根据Id获取部门
     */
    public Department selectByDeptId(Integer id);
    /**
     * 修改保存部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(Department dept);

    /**
     * 删除部门管理信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Integer deptId);
    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     * @return 结果
     */
    public boolean checkDeptNameUnique(Department dept);

    /**
     * 根据名字查询部门
     * @param deptName
     * @return
     */
    public List<Department> selectByname(Department deptName);
}
