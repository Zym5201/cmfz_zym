package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    private String id;
    private String username;
    private String password;
    private String picture;
    private String dharma_name;
    private String realname;
    private String sex;
    private String city;
    private String province;
    private String signature;
    private String g_id;
    private String status;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    public User() {
    }

    public User(String id, String username, String password, String picture, String dharma_name, String realname, String sex, String city, String province, String signature, String g_id, String status, Date create_date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.dharma_name = dharma_name;
        this.realname = realname;
        this.sex = sex;
        this.city = city;
        this.province = province;
        this.signature = signature;
        this.g_id = g_id;
        this.status = status;
        this.create_date = create_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDharma_name() {
        return dharma_name;
    }

    public void setDharma_name(String dharma_name) {
        this.dharma_name = dharma_name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", dharma_name='" + dharma_name + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", signature='" + signature + '\'' +
                ", g_id='" + g_id + '\'' +
                ", status='" + status + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
