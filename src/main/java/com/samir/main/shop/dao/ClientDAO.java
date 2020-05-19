package com.samir.main.shop.dao;

import com.samir.main.shop.Client;

import java.util.List;

public class ClientDAO extends ConnectionDB{

    public ClientDAO(String url, String user, String pwd) {
        super(url, user, pwd);
    }

    public ClientDAO() {
    }

    /**
     * Get all clients on database
     * @return client list
     */
    public List<Client> getAll() {
        return null;
    }
}
