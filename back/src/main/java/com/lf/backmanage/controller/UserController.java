package com.lf.backmanage.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.User;
import com.lf.backmanage.entity.UserCommand;
import com.lf.backmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping("/delete")
    public Result<?> delete(@RequestBody Integer id) {
        userService.delete(id);
        return Result.success();
    }

    @PostMapping("findByPage")
    public Result<?> findByPage(@RequestBody HashMap param){
        PageHelper.startPage((Integer) param.get("pageNum"), (Integer) param.get("pageSize"));
        Page<User> data = userService.findByPaging(param);
        HashMap resultData = new HashMap();
        resultData.put("data",data);
        resultData.put("pages",data.getPages());
        resultData.put("total",data.getTotal());
        return Result.success(resultData);
    }

}
