package com.samir.main.shop.produit;

/**
 * Un produit proposé dans le magasion
 */
public abstract class Produit {
    private int reference;
    private String nom;
    private String descriptif ;
    private double prix;
    private int stockDiponible;

    /**
     * Constructeur d'un Produit
     * @param nom Le nom du Produit
     * @param descriptif Le descriptif du Produit
     * @param prix Le prix du Produit
     * @param stockDiponible La quantite disponibe
     */
    public Produit(String nom, String descriptif, double prix, int stockDiponible) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.prix = prix;
        this.stockDiponible = stockDiponible;
    }

    /**
     *
     * @param quantiteAAjouter La quantite a ajouter dans le Stock Disponible
     */
    public void modifierStock(int quantiteAAjouter){  stockDiponible += quantiteAAjouter; }

    public String getNom() {
        return nom;
    }

    public int getReference() {
        return reference;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getStockDiponible() {
        return stockDiponible;
    }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    abstract void voir();
}
