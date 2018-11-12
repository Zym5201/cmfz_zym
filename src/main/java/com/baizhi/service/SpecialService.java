package com.baizhi.service;

import com.baizhi.entity.Special;

import java.util.List;

public interface SpecialService{
    List<Special> queryAllSpecial(int start, int rows);

    Integer total_Special();

    void save(Special special);

    void delete(String id);

    void update(Special special);

    Special queryOneById(String id);
}
