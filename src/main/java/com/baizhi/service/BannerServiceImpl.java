package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional()
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<Banner> queryAllBanner(int start, int rows) {
        return bannerDao.queryByPage(start, rows);
    }

    @Override
    public Integer total_banner() {
        return bannerDao.total();
    }

    @Override
    public void save(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        bannerDao.insert(banner);
    }

    @Override
    public void delete(String id) {
        bannerDao.deleteOneById(id);
    }

    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public Banner queryOneById(String id) {
        return bannerDao.queryOne(id);
    }
}
