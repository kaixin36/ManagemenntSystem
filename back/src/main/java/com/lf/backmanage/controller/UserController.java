package com.lf.backmanage.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lf.backmanage.common.Result;
import com.lf.backmanage.common.util.JwtUtil;
import com.lf.backmanage.entity.User;
import com.lf.backmanage.entity.UserCommand;
import com.lf.backmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController extends  BaseController{

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public Result<?> login(String username, String password, HttpServletResponse res) {
        //假设数据库中查询到了该用户，这里测试先所及生成一个UUID，作为用户的id
        String userId = UUID.randomUUID().toString();

        //准备存放在IWT中的自定义数据
        Map<String, Object> info = new HashMap<>();
        info.put("username", username);
        info.put("password", password);

        //生成JWT字符串
        String token = JwtUtil.sign(userId, info);
        res.setHeader("token",token);
        return Result.success();
    }

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
