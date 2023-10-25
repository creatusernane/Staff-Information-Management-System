package com.hl.staffboot.controller;

import com.hl.staffboot.pojo.User;
import com.hl.staffboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yx
 * @Date 2023/10/25 15:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user1){
        User user=userService.login(user1.getUserName(),user1.getPwd());
        System.out.println(user);
        Map<String,Object> map=new HashMap<String, Object>();
        if(user!=null){
            map.put("meg","success");
            map.put("data",user);
        }else{
            map.put("meg","failed");
        }
        return map;
    }
}
