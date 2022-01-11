package com.lf.backmanage.service;


import com.lf.backmanage.entity.UserRoler;
import com.lf.backmanage.entity.UserRolerCommand;
import com.lf.backmanage.mapper.UserRolerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("/userRolerService")
public class UserRolerServiceImpl implements UserRolerService {
    @Autowired
    private UserRolerMapper userRolerMapper;


    @Override
    public List<UserRoler> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void add(UserRolerCommand userRolerCommand) {
        UserRoler userRoler = new UserRoler();
        userRoler.setId(userRolerCommand.getId());
        userRoler.setName(userRolerCommand.getName());
        userRoler.setStatus(userRolerCommand.getStatus());
        userRoler.setRemark(userRolerCommand.getRemark());
        userRolerMapper.insert(userRoler);
    }

    @Override
    public void update(UserRolerCommand userRolerCommand) {

    }
}
