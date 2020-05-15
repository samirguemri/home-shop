package com.samir.main.shop.livraison;

public class LivraisonADomicileChrono24H implements Livraison{
    String ville;
    private String mode = "livraison à domicile chrono 24H ";

    public String getMode() {
        return mode+prix();
    }

    public LivraisonADomicileChrono24H(String ville) {
        this.ville = ville;
    }

    @Override
    public double prix() {
        if(ville.equals("Paris"))
            return 6.99;
        return 9.99;
    }

    @Override
    public void livrer() {

    }

    @Override
    public void livrer(String adresse) {

    }
}
