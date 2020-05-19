package com.samir.main.shop.produit;

import java.util.Random;

/**
 * Un produit proposé dans le magasion
 */
public  abstract class Produit {
    protected int reference;
    protected String type;
    protected String nom;
    protected String descriptif ;
    protected double prix;
    protected int stockDiponible;

    /**
     * Constructeur d'un Produit
     * @param nom Le nom du Produit
     * @param descriptif Le descriptif du Produit
     * @param prix Le prix du Produit
     * @param stockDiponible La quantite disponibe
     */
    public Produit(int reference, String type, String nom, String descriptif, double prix, int stockDiponible) {
        this.reference = reference;
        this.type = type;
        this.nom = nom;
        this.descriptif = descriptif;
        this.prix = prix;
        this.stockDiponible = stockDiponible;
    }

    public Produit(int reference, String nom, String descriptif, double prix) {
        this.reference = reference;
        this.nom = nom;
        this.descriptif = descriptif;
        this.prix = prix;
    }

    /**
     *
     * @param quantiteAAjouter La quantite a ajouter dans le Stock Disponible
     */
    public void ajouterStock(int quantiteAAjouter){  stockDiponible += quantiteAAjouter; }

    public String getNom() { return nom; }

    public int getReference() { return reference; }

    public String getDescriptif() { return descriptif; }

    public void setDescriptif(String descriptif) { this.descriptif = descriptif; }

    public double getPrix() { return prix; }

    public int getStockDiponible() { return stockDiponible; }

    public void setPrix(float prix) { this.prix = prix; }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    abstract void voir();
}
