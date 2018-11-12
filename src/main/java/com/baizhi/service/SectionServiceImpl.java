package com.baizhi.service;

import com.baizhi.dao.SectionDao;
import com.baizhi.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionDao sectionDao;
    @Override
    public List<Section> findAllByPageAndRows(int start, int rows) {
        return null;
    }

    @Override
    public Integer total() {
        return null;
    }

    @Override
    public void insert(Section section) {
        section.setId(UUID.randomUUID().toString());
        System.out.println(section);
        sectionDao.insert(section);
    }

    @Override
    public void delete(String id) {
        sectionDao.deleteOneById(id);
    }

    @Override
    public Section queryOne(String id) {
        return null;
    }

    @Override
    public void update(Section section) {

    }
}
