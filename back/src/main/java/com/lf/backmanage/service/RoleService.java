package com.lf.backmanage.service;

import com.github.pagehelper.Page;
import com.lf.backmanage.entity.Role;
import com.lf.backmanage.entity.RoleCommand;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public List<Role> findAll();
    public void add(RoleCommand roleCommand);
    public void update(RoleCommand roleCommand);
    Page<Role> findByPaging(Map param);
}
