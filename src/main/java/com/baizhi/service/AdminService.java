package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    Admin login(String username,String password);
    void updatePassword(Admin admin);
    void insert(Admin admin);

}
