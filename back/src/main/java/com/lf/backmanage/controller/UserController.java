package com.lf.backmanage.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lf.backmanage.common.Result;
import com.lf.backmanage.entity.User;
import com.lf.backmanage.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.sql.Wrapper;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping("/save")
    public Result<?> Save(@RequestBody User user)
    {
        if(user.getPassword()==null)
        {
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return Result.success();
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody User user)
    {
        if(user.getPassword()==null)
        {
            user.setPassword("123456");
        }
        userMapper.updateById(user);
        return Result.success();
    }

    @GetMapping("/findPage")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search)
    {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(search!=null && !"".equals(search))
        {
            wrapper.like(User::getNickname,search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize), wrapper);
        return Result.success(userPage);
    }
}
