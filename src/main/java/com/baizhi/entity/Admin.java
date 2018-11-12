package com.baizhi.entity;

public class Admin {
    private  String id;
    private  String username;
    private  String password;
    private  String code;

    public Admin() {
    }

    public Admin(String id, String username, String password,  String code) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.code=code;
    }

    public String getId() {
        return id;
    }
    public  String getCode(){return code;}
    public void setId(String id) {
        this.id = id;
    }
    public void setCode(String code){this.code=code;}
    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
