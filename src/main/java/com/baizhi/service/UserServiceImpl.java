package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(String username, String password) {
       String s = DigestUtils.md5Hex(password);
        User user = userDao.login(username, s);
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAllUser(int start, int rows) {
        List<User> users = userDao.queryByPage(start, rows);
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer total() {
        int total = userDao.total();
        return total;
    }

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        String s = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(s);
        userDao.insert(user);

    }

    @Override
    public void delete(String id) {
        userDao.deleteOneById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void queryOneById(String id) {
        User user = userDao.queryOne(id);

    }

    @Override
    public void updateStatus(User user) {
        userDao.updateStatus(user);
    }
}