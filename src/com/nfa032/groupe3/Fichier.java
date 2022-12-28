package com.nfa032.groupe3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Fichier {
    String chemin;

    // fin de déclaration des variables

        //renvoie le numéro de la ligne sur laquelle se trouve l'email ; renvoi -1 si la ligne n'est pas trouvée
        public int chercherEmail (String email) throws IOException{
            int j = -1;
            int numeroColonneEmail=0;
            int numeroLigneEmail=0;
            ArrayList<String> header = new ArrayList<String>();

//chercher le numéro de la colonne email
            header = nomColonnes();
            for (int i = 0; i < header.size(); i++) {
 //               System.out.println(header.get(i));
                if (header.get(i).equals("email")) {
                    numeroColonneEmail = i;
                }
 //               else System.out.println("pas égal");
            }
//System.out.println(numeroColonneEmail);
            ArrayList<String> lignes = lignes(chemin);
            System.out.println(lignes);
            System.out.println(lignes.size());

            String emailAComparer ="";
            do {
                j++;
                emailAComparer = separerColonnes(lignes.get(j)).get(numeroColonneEmail);
            }
            //trouver la ligne avec l'email
            while (!(emailAComparer.equals(email)) && (j<lignes.size()-2)) ;

                if(j < lignes.size()-1) {
                    numeroLigneEmail = j;
            }

            return numeroLigneEmail;

        }

    //cette méthode sert à récupérer la première ligne du fichier (l'entête)
    public String entete () throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(chemin));
        return reader.readLine();
        //reader.close();
    }

    //cette méthode sert à lister les intitulés de colonnes du fichier
    public ArrayList<String> nomColonnes () throws IOException{
        String header;
        header = entete();
        int compteur = 0;
        ArrayList<Integer> occurences = new ArrayList<Integer>();
        ArrayList<String> nomsColonnes = new ArrayList<String>();

        //mettre les occurences du pointvirgule dans une liste et compter le nombre de pointvirgules
        for (int i = 0; i < header.length(); i++) {
            if (header.charAt(i) == ';') {
                occurences.add(i);
                compteur += 1;
            }
        }

        //identifier les noms des colonnes
        for (int i = 0; i < (compteur+1); i++) {
            if (i == 0) {
                nomsColonnes.add(header.substring(0, occurences.get(i)));
            }
            if ((i>0) && (i<compteur)){
                nomsColonnes.add(header.substring(occurences.get(i - 1)+1 ,occurences.get(i)));
            }
            if (i == compteur) {
                nomsColonnes.add(header.substring(occurences.get(i-1)+1,header.length()));
            }
        }
        return nomsColonnes;
    }


        //cette méthode sert à séparer les colonnes pour une ligne donnée
    public ArrayList<String> separerColonnes(String ligneASeparer) throws IOException{
        int compteur = 0;
        ArrayList<Integer> occurences = new ArrayList<Integer>();
        ArrayList<String> separerColonnes = new ArrayList<String>();

        //mettre les occurences du pointvirgule dans une liste et compter le nombre de pointvirgules
        for (int i = 0; i < ligneASeparer.length(); i++) {
            if (ligneASeparer.charAt(i) == ';') {
                occurences.add(i);
                compteur += 1;
            }
        }

        //identifier les noms des colonnes
        for (int i = 0; i < (compteur+1); i++) {
            if (i == 0) {
                separerColonnes.add(ligneASeparer.substring(0, occurences.get(i)));
            }
            if ((i>0) && (i<compteur)){
                separerColonnes.add(ligneASeparer.substring(occurences.get(i - 1)+1 ,occurences.get(i)));
            }
            if (i == compteur) {
                separerColonnes.add(ligneASeparer.substring(occurences.get(i-1)+1,ligneASeparer.length()));
            }
        }
        return separerColonnes;
    }

//cette méthode sert à lister les valeurs dans une colonne donnée
    public ArrayList<String> contenuColonnes (int numeroColonne) throws IOException{

        ArrayList<String> contenuColonnes = new ArrayList<>();
        FileReader fr = new FileReader(chemin);
        BufferedReader br = new BufferedReader(fr);
        String ligne = br.readLine();
        while(ligne != null) {
            ligne = br.readLine();
            contenuColonnes.add(separerColonnes(ligne).get(numeroColonne));
        }
        //fermeture propres des flux
        br.close();
        fr.close();
        return contenuColonnes;
    }

    //cette méthode sert à lister toutes les lignes du fichier
    public ArrayList<String> lignes (String chemin) throws IOException {

        ArrayList<String> lignes = new ArrayList<>();
        FileReader fr = new FileReader(chemin);
        BufferedReader br = new BufferedReader(fr);
        String ligne = br.readLine();
        while(ligne != null) {
            ligne = br.readLine();
            lignes.add(ligne);
        }
        //fermeture propres des flux
        br.close();
        fr.close();
        return lignes;
    }

}
