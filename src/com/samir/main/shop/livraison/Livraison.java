package com.samir.main.shop.livraison;

public interface Livraison {
    double prix();
    String getMode();
    void livrer ();
    void livrer(String adresse);
}
