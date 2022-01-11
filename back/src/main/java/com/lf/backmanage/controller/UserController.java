package com.lf.backmanage.controller;

import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.User;
import com.lf.backmanage.entity.UserCommand;
import com.lf.backmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public Result<?> Save(@RequestBody UserCommand userCommand) {
        userService.Add(userCommand);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody UserCommand userCommand) {
        userService.update(userCommand);
        return Result.success();
    }
}
