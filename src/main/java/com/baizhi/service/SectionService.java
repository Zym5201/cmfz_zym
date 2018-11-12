package com.baizhi.service;

import com.baizhi.entity.Section;

import java.util.List;

public interface SectionService {
    List<Section> findAllByPageAndRows(int start, int rows);

    Integer total();

    void insert(Section section);

    void delete(String id);

    Section queryOne(String id);

    void update(Section section);

}
