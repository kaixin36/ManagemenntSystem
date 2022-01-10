package com.lf.backmanage.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface baseMapper<T> {
    int insert(T t);
    void update(T t);
    T findOneById(int id);
    List<T> findAll();
}
