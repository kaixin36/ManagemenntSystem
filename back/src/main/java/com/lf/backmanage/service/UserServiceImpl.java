package com.lf.backmanage.service;


import com.github.pagehelper.Page;
import com.lf.backmanage.entity.User;
import com.lf.backmanage.entity.UserCommand;
import com.lf.backmanage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService  {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> findByPaging(Map param) {
        return userMapper.findByPage(param);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void Add(UserCommand userCommand) {
      User user =  new User();
      user.setUsername(userCommand.getUsername());
      user.setPassword(userCommand.getPassword());
      user.setNickname(userCommand.getNickname());
      user.setAge(userCommand.getAge());
      user.setSex(userCommand.getSex());
      user.setAddress(userCommand.getAddress());
        if(user.getPassword()==null)
        {
            user.setPassword("123456");
        }
      userMapper.insert(user);
    }

    @Override
    public void update(UserCommand userCommand) {
        User updateUser = userMapper.findOneById(userCommand.getId());
        updateUser.setUsername(userCommand.getUsername());
        updateUser.setPassword(userCommand.getPassword());
        updateUser.setNickname(userCommand.getNickname());
        updateUser.setAge(userCommand.getAge());
        updateUser.setSex(userCommand.getSex());
        updateUser.setAddress(userCommand.getAddress());
        if(updateUser.getPassword()==null)
        {
            updateUser.setPassword("123456");
        }
        userMapper.update(updateUser);
    }

    @Override
    public void delete(Integer id) {
       userMapper.delete(id);
    }
}
