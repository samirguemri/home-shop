package com.samir.main.shop.livraison;

public class LivraisonADomicile implements Livraison{
    @Override
    public double prix() {
        return 4.99;
    }

    @Override
    public void livrer() {

    }

    @Override
    public void livrer(String adresse) {

    }
}
