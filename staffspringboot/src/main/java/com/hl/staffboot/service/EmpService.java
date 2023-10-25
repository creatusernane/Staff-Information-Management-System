package com.hl.staffboot.service;

import com.hl.staffboot.pojo.Emp;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface EmpService {
    //查询所有
    List<Emp> findEmp();
    //增加职工信息
    String addEmp(Emp emp);
    //修改职工信息
    String updateEmp(Emp emp);
    //删除职工信息
    String deleteEmp(int id);
    //模糊查询
    List<Emp> findByCondition(String empName,
                              Integer deptno,
                              Integer id);
}
