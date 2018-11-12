package com.baizhi.controller;

import com.baizhi.entity.Special;
import com.baizhi.service.SpecialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("special")
public class SpecialController {
    @Resource(name="specialServiceImpl")
    private SpecialService specialService;

    @RequestMapping("queryAllSpecial")
    public @ResponseBody Map<String,Object> queryByPageAndRows(int page, int rows){
        Map<String,Object> map = new HashMap<String,Object>();
        Integer total = specialService.total_Special();
        int start = (page-1)*rows;
        List<Special> specials = specialService.queryAllSpecial(start, rows);
        map.put("total",total);

        map.put("rows",specials);
        return map;
    }

    @RequestMapping("queryOne")
    public @ResponseBody Special findOne(String id, HttpServletResponse response)throws  Exception{
        Special special = specialService.queryOneById(id);
        String content=special.getContent_synopsis();
        String content_synopsis = new String(content.getBytes("ISO8859-1"),"utf-8");response.setCharacterEncoding("utf-8");
        special.setContent_synopsis(content_synopsis);
        return special;
    }

    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(Special special, HttpServletRequest request, MultipartFile file){
        Map<String,Object> map = new HashMap<String,Object>();
        String realPath = request.getSession().getServletContext().getRealPath("/special_pic");
        String fileName=file.getOriginalFilename();
        try{
            special.setState("true");
            special.setPic(fileName);
            specialService.save(special);
            file.transferTo(new File(realPath,fileName));
            map.put("success",true);
        }catch(Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/delSpecial")
    public @ResponseBody Map<String,Object> delSpecial(String id) {
        Map<String, Object> map = new HashMap<String,Object>();
        try {
            specialService.queryOneById(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
