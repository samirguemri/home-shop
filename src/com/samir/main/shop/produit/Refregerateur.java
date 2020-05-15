package com.samir.main.shop.produit;

public class Refregerateur extends Produit{
    private int capacite;
    private boolean congelateur;

    /**
     * Constructeur du Refregerateur
     *  @param nom      Le nom du Refregerateur
     * @param prix     Le prix du Refregerateur
     * @param stockDisponible Le stock disponibe du Refregerateur
     * @param capacite La capasite du Refregerateur en Litre
     * @param congelateur est il congelateur
     */
    public Refregerateur(String nom, String descriptif, double prix, int stockDisponible, int capacite, boolean congelateur) {
        super(nom, descriptif, prix, stockDisponible);
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
