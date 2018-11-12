package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private  String id;
    private  String title;
    private  String imgPath;
    private  String descd;
    private  String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date  date;

    public Banner() {
    }

    public Banner(String id, String title, String imgPath, String descd, String status, Date date) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.descd = descd;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescd() {
        return descd;
    }

    public void setDescd(String descd) {
        this.descd = descd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", descd='" + descd + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
