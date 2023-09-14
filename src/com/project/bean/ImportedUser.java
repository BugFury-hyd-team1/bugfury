package com.project.bean;

import java.util.Date;

public class ImportedUser {
    private int userId;
    private String name;
    private String email;
    private String userType;
    private Date importDate;

    // Constructor
    public ImportedUser(int userId, String name, String email, String userType, Date importDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.importDate = importDate;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "ImportedUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", importDate=" + importDate +
                '}';
    }
}
