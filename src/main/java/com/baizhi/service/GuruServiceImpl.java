package com.baizhi.service;


import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional()
public class GuruServiceImpl implements GuruService {
    @Autowired
    private  GuruDao guruDao;
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Guru> queryAllGuru(int start, int rows) {
        return guruDao.queryByPage(start, rows);
    }

    @Override
    public Integer total_guru() {
        return guruDao.total();
    }

    @Override
    public void save(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);


    }

    @Override
    public void delete(String id) {
        guruDao.deleteOneById(id);

    }

    @Override
    public void update(Guru guru) {
    guruDao.update(guru);
    }

    @Override
    public void headPicUpload(Guru guru) {
        guruDao.headPicUpload(guru.getId(),guru.getHeadPic());
    }

    @Override
    public Guru queryOneById(String id) {
        return guruDao.queryOne(id);
    }
}