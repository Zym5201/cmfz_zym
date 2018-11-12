package com.baizhi.service;


import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService  {
    List<Guru> queryAllGuru(int start, int rows);

    Integer total_guru();

    void save(Guru guru);

    void delete(String id);

    void update(Guru guru);
    void headPicUpload(Guru guru);
    Guru queryOneById(String id);
}
