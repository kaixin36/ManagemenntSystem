package com.lf.backmanage.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.UserRole;
import com.lf.backmanage.entity.UserRoleCommand;
import com.lf.backmanage.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/findAll")
    public List<UserRole> findAll() {
        return userRoleService.findAll();
    }

    @PostMapping("/save")
    public Result<?> Save(@RequestBody UserRoleCommand userRolerCommand) {
        userRoleService.add(userRolerCommand);

        return Result.success();
    }

    @PutMapping("/update")
    public Result<?> Update(@RequestBody UserRoleCommand userRoleCommand) {
        userRoleService.update(userRoleCommand);
        return Result.success();
    }

    @GetMapping("findByPage")
    public Result<?> findByPage(@RequestBody HashMap param){
        PageHelper.startPage((Integer) param.get("pageNum"), (Integer) param.get("pageSize"));
        Page<UserRole> data = userRoleService.findByPaging(param);
        HashMap resultData = new HashMap();
        resultData.put("data",data);
        resultData.put("pages",data.getPages());
        resultData.put("total",data.getTotal());
        return Result.success(resultData);
    }
}