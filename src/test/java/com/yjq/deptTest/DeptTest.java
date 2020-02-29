package com.yjq.deptTest;

import com.yjq.dept.dao.DepartmentMapper;
import com.yjq.dept.pojo.Department;
import com.yjq.dept.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName DeptTest
 * @Author GDMZ_jqyang@outlook.com
 * @Description
 * @Date 2020/2/25 0:16
 * @Version 1.0
 */
@SpringBootTest
public class DeptTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    DeptService deptService;
    @Test
    public void test1(){
        Department department = new Department();
        department.setDeptName("测试");
        int i = deptService.addDept(department);

        System.out.println(department);
        System.out.println(i);
    }
    @Test
    public void test2(){
        Department department = new Department();
        department.setDeptName("2311232");
        Department department1 = departmentMapper.selectByDeptName(department);
        System.out.println(StringUtils.isEmpty(department1));
    }
    @Test
    public void test3(){
        Department department = new Department();
        department.setId(1);
        department.setDeptName("广州仓库");
        department.setStatus(1);
        int department1 = departmentMapper.updateDept(department);
        System.out.println(department1);
    }

    @Test
    public void test4(){
        int department1 = departmentMapper.deleteDeptById(7);
        System.out.println(department1);
    }
    @Test
    public void test5(){
        List<Department> department1 = departmentMapper.selectAll();
        System.out.println(department1);
    }
}
