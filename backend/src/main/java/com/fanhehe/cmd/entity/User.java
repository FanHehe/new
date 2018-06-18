package com.fanhehe.cmd.entity;

public class User {
    private long id = 0;
    private String userName = "fanhehe";
    private transient String password = "not noll";

    public User () {}

    public User (long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Override
    public String toString () {
        return "User [id = " + id + " userName = " + userName + " password = " + password + "]";
    }
}
