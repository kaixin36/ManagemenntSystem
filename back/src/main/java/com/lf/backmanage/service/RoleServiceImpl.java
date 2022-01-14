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


@Service("/RolerService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void add(RoleCommand roleCommand) {
        Role role = new Role();
        role.setId(roleCommand.getId());
        role.setName(roleCommand.getName());
        role.setStatus(roleCommand.getStatus());
        role.setRemark(roleCommand.getRemark());
        roleMapper.insert(role);
    }

    @Override
    public void update(RoleCommand roleCommand) {
        Role updateRole= roleMapper.findOneById(roleCommand.getId());
        updateRole.setName(roleCommand.getName());
        updateRole.setStatus(roleCommand.getStatus());
        updateRole.setRemark(roleCommand.getRemark());
        roleMapper.update(updateRole);

    }

    @Override
    public Page<Role> findByPaging(Map param) {

            return roleMapper.findByPage(param);
        }
    }



