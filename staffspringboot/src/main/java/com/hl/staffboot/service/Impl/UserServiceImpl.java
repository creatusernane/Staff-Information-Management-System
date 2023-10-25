package com.hl.staffboot.service.Impl;

import com.hl.staffboot.dao.EmpDao;
import com.hl.staffboot.dao.UserDao;
import com.hl.staffboot.pojo.Emp;
import com.hl.staffboot.pojo.User;
import com.hl.staffboot.service.EmpService;
import com.hl.staffboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author yx
 * @Date 2023/10/24 16:12
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userName, String pwd) {
        return userDao.login(userName,pwd);
    }
}
