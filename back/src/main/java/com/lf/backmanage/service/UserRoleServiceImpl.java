package com.lf.backmanage.service;


import com.github.pagehelper.Page;
import com.lf.backmanage.entity.UserRole;
import com.lf.backmanage.entity.UserRoleCommand;
import com.lf.backmanage.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("/userRolerService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<UserRole> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void add(UserRoleCommand userRoleCommand) {
        UserRole userRole = new UserRole();
        userRole.setId(userRoleCommand.getId());
        userRole.setName(userRoleCommand.getName());
        userRole.setStatus(userRoleCommand.getStatus());
        userRole.setRemark(userRoleCommand.getRemark());
        userRoleMapper.insert(userRole);
    }

    @Override
    public void update(UserRoleCommand userRoleCommand) {
        UserRole updateUserRole=userRoleMapper.findOneById(userRoleCommand.getId());
        updateUserRole.setName(userRoleCommand.getName());
        updateUserRole.setStatus(userRoleCommand.getStatus());
        updateUserRole.setRemark(userRoleCommand.getRemark());
        userRoleMapper.update(updateUserRole);

    }

    @Override
    public Page<UserRole> findByPaging(Map param) {

            return userRoleMapper.findByPage(param);
        }
    }



