package com.example.ruapp.Persistence;

public class DataBase {
    private String httpServer;

    private static final DataBase ourInstance = new DataBase();

    public static DataBase getInstance() {
        return ourInstance;
    }

    private DataBase() {
        httpServer = "http://192.168.203.56/ruapp/";
    }

    public String getHttpServer() {
        return httpServer;
    }

    public void setHttpServer(String httpServer) {
        this.httpServer = httpServer;
    }
    //a
}
