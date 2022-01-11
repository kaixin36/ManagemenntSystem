package com.lf.backmanage.service;

import com.github.pagehelper.Page;
import com.lf.backmanage.entity.User;
import com.lf.backmanage.entity.UserCommand;

import java.util.List;
import java.util.Map;

public interface UserService  {

    Page<User> findByPaging(Map param);

    public List<User> findAll();

    public void Add(UserCommand userCommand);

    public void update(UserCommand userCommand);

}
