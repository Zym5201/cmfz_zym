package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin login(@Param("username") String username,@Param("password") String password);

    void insert(Admin admin);
    void updatePassword(Admin admin);

}
