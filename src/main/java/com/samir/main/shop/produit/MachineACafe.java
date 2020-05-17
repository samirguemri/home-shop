package com.samir.main.shop.produit;

public class MachineACafe extends Produit {

    /**
     * Constructeur d'un Produit
     *
     * @param nom            Le nom du Produit
     * @param prix           Le prix du Produit
     * @param stockDiponible La quantite disponibe
     */
    public MachineACafe(String nom, String descriptif, double prix, int stockDiponible) {
        super(nom, descriptif, prix, stockDiponible);
    }

    /**
     * Pour consulter le descriptif et voir les detailles du produit
     */
    @Override
    void voir() {

    }
}
