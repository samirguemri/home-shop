package com.samir.main.shop.dao;

import com.samir.main.shop.facturation.Facture;

import java.util.List;

public class FactureDAO extends ConnectionDB{

    public FactureDAO(String url, String user, String pwd) {
        super(url, user, pwd);
    }

    public FactureDAO() {
    }

    /**
     * Get all Bills on database
     * @return Bill list
     */
    public List<Facture> getAll() {
        return null;
    }
}
