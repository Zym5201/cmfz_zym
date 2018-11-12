package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Special {
    private String id;
    private String name;
    private String pic;
    private String author;
    private String broadcast;
    private int collect_number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date issue_date;
    private String content_synopsis;
    private String state;

    private List<Section> children;



    public Special() {
    }

    public Special(String id, String name, String pic, String author, String broadcast, int collect_number, Date issue_date, String content_synopsis, String state, List<Section> children) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.author = author;
        this.broadcast = broadcast;
        this.collect_number = collect_number;
        this.issue_date = issue_date;
        this.content_synopsis = content_synopsis;
        this.state = state;
        this.children = children;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public int getCollect_number() {
        return collect_number;
    }

    public void setCollect_number(int collect_number) {
        this.collect_number = collect_number;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public String getContent_synopsis() {
        return content_synopsis;
    }

    public void setContent_synopsis(String content_synopsis) {
        this.content_synopsis = content_synopsis;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Section> getChildren() {
        return children;
    }

    public void setChildren(List<Section> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Special{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", collect_number=" + collect_number +
                ", issue_date=" + issue_date +
                ", content_synopsis='" + content_synopsis + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                '}';
    }
}
