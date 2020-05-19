package com.samir.main.shop.facturation.web;

import com.samir.main.shop.Client;
import com.samir.main.shop.dao.ProduitDAO;
import com.samir.main.shop.facturation.Facture;
import com.samir.main.shop.facturation.impression.Writer;
import com.samir.main.shop.livraison.*;
import com.samir.main.shop.produit.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class FacturationServlet extends HttpServlet {
    List<Produit> listeDesProduits = null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*Produit televiseur = new Televiseur("TV Samsung UE49MU6292",
                "Smart TV LED incurvée 49\"",599.0,10,52,"LCD");
        Produit refregerateur = new Refregerateur("BEKO TSE 1042 F",
                "Réfrigérateur BEKO 130L - Classe A+ - blanc",189.0,8,130,true);
        Produit machineACafe = new MachineACafe("Philips HD7866/61",
                "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses",79.99,20);
        listeDesProduits.add(televiseur);
        listeDesProduits.add(refregerateur);
        listeDesProduits.add(machineACafe);*/
        listeDesProduits = new ProduitDAO().getAllProducts();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String parametresRequette = req.getQueryString();
        if(parametresRequette == null)
            afficherFormulaire(resp);
        else
            genererFacture(req,resp);
    }

    private void afficherFormulaire(HttpServletResponse resp) throws IOException {
        for (int i = 0; i < listeDesProduits.size(); i++) {
            resp.getWriter().println((i+1)+" >> "+(listeDesProduits.get(i)).toString());
        }
        String formulaire = "<form action=\"facturation\">" +
                "<b>nom complet :</b> <input name=\"fullname\"/><br/>" +
                "<b>adresse :</b> <input name=\"address\"/><br/><br/>" +
                "<b>livraison :</b> <br/>" +
                "à domicile : <input type=\"radio\" name=\"deliveryMode\" value=\"direct\"/><br/>" +
                "express : <input type=\"radio\" name=\"deliveryMode\" value=\"express\"/><br/>" +
                "point relais : <input type=\"radio\" name=\"deliveryMode\" value=\"relay\"/><br/>" +
                "à retirer : <input type=\"radio\" name=\"deliveryMode\" value=\"takeAway\"/><br/>" +
                "<b>Informations livraison</b> (relay et express) : <input name=\"deliveryInfo\"/><br/><br/>" +
                "<b>liste produits </b> (produit:quantité, un produit par ligne) : <br/>" +
                "<textarea name=\"products\"ows=\"50\" cols=\"100\"></textarea><br/>" +
                "<input type=\"submit\"/>" +
                "</form>";
        resp.getWriter().println(formulaire);
    }

    /**
     * Pour preparer les elements d'une Facture et
     * pouvoir l'imprimer ligne par ligne via un Writer
     * @param req la HttpServletRequest
     * @param resp la HttpServletResponse
     * @throws IOException
     */
    private void genererFacture(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, String> lesParameters = splitParameters(req.getQueryString());
        Client leClient = new Client(lesParameters.get("fullname"),lesParameters.get("address"));
        Livraison modeLivraison;
        switch (lesParameters.get("deliveryMode")){
            case "direct":
                modeLivraison = new LivraisonADomicile();
                break;
            case "express":
                modeLivraison = new LivraisonADomicileChrono24H(lesParameters.get("deliveryInfo"));
                break;
            case "relay":
                modeLivraison = new LivraisonPointRelais(Integer.parseInt(lesParameters.get("deliveryInfo")));
                break;
            case "takeAway":
                modeLivraison = new RetraitMagasin();
                break;
            default:
                throw new IllegalStateException("Unexpected value deliveryMode");
        }
        Facture laFacture = new Facture(leClient,modeLivraison);
        String[] lesProduitsArray = lesParameters.get("products").split("%0D%0A");
        for (String ligneProduit : lesProduitsArray){
            String[] unProduitUneQuantite = ligneProduit.split("%3A");
            Produit unProduit = listeDesProduits.get(Integer.parseInt(unProduitUneQuantite[0])-1);
            int uneQuantite = Integer.parseInt(unProduitUneQuantite[1]);
            laFacture.ajouterProduit(unProduit,uneQuantite);
        }
        laFacture.imprimer(new Writer() {
            @Override
            public void start() { }

            @Override
            public void writeLine(String line) {
                try {
                    resp.getWriter().println("<br />"+line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void stop() { }
        });
    }

    /**
     * Decouper une String sous forme de Parametres et
     * creer une Map de tout les elements d'une Facture
     * @param parametresRequette la String a decouper
     * @return La Map à retourner
     */
    public HashMap<String, String> splitParameters(String parametresRequette) {
        HashMap<String, String> parametresMap = new HashMap<>();
        String[] parametersList = parametresRequette.split("&");
        for (String param : parametersList) {
            String[] coupleParamVal = param.split("=");
            if (coupleParamVal.length == 2)
                parametresMap.put(coupleParamVal[0], coupleParamVal[1]);
        }
        return parametresMap;
    }
}
