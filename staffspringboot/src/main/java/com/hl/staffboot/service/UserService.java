package com.hl.staffboot.service;

import com.hl.staffboot.pojo.User;

public interface UserService {
    //登录
    User login(String userName,String pwd);
}
