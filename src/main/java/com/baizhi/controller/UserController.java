package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("/queryAllUser")
    public @ResponseBody
    Map<String, Object> queryAllUser(int page, int rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer total = userService.total();
            int start = (page - 1) * rows;
            List<User> users = userService.queryAllUser(start, rows);
            map.put("total", total);
            map.put("rows", users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/deleteOneById")
    public @ResponseBody
    Map<String, Object> deleteById(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userService.delete(id);
            map.put("success","已登录");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/updateStatus")
    public @ResponseBody
    Map<String, Object> editStatus(String id, String status) {
        System.out.println(id);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User user = new User();
            user.setId(id);
            user.setStatus(status);
            userService.updateStatus(user);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/save")
    public @ResponseBody
    Map<String, Object> saveUser(User user, MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        String realpath = request.getSession().getServletContext().getRealPath("user_pic");
        String fileName = file.getOriginalFilename();
        try {
            user.setStatus("true");

            user.setCreate_date(new Date());
            user.setPicture(fileName);
            userService.save(user);
            file.transferTo(new File(realpath, fileName));
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
}


