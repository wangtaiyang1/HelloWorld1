package com.example.administrator.helloworld;


import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String username;
    private String password;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword1() {
        return password;
    }
    public void setPassword1(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ",username=" + username + ", password="
                + password + "]";
    }

}


