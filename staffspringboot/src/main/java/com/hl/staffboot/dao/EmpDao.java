package com.hl.staffboot.dao;

import com.hl.staffboot.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName EmpDao
 * @Description TODO
 * @Author yx
 * @Date 2023/10/24 14:37
 * @Version 1.0
 */
@Repository
public interface EmpDao {
    //查询全部职工
    List<Emp> findEmp();
    //增加职工信息
    int addEmp(Emp emp);
    //修改职工信息
    int updateEmp(Emp emp);
    //删除职工信息
    int deleteEmp(int id);
    //模糊查询
    List<Emp> findByCondition(@Param("empName") String empName,
                              @Param("deptno") Integer deptno,
                              @Param("id") Integer id);
}
