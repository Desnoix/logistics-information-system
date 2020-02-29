package com.yjq.dept.service.impl;

import com.yjq.dept.dao.DepartmentMapper;
import com.yjq.dept.pojo.Department;
import com.yjq.dept.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/25 0:22
 * @Version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public int addDept(Department dept) {
        //添加默认值
        dept.setStatus(1);
        dept.setDeleted(0);
        dept.setCreateTime(new Date());
        return departmentMapper.addDept(dept);
    }

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public Department selectByDeptId(Integer id) {
        return departmentMapper.selectByDeptId(id);
    }

    @Override
    public int updateDept(Department dept) {
        return departmentMapper.updateDept(dept);
    }

    @Override
    public int deleteDeptById(Integer deptId) {
        return departmentMapper.deleteDeptById(deptId);
    }

    @Override
    public boolean checkDeptNameUnique(Department dept) {
        List<Department> department = departmentMapper.selectByDeptName(dept);
        return StringUtils.isEmpty(department);
    }
    @Override
    public List<Department> selectByname(Department deptName) {
        return departmentMapper.selectByDeptName(deptName);
    }
}
