package com.example.ruapp.Model;

public class LoggedStudent {

    private String userId;
    private String fullName;
    private String email;
    private String cpf;
    private String collegeRegister;

    private static final LoggedStudent ourInstance = new LoggedStudent();

    public static LoggedStudent getInstance() {
        return ourInstance;
    }

    private LoggedStudent() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCollegeRegister() {
        return collegeRegister;
    }

    public void setCollegeRegister(String collegeRegister) {
        this.collegeRegister = collegeRegister;
    }
}
