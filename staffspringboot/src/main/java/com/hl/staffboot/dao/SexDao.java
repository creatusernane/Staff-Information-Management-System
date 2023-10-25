package com.hl.staffboot.dao;

import com.hl.staffboot.pojo.Sex;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SexDao {
    //查询全部性别
    List<Sex> findSex();
}
