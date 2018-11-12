package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> queryAllBanner(int start, int rows);

    Integer total_banner();

    void save(Banner banner);

    void delete(String id);

    void update(Banner banner);

    Banner queryOneById(String id);
}
