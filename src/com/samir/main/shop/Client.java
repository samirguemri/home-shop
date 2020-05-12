package com.samir.main.shop;

/**
 * Le Client de notre magasin
 */
public class Client {
    private int reference;
    private String name;
    private String adresse;
    private int telephone;
    private Facture[] factures;

    /**
     * Constructeur d'un Client
     * @param name Le nom du Client
     * @param adresse L'adresse du Client
     */
    public Client(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    /**
     * Modifier l'adresse du Client
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Modifier le telephone du Client
     * @param telephone
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public Facture[] getFactures() {
        return factures;
    }

}
