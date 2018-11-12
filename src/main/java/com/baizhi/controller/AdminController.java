package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
/**@Controller: 修饰范围:  用在类上    作用: 用来实例化这个类对象  标识这个类是一个控制器*/
@Controller
/**
 * @RequestMapping
 *    修饰范围:  用在类上  方法上
 *    	作用: 用在类上 相当于struts2中namespace 给类中所有方法加入同一请求路径
 *    	           用在方法上相当于strtus2 中action的name属性 用来给方法加入请求路径
 */
/**
 * @RequestMapping
 * 	 修饰范围:  用在方法上    作用:用来给方法加入一个请求路径
 * 	 value属性: 用来指定具体的请求路径
 *  访问路径:  http://localhost:8989/springmvc_day1/hello
 */
@RequestMapping("/admin")
public class AdminController {
    //指定注入
    @Resource(name="adminServiceImpl")
    private AdminService adminService;

    @RequestMapping("login")
    public String login(String username, String password, String enCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String validationCode = (String) session.getAttribute("authCode");
        Admin admin = adminService.login(username, password);
        if (admin != null && enCode.equalsIgnoreCase(validationCode)) {
            session.setAttribute("login_admin", admin);
            return "/back/main/main";
        } else {
            return "/back/admin/login";
        }
    }


    //退出登录
    @RequestMapping("outlogin")
    public String outlogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "/back/admin/login";
    }


    @RequestMapping("updatePassword")
    public @ResponseBody
    Map<String,Object> updatePassword(String oldPassword, String newPassword, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            HttpSession session = request.getSession();
            Admin login_admin = (Admin) session.getAttribute("login_admin");
            if (login_admin.getPassword().equals(oldPassword)) {
                login_admin.setPassword(newPassword);
                adminService.updatePassword(login_admin);
                session.invalidate();
                map.put("success",true);
            }else{
                map.put("success",false);
                map.put("message","输入密码有误!!!");
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
}

