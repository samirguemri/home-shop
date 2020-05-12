package com.samir.main.shop;

import java.util.Date;
import java.util.Map;

/**
 * La facture produite après l'achat de un ou plusieurs Produit
 */
public class Facture {
    private int numéro;
    private Date dateAchat;
    private Client acheteur;
    private Map<Produit, Integer> lesProduits;
    private Float prix;

    /**
     * Le Seul Constructeur d'une facture
     * @param acheteur Le client qui veut acheter des Produits
     * @param desProduits La liste des Produits à achter
     */
    public Facture(Client acheteur, Map<Produit, Integer> desProduits) {
        dateAchat = new Date();
        this.acheteur = acheteur;
        this.lesProduits = desProduits;
    }

    /**
     * Retourne le Client assacié à cette facture
     * @return le Client achteur de la facture
     */
    public Client getAcheteur() {
        return acheteur;
    }

    /**
     * Retourne a Liste des Produits de la facture
     * @return La liste des Produits de la facture
     */
    public Map<Produit, Integer> getLesProduits() {
        return lesProduits;
    }

    /**
     * Retourne le prix de la facture
     * @return Le prix  de la facture
     */
    public Float getPrix() {
        return prix;
    }

    /**
     * Pour payer la facture
     */
    public void payer(){
        calculerPrix();

    }

    /**
     * Pour calculer la somme totale des Produits de la facture
     * et initialise le prix
     */
    private void calculerPrix() {
    }

    /**
     * Pour ajouter un nouveau Produit dans le facture
     * @param produitaAjouter Le Produit à ajouter dans la liste
     *                       des Produits
     */
    public void ajouterProduit(Produit produitaAjouter){

    }

    /**
     * Pour modifier la quandité d'un des Produit figurant dans lesProduits
     * @param produitAModifier Le produit a modifier
     */
    public void modifierQuantiteProduit(Produit produitAModifier, int nouvelleQuantite){

    }

    /**
     * Pour supprimer un Produit de la liste des Produits
     * Elle modifie l'atrtribut lesProduits
     * @param unProduit
     */
    public void supprimerProduit(Produit unProduit){

    }

}
