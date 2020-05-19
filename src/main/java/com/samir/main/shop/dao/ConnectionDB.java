package com.samir.main.shop.dao;


import java.sql.Connection;

public class ConnectionDB {
    protected String url;// = "jdbc:mysql://localhost/homeshop";
    protected String user;// = "samir";
    protected String pwd;// = "08634454";

    public ConnectionDB(String url, String user, String pwd) {
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public ConnectionDB() {
        url = "jdbc:mysql://localhost/homeshop";
        user = "samir";
        pwd = "08634454";
    }
}
