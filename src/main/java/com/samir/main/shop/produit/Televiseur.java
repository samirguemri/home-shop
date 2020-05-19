package com.samir.main.shop.produit;

public class Televiseur extends Produit{
    private int tailleEcran;
    private String typeEcran;

    /**
     * Constructeur d'un Televiseur
     *
     * @param nom      Le nom du Televiseur
     * @param prix     Le prix du Televiseur
     * @param stockDisponible Le stock disponibe du Televiseur
     * @param tailleEcran LA taille de l'ecran en pouce
     * @param typeEcran Le type de l'ecran
     */
    public Televiseur(int reference, String type,String nom, String descriptif, double prix, int stockDisponible, int tailleEcran, String typeEcran) {
        super(reference, type, nom, descriptif, prix, stockDisponible);
        this.tailleEcran = tailleEcran;
        this.typeEcran = typeEcran;
    }

    public Televiseur(int reference, String nom, String descriptif, double prix) {
        super(reference, nom, descriptif, prix);
    }

    public int getTailleEcran() {
        return tailleEcran;
    }

    public String getTypeEcran() {
        return typeEcran;
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
