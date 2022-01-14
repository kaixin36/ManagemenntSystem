package com.lf.backmanage.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.Role;
import com.lf.backmanage.entity.RoleCommand;
import com.lf.backmanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    private RoleService userRoleService;

    @RequestMapping("/findAll")
    public List<Role> findAll() {
        return userRoleService.findAll();
    }

    @PostMapping("/save")
    public Result<?> Save(@RequestBody RoleCommand userRolerCommand) {
        userRoleService.add(userRolerCommand);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<?> Update(@RequestBody RoleCommand roleCommand) {
        userRoleService.update(roleCommand);
        return Result.success();
    }

    @GetMapping("findByPage")
    public Result<?> findByPage(@RequestBody HashMap param){
        PageHelper.startPage((Integer) param.get("pageNum"), (Integer) param.get("pageSize"));
        Page<Role> data = userRoleService.findByPaging(param);
        HashMap resultData = new HashMap();
        resultData.put("data",data);
        resultData.put("pages",data.getPages());
        resultData.put("total",data.getTotal());
        return Result.success(resultData);
    }
}