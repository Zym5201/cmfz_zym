package com.baizhi.controller;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("guru")
public class GuruController {
    @Resource(name = "guruServiceImpl")
    @Autowired
    private GuruService guruService;
    @RequestMapping("/queryguruByPage")
    public @ResponseBody
    Map<String, Object> queryAllGuru(int page, int rows, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        Integer total = guruService.total_guru();
        List<Guru> gurus = guruService.queryAllGuru((page - 1) * rows, rows);
        result.put("total", total);
        result.put("rows", gurus);

        return result;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String, Object> save(Guru guru, HttpServletRequest request) {
        //获取服务器中路径
        String realPath = request.getSession().getServletContext().getRealPath("/save");
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            guruService.save(guru);
            result.put("success",  true);
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
            guruService.delete(id);
            result.put("success", "true");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", "false");
            result.put("message", e.getMessage());
        }
        return result;
    }

    //修改
    @RequestMapping("/update")
    public @ResponseBody
    Map<String, Object> update(Guru guru) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            guruService.update(guru);
            result.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }


    @RequestMapping("/deleteRows")
    public @ResponseBody
    Map<String, Object> deleteRows(String[] ids, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            for (String id : ids) {
                guruService.delete(id);
            }
            result.put("success", "true");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }


    @RequestMapping("headPicUpload")
    public @ResponseBody
    Map<String, Object> addCarousel(Guru guru, HttpServletRequest request, MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取服务器中路径
        String realPath = request.getSession().getServletContext().getRealPath("/headPicUpload");

        String fileName = file.getOriginalFilename();
        try {
            if (!file.isEmpty()) {



                guru.setHeadPic(file.getOriginalFilename());
                guruService.headPicUpload(guru);

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