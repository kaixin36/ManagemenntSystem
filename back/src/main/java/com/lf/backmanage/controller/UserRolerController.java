package com.lf.backmanage.controller;

import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.UserRoler;
import com.lf.backmanage.entity.UserRolerCommand;
import com.lf.backmanage.service.UserRolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userroler")
public class UserRolerController {

    @Autowired
    private UserRolerService userRolerService;

    @RequestMapping("/findAll")
    public List<UserRoler> findAll() {
        return userRolerService.findAll();
    }

    @PostMapping("/save")
    public Result<?> Save(@RequestBody UserRolerCommand userRolerCommand) {
        userRolerService.add(userRolerCommand);

        return Result.success();
    }

}
