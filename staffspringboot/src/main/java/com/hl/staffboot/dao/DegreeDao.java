package com.hl.staffboot.dao;

import com.hl.staffboot.pojo.Degree;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DegreeDao {
    //查询全部学历
    List<Degree> findDegree();
}
