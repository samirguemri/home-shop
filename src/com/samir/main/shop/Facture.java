package com.samir.main.shop;

import com.samir.main.shop.livraison.Livraison;
import com.samir.main.shop.produit.Produit;

import java.util.*;

/**
 * La facture produite après l'achat de un ou plusieurs Produit
 */
public class Facture {
    private int numéro = new Random().nextInt();
    private Date dateAchat = new Date();
    private Client acheteur = null;
    private Map<Produit, Integer> lesProduits = new HashMap<>();
    private float prix = 0;
    private boolean aEtePayer = false;
    private Livraison livraison;

    /**
     * Un Constructeur d'une facture
     * @param acheteur Le client qui veut acheter des Produits
     */
    public Facture(Client acheteur, Livraison livraison) {
        this.acheteur = acheteur;
        this.livraison = livraison;
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
    public float getPrix() {
        return prix;
    }

    /**
     * Pour payer la facture,
     */
    public void payer(){
        aEtePayer = true;
    }

    /**
     * Pour calculer la somme totale des Produits de la facture
     * et initialise le prix
     */
    private void calculerPrix() {
        for (Produit unProduit: lesProduits.keySet())
            prix += unProduit.getPrix()*lesProduits.get(unProduit);
        prix += livraison.prix();

    }

    /**
     * Pour ajouter un nouveau Produit dans le facture
     * @param produitaAjouter Le Produit à ajouter dans la liste des Produits
     * @param quantite La quantite du produit à ajouter
     */
    public void ajouterProduit(Produit produitaAjouter, int quantite){
        lesProduits.put(produitaAjouter,quantite);

    }

    /**
     * Pour modifier la quandité d'un des Produit figurant dans lesProduits
     * @param produitAModifier Le produit a modifier
     */
    public void modifierQuantiteProduit(Produit produitAModifier, int nouvelleQuantite){
        for (Produit unProduit: lesProduits.keySet()){
            if(unProduit.getReference() == produitAModifier.getReference()) {
                lesProduits.replace(unProduit, nouvelleQuantite);
                return;
            }
        }
    }

    /**
     * Pour supprimer un Produit de la liste des Produits
     * Elle modifie l'atrtribut lesProduits
     * @param unProduit
     */
    public void supprimerProduit(Produit unProduit){
        lesProduits.remove(unProduit);
    }

    /**
     * Pour Afficher la Facture : les Produits et leurs quantités respectifs, ainsi que
     * la somme à payer.
     */
    public void imprimer(){
        calculerPrix();
        System.out.println("***** Facture numero : "+ numéro +" *****");
        System.out.println(
                "Ref Produit        | Nom Produit       | Quantité       | Prix U.        | Totale"
        );
        //for(Map.Entry<Produit,Integer> unCouple: lesProduits.entrySet())
        for (Produit unProduit: lesProduits.keySet())
            System.out.println(
                  unProduit.getReference() + "  | " +unProduit.getNom()+ "   | "
                    + lesProduits.get(unProduit) + "  | " + unProduit.getPrix() + "  | "
                    + unProduit.getPrix() * lesProduits.get(unProduit)
            );
    }

}
