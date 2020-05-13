package com.samir.main.shop.produit;

public class Refregerateur extends Produit{
    private int capacite;
    private boolean congelateur;

    /**
     * Constructeur d'un Produit
     *  @param nom      Le nom du Produit
     * @param prix     Le prix du Produit
     * @param quantite La quantite disponibe
     * @param capacite La capasite du Refregerateur en Litre
     * @param congelateur est il congelateur
     */
    public Refregerateur(String nom, float prix, int quantite, int capacite, boolean congelateur) {
        super(nom, prix, quantite);
        this.capacite = capacite;
        this.congelateur = congelateur;
    }

    public int getCapacite() {
        return capacite;
    }

    public boolean isCongelateur() {
        return congelateur;
    }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    @Override
    void voir() {

    }
}
