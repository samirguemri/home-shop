package com.samir.main.shop.produit;

public class Televiseur extends Produit{
    private int tailleEcran;
    private String typeEcran;

    /**
     * Constructeur d'un Televiseur
     *
     * @param nom      Le nom du Produit
     * @param prix     Le prix du Produit
     * @param quantite La quantite disponibe
     * @param tailleEcran LA taille de l'ecran en pouce
     * @param typeEcran Le type de l'ecran
     */
    public Televiseur(String nom, float prix, int quantite, int tailleEcran, String typeEcran) {
        super(nom, prix, quantite);
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
