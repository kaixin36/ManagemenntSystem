package com.lf.backmanage.mapper;


import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface baseMapper<T> {
    int insert(T t);

    void update(T t);

    T findOneById(int id);

    Page<T> findByPage(Map param);

    List<T> findAll();
}
