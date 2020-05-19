package com.samir.main.shop.dao;

import com.samir.main.shop.produit.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends ConnectionDB{

    public ProduitDAO(String url, String user, String pwd) {
        super(url, user, pwd);
    }

    public ProduitDAO() {
        super();
    }

    /**
     * Get all products on database
     * @return product list
     */
    public List<Produit> getAllProducts() {
        List<Produit> lesProduits = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            Statement statement = connection.createStatement();
            ResultSet resRequetteSql = statement.executeQuery("select * from Produit ");
            while (resRequetteSql.next()) {
                lesProduits.add(creerNouveauProduit(resRequetteSql));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lesProduits;
    }

    private Produit creerNouveauProduit(ResultSet resRequetteSql) throws SQLException {
        int reference = resRequetteSql.getInt("Prod_id");
        String nom = resRequetteSql.getString("Prod_nom");
        String descriptif = resRequetteSql.getString("Prod_description");
        double prix = resRequetteSql.getDouble("Prod_prix");
        String type = resRequetteSql.getString("Prod_type");
        switch (type){
            case "four":
                return new Four(reference, nom, descriptif, prix);
            case "micro_onde":
                return new MicoOnde(reference, nom, descriptif, prix);
            case "imprimante":
                return new Imprimante(reference, nom, descriptif, prix);
            case "machine_cafe":
                return new MachineACafe(reference, nom, descriptif, prix);
            case "refrigerateur":
                return new Refregerateur(reference, nom, descriptif, prix);
            case "televiseur":
                return new Televiseur(reference, nom, descriptif, prix);
            case "telephone":
                return new Telephone(reference, nom, descriptif, prix);
        }
        return null;
    }
}
