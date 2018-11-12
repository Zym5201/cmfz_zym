package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("banner")
public class BannerController {
    @Resource(name = "bannerServiceImpl")
    private BannerService bannerService;

    @RequestMapping("/querybannerByPage")
    public @ResponseBody
    Map<String, Object> queryAllBanner(int page, int rows, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer total = bannerService.total_banner();
        List<Banner> banners = bannerService.queryAllBanner((page - 1) * rows, rows);
        System.out.println(banners);
        result.put("total", total);
        result.put("rows", banners);

        return result;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String, Object> save(Banner banner, HttpServletRequest request, MultipartFile file) {
        //获取服务器中路径
        String realPath = request.getSession().getServletContext().getRealPath("/save");
        Map<String, Object> result = new HashMap<String, Object>();


        String fileName = file.getOriginalFilename();
        try {

            banner.setImgPath(file.getOriginalFilename());

            bannerService.save(banner);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/deleteOne")
    public @ResponseBody
    Map<String, Object> deleteOne(String id) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            bannerService.delete(id);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    //删除
    @RequestMapping("/update")
    public @ResponseBody
    Map<String, Object> update(Banner banner, HttpServletRequest request, MultipartFile file) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            //获取服务器中路径
            String realPath = request.getSession().getServletContext().getRealPath("/save");
            banner.setDate(new Date());
            banner.setImgPath(file.getOriginalFilename());
            bannerService.update(banner);
            result.put("success", "true");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", "false");
            result.put("message", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public @ResponseBody
    Banner queryOneById(String id) {
        return bannerService.queryOneById(id);
    }

    @RequestMapping("/deleteRows")
    public @ResponseBody
    Map<String, Object> deleteRows(String[] ids, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            for (String id : ids) {
                bannerService.delete(id);
            }
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }
    //头像上传
    @RequestMapping("headPicUpload")
    public @ResponseBody
    Map<String, Object> addCarousel(Banner banner, HttpServletRequest request, MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取服务器中路径
        String realPath = request.getSession().getServletContext().getRealPath("/headPicUpload");

        String fileName = file.getOriginalFilename();
        try {
            if (!file.isEmpty()) {
                banner.setTitle(fileName);
                banner.setDate(new Date());
                banner.setImgPath(file.getOriginalFilename());

                bannerService.save(banner);

                map.put("success", true);
            } else {
                map.put("success", false);
                map.put("message", "上传的图片不能为空!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}