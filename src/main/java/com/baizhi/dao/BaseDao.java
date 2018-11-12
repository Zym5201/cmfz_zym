package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    List<T> queryAll();

    List<T> queryByPage(@Param("start") int start, @Param("rows") int rows);
    T queryOne(String id);
    User login(String username, String password);
    void update(T t);
    void deleteOneById(String id);

    void insert(T t);


    Integer total();

}
