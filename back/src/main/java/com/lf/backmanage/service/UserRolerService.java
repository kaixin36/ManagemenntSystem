package com.lf.backmanage.service;

import com.lf.backmanage.entity.UserRoler;
import com.lf.backmanage.entity.UserRolerCommand;

import java.util.List;

public interface UserRolerService {
    public List<UserRoler> findAll();
    public void add(UserRolerCommand userRolerCommand);
    public void update(UserRolerCommand userRolerCommand);
}
