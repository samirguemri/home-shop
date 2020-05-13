package com.samir.main.shop.livraison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivraisonADomicileChrono24HTest {

    @Test
    void Given_LivraisonParis_When_prixLivraison_Then_699e() {
        Livraison livraison = new LivraisonADomicileChrono24H("Paris");
        assertEquals(6.99,livraison.prix(),0.01);
    }

    @Test
    void Given_LivraisonEndehorsParis_When_prixLivraison_Then_999e() {
        Livraison livraison = new LivraisonADomicileChrono24H("Nice");
        assertEquals(9.99,livraison.prix(),0.01);
    }
}