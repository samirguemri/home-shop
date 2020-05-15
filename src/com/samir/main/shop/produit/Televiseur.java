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
    public Televiseur(String nom, String descriptif, double prix, int stockDisponible, int tailleEcran, String typeEcran) {
        super(nom, descriptif, prix, stockDisponible);
        this.tailleEcran = tailleEcran;
        this.typeEcran = typeEcran;
    }

    public int getTailleEcran() {
        return tailleEcran;
    }

    public String getTypeEcran() {
        return typeEcran;
    }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    @Override
    void voir() {

    }
}
