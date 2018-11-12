package com.baizhi.dao;

import com.baizhi.entity.Section;

public interface SectionDao extends BaseDao<Section> {
    void deleteBySpecialId(String special_id);
}
