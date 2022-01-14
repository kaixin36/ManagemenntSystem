package com.lf.backmanage.service;


import com.github.pagehelper.Page;
import com.lf.backmanage.entity.Role;
import com.lf.backmanage.entity.RoleCommand;
import com.lf.backmanage.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("/userRolerService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void add(RoleCommand roleCommand) {
        Role userRole = new Role();
        userRole.setId(roleCommand.getId());
        userRole.setName(roleCommand.getName());
        userRole.setStatus(roleCommand.getStatus());
        userRole.setRemark(roleCommand.getRemark());
        roleMapper.insert(userRole);
    }

    @Override
    public void update(RoleCommand roleCommand) {
        Role updateUserRole= roleMapper.findOneById(roleCommand.getId());
        updateUserRole.setName(roleCommand.getName());
        updateUserRole.setStatus(roleCommand.getStatus());
        updateUserRole.setRemark(roleCommand.getRemark());
        roleMapper.update(updateUserRole);

    }

    @Override
    public Page<Role> findByPaging(Map param) {

            return roleMapper.findByPage(param);
        }
    }



