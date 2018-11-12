package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/adm")
public class MenuController {
    @Resource(name="menuServiceImpl")
    private MenuService menuService;

    @RequestMapping("/queryAllMenu")
    public @ResponseBody
    List<Menu> queryAll(){
        List<Menu> menu = menuService.queryAll();
        return menu;
    }
}
