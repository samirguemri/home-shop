package com.samir.main.shop.produit;

public class MachineACafe extends Produit {
    private String cafe;
    /**
     * Constructeur d'un Produit
     *
     * @param nom            Le nom du Produit
     * @param prix           Le prix du Produit
     * @param stockDiponible La quantite disponibe
     */
    public MachineACafe(int reference, String type,String nom, String descriptif, double prix, int stockDiponible,
                        String cafe) {
        super(reference, type, nom, descriptif, prix, stockDiponible);
        this.cafe = cafe;
    }

    public MachineACafe(int reference, String nom, String descriptif, double prix) {
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
