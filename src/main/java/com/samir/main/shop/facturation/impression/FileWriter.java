package com.samir.main.shop.facturation.impression;

import com.samir.main.shop.facturation.Facture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter implements Writer{
    private Facture laFacture;
    Path fichier;
    String contenu = "";
    public FileWriter(Facture laFacture) {
        this.laFacture = laFacture;
    }

    /**
     * Start writing process
     */
    @Override
    public void start() {
        String facture = "facture"+laFacture.getNumero()+".txt";
        fichier = Paths.get(facture);
        try {
            Files.createFile(fichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write on line
     *
     * @param line
     */
    @Override
    public void writeLine(String line) {
        contenu += line+"%n";
    }

    /**
     * Stop writing process
     */
    @Override
    public void stop() {
        try {
            Files.write(fichier,String.format(contenu).getBytes(),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
