package com.samir.main.shop.livraison;

public class RetraitMagasin implements Livraison {
    private String mode = "retrait magasin";

    public String getMode() {
        return mode;
    }
    @Override
    public double prix() {
        return 0;
    }

    @Override
    public void livrer() {

    }

    @Override
    public void livrer(String adresse) {

    }
}
