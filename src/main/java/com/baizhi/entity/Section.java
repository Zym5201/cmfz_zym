package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Section {
    private String id;
    private String name;
    private String size;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date release_date;
    private String path;
    private String duration;
    private String se_type;
    private String special_id;
    private String parent_Id;

    public Section() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSe_type() {
        return se_type;
    }

    public void setSe_type(String se_type) {
        this.se_type = se_type;
    }

    public String getSpecial_id() {
        return special_id;
    }

    public void setSpecial_id(String special_id) {
        this.special_id = special_id;
    }

    public String getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(String parent_Id) {
        this.parent_Id = parent_Id;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", release_date=" + release_date +
                ", path='" + path + '\'' +
                ", duration='" + duration + '\'' +
                ", se_type='" + se_type + '\'' +
                ", special_id='" + special_id + '\'' +
                ", parent_Id='" + parent_Id + '\'' +
                '}';
    }
}

