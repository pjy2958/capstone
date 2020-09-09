package com.example.test1;

public class User {
    private String userID;
    private String userName;
    private String userUniv;
    private String userMajor;

    public User(){
        this.userID = null;
        this.userName = null;
        this.userUniv = null;
        this.userMajor = null;
    }
    public User(String userID, String userName, String userUniv, String userMajor){
        this.userID = userID;
        this.userName = userName;
        this.userUniv = userUniv;
        this.userMajor = userMajor;
    }

    public String getUserUniv() {
        return userUniv;
    }

    public void setUserUniv(String userUniv) {
        this.userUniv = userUniv;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }
}