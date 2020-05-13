package com.samir.main.shop.livraison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivraisonPointRelaisTest {

    @Test
    void Given_Livraison22_When_PrixDeLivraison_Then_0e() {
        Livraison livraison = new LivraisonPointRelais(5);
        assertEquals(0.0,livraison.prix(),0.01);
    }

    @Test
    void Given_Livraison23_46_When_PrixDeLivraison_Then_299e() {
        Livraison livraison = new LivraisonPointRelais(30);
        assertEquals(2.99,livraison.prix(),0.01);
    }

    @Test
    void Given_Livraison47etPlus_When_PrixDeLivraison_Then_499e() {
        Livraison livraison = new LivraisonPointRelais(55);
        assertEquals(4.99,livraison.prix(),0.01);
    }
}