package com.nfa032.groupe3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Compte extends Fichier {

    private String email = null;
    private String mdp = null;
    private String role = null;
    private String login = null;
    // booléens pour Status Admin ou User (false par défaut)
    public boolean isAdmin = false;
    public boolean isUser = false;



    /**
     * contructeur à 3 paramètres
     * @param email
     * @param mdp
     * @param role
     */
    public Compte(String email, String mdp, String role) {
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    public Compte(String login) throws IOException, FileNotFoundException {
        this.login = login;
        // pour test seulement !!!
        System.out.println("pour debug: login renvoyé à comparer dans le fichier compte.txt  : " + login);
        // ouverture du flux lecture
        FileReader fRead = new FileReader("src/files/compte.txt");
        BufferedReader buffRead = new BufferedReader(fRead);

        //la string output doit être initialisée
        String output = "";
        String test = buffRead.readLine();

        while (test != null) {
            //rajout de ligne une par une et d'un espace dans une String output
            output += test + " ";
            //boucle nouvelle ligne
            test = buffRead.readLine();
        }
        // pour test seulement !!!
        System.out.println("pour debug: afficher compte.txt : " + output);

        //permet de splitter à chaque espace dans un tableau de String
        String[] split = output.split("\\s+");

        //balaie le tableau avec un foreach
        for (String e : split) {
            if (e.contains(login + ";ADMIN")) {
                // pour test seulement !!!
                System.out.println("pour debug: est un admin");
                isAdmin = true;
            } else if (e.contains(login + ";USER")) {
                // pour test seulement !!!
                System.out.println("pour debug: est un user");
                isUser = true;
            } else {
                // pour test seulement !!!
                System.out.println("pour debug: n'est ni admin ni user");
            }
        }
    }
}
