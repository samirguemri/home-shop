package com.samir.main.shop.produit;

public class Telephone extends Produit {
    private double tailleEcran;
    /**
     * Constructeur d'un Produit
     *
     * @param reference
     * @param type
     * @param nom            Le nom du Produit
     * @param descriptif     Le descriptif du Produit
     * @param prix           Le prix du Produit
     * @param stockDiponible La quantite disponibe
     */
    public Telephone(int reference, String type, String nom, String descriptif, double prix,
                     int stockDiponible, double tailleEcran) {
        super(reference, type, nom, descriptif, prix, stockDiponible);
        this.tailleEcran = tailleEcran;
    }

    public Telephone(int reference, String nom, String descriptif, double prix) {
        super(reference, nom, descriptif, prix);
    }

    @Override
    public String toString() {
        return "<FONT size=\"3pt\">"+reference+" - "+"<b>"+nom+"</b>"+" : "+prix+"<br/></FONT>" +
                "<FONT size=\"2pt\">"+descriptif+"<br/></FONT><br/>";
    }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    @Override
    void voir() {

    }
}
