package com.samir.main.shop;

/**
 * Un produit proposé dans le magasion
 */
public class Produit {
    private int reference;
    private String nom;
    private String descriptif;
    private float prix;
    private int quantite;

    /**
     * Constructeur d'un Produit
     * @param nom Le nom du Produit
     * @param prix Le prix du Produit
     * @param quantite La quantite disponibe
     */
    public Produit(String nom, float prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    /**
     * Constructeur d'un Produit
     * @param nom Le nom du Produit
     * @param descriptif Le descriptif du Produit
     * @param prix Le prix du Produit
     * @param quantite La quantite disponibe
     */
    public Produit(String nom, String descriptif, float prix, int quantite) {
        this.nom = nom;
        this.descriptif = descriptif;
        this.prix = prix;
        this.quantite = quantite;
    }

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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    void voir(){
    }

    /**
     * Pour acheter le produit
     * @param facture La Facture à laquelle le Produit doit être ajouté
     * @param quantite La quantité acheté du Produit
     */
    public void acheter(Facture facture, int quantite){
        facture.ajouterProduit(this,quantite);
    }
}
