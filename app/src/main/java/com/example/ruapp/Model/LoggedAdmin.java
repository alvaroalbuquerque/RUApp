package com.example.ruapp.Model;

public class LoggedAdmin {
    private String adminId;
    private String email;
    private String cpf;

    private static final LoggedAdmin ourInstance = new LoggedAdmin();

    public static LoggedAdmin getInstance() {
        return ourInstance;
    }

    private LoggedAdmin() {
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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
}
