package com.example.ruapp.ADMPackage.RegisterRequestPackage;

public class Student {
    private String name;
    private String CPF;
    private String nMatricula;

    public Student(String name, String CPF, String nMatricula) {
        this.name = name;
        this.CPF = CPF;
        this.nMatricula = nMatricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getnMatricula() {
        return nMatricula;
    }

    public void setnMatricula(String nMatricula) {
        this.nMatricula = nMatricula;
    }
}
