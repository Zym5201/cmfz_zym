package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
/**为当前类中 所有方法提供缺省的事物配置*/
@Transactional(propagation=Propagation.REQUIRED)
public class AdminServiceImpl implements AdminService {
    @Autowired//将工厂中类型为adminDao的bean 注入
    private AdminDao adminDao;

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Admin login(String username, String password) {
        return adminDao.login(username,password);
    }
    //添加
    @Override
    public void insert(Admin admin) {
        adminDao.insert(admin);
    }
    //
    @Override
    public void updatePassword(Admin admin) {
        adminDao.updatePassword(admin);
    }
}

