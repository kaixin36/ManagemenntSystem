package com.lf.backmanage.service;

import com.lf.backmanage.entity.User;
import com.lf.backmanage.entity.UserCommand;

import java.util.List;

public interface UserService  {

    public List<User> findAll();

    public void Add(UserCommand userCommand);

    public void update(UserCommand userCommand);

}
