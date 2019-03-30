package com.example.ruapp.SeeMenuPackage;

public class ItemModel {
    int id;
    String nome;
    double cal;

    public ItemModel(int id, String nome, double cal) {
        this.id = id;
        this.nome = nome;
        this.cal = cal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }
}
