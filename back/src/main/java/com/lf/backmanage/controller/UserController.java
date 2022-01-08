package com.lf.backmanage.controller;

import com.lf.backmanage.entity.User;
import com.lf.backmanage.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping("/save")
    public void Save(@RequestBody User user)
    {
        userMapper.insert(user);
    }
}
