package com.hl.staffboot.dao;

import com.hl.staffboot.pojo.Sex;
import com.hl.staffboot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //登录
    User login(@Param("userName") String userName,@Param("pwd") String pwd);
}
