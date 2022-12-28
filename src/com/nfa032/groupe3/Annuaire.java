package com.nfa032.groupe3;

import java.io.File;

public class Annuaire extends Fichier {

    private String nom;
    private String prenom;
    private String email;
    private String adressePostale;
    private String dateNaissance;
    private String profil;
    private String dateAjout;
    private String dateMaj;

    //constructeur
    public Annuaire() {
        this.chemin = new File("").getAbsolutePath() + "src/files/annuaire.txt";
    }
}