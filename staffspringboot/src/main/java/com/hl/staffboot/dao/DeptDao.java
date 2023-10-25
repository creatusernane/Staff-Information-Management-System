package com.hl.staffboot.dao;

import com.hl.staffboot.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeptDao {
    //查询全部部门
    List<Dept> findDept();
}
