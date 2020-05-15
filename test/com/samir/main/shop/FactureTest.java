package com.samir.main.shop;

import com.samir.main.shop.impression.ConsoleWriter;
import com.samir.main.shop.impression.FileWriter;
import com.samir.main.shop.impression.Writer;
import com.samir.main.shop.livraison.Livraison;
import com.samir.main.shop.livraison.LivraisonADomicile;
import com.samir.main.shop.livraison.LivraisonPointRelais;
import com.samir.main.shop.produit.MachineACafe;
import com.samir.main.shop.produit.Produit;
import com.samir.main.shop.produit.Refregerateur;
import com.samir.main.shop.produit.Televiseur;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {
    private String writerOutput;
    private Writer writerMock = new Writer() {
        @Override
        public void start() { writerOutput = ""; }

        @Override
        public void writeLine(String line) { writerOutput += line+"%n";}

        @Override
        public void stop() { }
    };

    private Client client = new Client("Juste Leblanc","19 rue Germain Pilon, Paris");
    private Produit televiseur = new Televiseur("TV Samsung UE49MU6292",
            "Smart TV LED incurvée 49\"",599.0,10,52,"LCD");
    private Produit refregerateur = new Refregerateur("BEKO TSE 1042 F",
            "Réfrigérateur BEKO 130L - Classe A+ - blanc",189.0,8,130,true);
    private Produit machineACafe = new MachineACafe("Philips HD7866/61",
            "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses",79.99,20);
    private Livraison livraisonPR = new LivraisonPointRelais(27);
    private Livraison livraisonAD = new LivraisonADomicile();

    @Test
    void Given_2ProduitAcheterAvecLivraisonADomicile_When_CalculerTotal_Then_LeBonPrixTotal() {
        Facture facture = new Facture(client,livraisonAD);
        facture.ajouterProduit(televiseur,1);
        facture.ajouterProduit(refregerateur,1);
        assertEquals(792.99,facture.calculerTotal(),0.01);
    }

    @Test
    void Given_2FoisProduit_When_ModifierQt_Then_3FoisProduit() {
        Facture facture = new Facture();
        facture.ajouterProduit(televiseur,2);
        facture.modifierQuantiteProduit(televiseur,3);
        assertEquals(3,facture.getLesProduits().get(televiseur));
    }

    @Test
    void Given_3ProduitAcheterAvecLivraisonPointRealis_When_Imprimer_Then_NbLineFactureOK() {
        Facture facture = new Facture(client,livraisonPR);
        facture.ajouterProduit(televiseur,1);
        facture.ajouterProduit(refregerateur,1);
        facture.ajouterProduit(machineACafe,1);
        facture.imprimer(writerMock);
        int nbLine = String.format(writerOutput).split("\n").length;
        assertEquals(23,nbLine);
    }

    @Test
    void Given_3ProduitAcheterAvecLivraisonPointRealis_When_Imprimer_Then_FactureOK() {
        Facture facture = new Facture(client,livraisonPR);
        facture.ajouterProduit(televiseur,1);
        facture.ajouterProduit(refregerateur,1);
        facture.ajouterProduit(machineACafe,1);
        facture.imprimer(new FileWriter(facture));
        assertTrue(Files.exists(Paths.get("facture"+facture.getNumero()+".txt")));
    }

    @Test
    void Given_3ProduitAcheterAvecLivraisonPointRealis_When_Imprimer_Then_AffichageConsoleOK() {
        Facture facture = new Facture(client,livraisonPR);
        facture.ajouterProduit(televiseur,1);
        facture.ajouterProduit(refregerateur,1);
        facture.ajouterProduit(machineACafe,1);
        facture.imprimer(new ConsoleWriter());
    }
}
