package com.lf.backmanage.service;

import com.github.pagehelper.Page;
import com.lf.backmanage.entity.UserRole;
import com.lf.backmanage.entity.UserRoleCommand;

import java.util.List;
import java.util.Map;

public interface UserRoleService {
    public List<UserRole> findAll();
    public void add(UserRoleCommand userRoleCommand);
    public void update(UserRoleCommand userRoleCommand);
    Page<UserRole> findByPaging(Map param);
}
