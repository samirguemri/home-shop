package com.samir.main.shop.facturation;

import com.samir.main.shop.Client;
import com.samir.main.shop.facturation.impression.NoProductException;
import com.samir.main.shop.facturation.impression.Writer;
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
    private Map<Produit, Integer> lesProduits = new HashMap<Produit, Integer>(); // couple{ProduitAcheter,Quantite}
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

    public Facture() {

    }

    /**
     * Retourne le Client assacié à cette facture
     * @return le Client achteur de la facture
     */
    public Client getAcheteur() {
        return acheteur;
    }

    public int getNumero() { return numéro; }

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
     * @return
     */
    public float calculerTotal() {
        for (Produit unProduit: lesProduits.keySet())
            prix += unProduit.getPrix()*lesProduits.get(unProduit);
        prix += livraison.prix();
        return prix;
    }

    /**
     * Pour ajouter un nouveau Produit dans le facture
     * @param produitaAjouter Le Produit à ajouter dans la liste des Produits
     * @param quantite La quantite du produit à ajouter
     */
    public void ajouterProduit(Produit produitaAjouter, int quantite){
            if (lesProduits.containsKey(produitaAjouter))
                lesProduits.put(produitaAjouter,lesProduits.get(produitaAjouter)+quantite);
            else lesProduits.put(produitaAjouter,quantite);
        produitaAjouter.ajouterStock(-quantite);
    }

    /**
     * Pour modifier la quandité d'un des Produit figurant dans lesProduits
     * @param produitAModifier Le produit a modifier
     */
    public void modifierQuantiteProduit(Produit produitAModifier, int nouvelleQuantite){
        lesProduits.put(produitAModifier,nouvelleQuantite);
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
    public void imprimer(Writer writer){
        if(lesProduits.size() == 0)
            throw new NoProductException("Pas de Produits ajoutes .. Impossible de generer la Facture !!");
        calculerTotal();
        writer.start();
        writer.writeLine("HomeShop compagnie\n");
        writer.writeLine("1 Place Charles de Gaulle, 75008 Paris\n");
        writer.writeLine("\n");
        writer.writeLine("Facture à l'attention de :\n");
        writer.writeLine(acheteur.getName()+"\n");
        writer.writeLine(acheteur.getAdresse()+"\n");
        writer.writeLine("\n");
        writer.writeLine("Mode de livraison : "+livraison.getMode()+"\n");
        writer.writeLine("\n");
        writer.writeLine("Produits : \n");
        writer.writeLine("-----------------------------------------------------\n");
        for (Produit unProduit: lesProduits.keySet()) {
            writer.writeLine(unProduit.getNom() + " - " + unProduit.getPrix() + " - " +
                    lesProduits.get(unProduit) + " unité(s)\n");
            writer.writeLine(unProduit.getDescriptif() + "\n");
            writer.writeLine("\n");
        }
        writer.writeLine("Livraison : "+livraison.prix()+"\n");
        writer.writeLine("-----------------------------------------------------\n");
        writer.writeLine("Total : "+prix);
        writer.stop();
    }

}
