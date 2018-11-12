package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUser(int start, int rows);
    User login(String username, String password);
    Integer total();

    void save(User user);

    void delete(String id);

    void update(User user);

   void queryOneById(String id);
    void updateStatus(User user);
}
