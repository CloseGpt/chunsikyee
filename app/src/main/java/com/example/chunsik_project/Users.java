package com.example.chunsik_project;

public class Users {

    private int user_num;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_uid;
    private int isAdmin;
    private String user_organization;

    public Users(int user_num, String user_id, String user_pw, String user_name, String user_uid, int isAdmin, String user_organization) {
        this.user_num = user_num;
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_uid = user_uid;
        this.isAdmin = isAdmin;
        this.user_organization = user_organization;
    }

    public int getUser_num() {
        return user_num;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_uid() {
        return user_uid;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public String getUser_organization() {
        return user_organization;
    }

    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_uid(String user_uid) {
        this.user_uid = user_uid;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setUser_organization(String user_organization) {
        this.user_organization = user_organization;
    }
}
