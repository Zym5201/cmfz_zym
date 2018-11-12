package com.baizhi.entity;

import java.util.List;

public class Menu {
    private int id;
    private String name;
    private String iconCls;
    private String url;
    private String parent_id;
    private List<Menu> menus;

    public Menu() {
    }

    public Menu(int id, String name, String iconCls, String url, String parent_id, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.url = url;
        this.parent_id = parent_id;
        this.menus = menus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
