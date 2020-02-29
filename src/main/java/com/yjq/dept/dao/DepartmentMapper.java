package com.yjq.dept.dao;

import com.yjq.dept.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    /**
     *
     * @param dept
     * @return
     */
    public int addDept(Department dept);

    /**
     *
     * @param dept
     * @return
     */
    public List<Department> selectByDeptName(Department dept);

    /**
     *
     * @param id
     * @return
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
     * 恢复被删除部门管理信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int restoreDeptById(Integer deptId);

    /**
     * 查找所有部门
     * @return
     */
    public List<Department> selectAll();
}
