package com.baizhi.service;

import com.baizhi.dao.SectionDao;
import com.baizhi.dao.SpecialDao;
import com.baizhi.entity.Special;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional()
public class SpecialServiceImpl  implements  SpecialService {
    @Autowired
    private SpecialDao specialDao;

    @Autowired
    private SectionDao sectionDao;

    @Override
    public List<Special> queryAllSpecial(int start, int rows) {
        List<Special> specials = specialDao.queryByPage(start, rows);
        return specials;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer total_Special() {
        return specialDao.total();
    }

    @Override
    public void save(Special special) {
        special.setId(UUID.randomUUID().toString());
        specialDao.insert(special);
    }

    @Override
    public void delete(String id) {
        sectionDao.deleteBySpecialId(id);
        specialDao.deleteOneById(id);
    }

    @Override
    public void update(Special special) {

    }

    @Override
    public Special queryOneById(String id) {
        return specialDao.queryOne(id);
    }
}