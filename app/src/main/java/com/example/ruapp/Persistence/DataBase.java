package com.example.ruapp.Persistence;

public class DataBase {
    private static final DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }

    private DataBase() {
    }
}
