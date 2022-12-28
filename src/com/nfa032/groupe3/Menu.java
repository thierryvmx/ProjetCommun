// Contributeurs au projet commun CNAM NFA032 groupe 3 par ordre alphabétique :
// AIT BRAHIM Soufyane / DELACOUR Marie-Laure / MARIE MAPAGA Jin-Ange / STRAGIER Arnaud / VISVAL Thierry

package com.nfa032.groupe3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Scanner;

/**
 * Classe principale de lancement du programme
 */
public class Menu {

    static char choixA = 0;
    static int choixN = 0;

    public static void main(String[] args) throws IOException, InterruptedIOException {

        Scanner myInput = new Scanner(System.in);

        System.out.println("\t\tBienvenue dans l'annuaire NFA032\n");
        System.out.println("1. Ajouter une personne");
        System.out.println("2. Rechercher un ou des particuliers");
        System.out.println("3. Modifier mes informations personnelles");
        System.out.print("\nFaites votre choix : ");
        choixN = myInput.nextInt();


        switch (choixN) {
            case (1):
                Compte monCompteAdmin = new Compte(monLogin());
                if (monCompteAdmin.isAdmin == true) {
                    System.out.println("vous êtes bien administrateur !");
                } else {
                    System.out.println("désolé vous n'êtes pas administrateur ! Au revoir !");
                    break;
                }
                System.out.println("A. Ajouter un Admin");
                System.out.println("B. Ajouter un particulier");
                choixA = myInput.next().charAt(0);

                switch (choixA) {
                    case 'A':
                        System.out.println("Ajouter un Admin n'est pas disponible. Revenez plus tard =)\n");
                        // TODO: à implémenter !
                        break;

                    case 'B':
                        System.out.println("Ajouter un particulier n'est pas disponible. Revenez plus tard =)\n");
                        // TODO: à implémenter !
                        break;

                    default:
                        System.out.println("Choix impossible ! Veuillez saisir une lettre majuscule valide svp.");
                        break;
                }
                break;

            case (2):
                System.out.println("A. par nom");
                System.out.println("B. par email");
                System.out.println("C. par profil");
                choixA = myInput.next().charAt(0);

                switch (choixA) {
                    case 'A':
                        System.out.println("Rechercher par nom n'est pas disponible. Revenez plus tard =)\n");
                        // TODO: à implémenter !
                        break;

                    case 'B':
                        System.out.println("Rechercher par email n'est pas disponible. Revenez plus tard =)\n");
                        // TODO: à implémenter !
                        break;

                    case 'C':
                        System.out.println("Rechercher par profil n'est pas disponible. Revenez plus tard =)\n");
                        // TODO: à implémenter !
                        break;

                    default:
                        System.out.println("Choix impossible ! Veuillez saisir une lettre majuscule valide svp.");
                        break;
                }
                break;

            case (3):
                Compte monCompte = new Compte(monLogin());
                if (monCompte.isAdmin == true) {
                    System.out.println("vous êtes administrateur. Vous pouvez modifier votre compte et tous les autres.");
                } else if (monCompte.isUser == true) {
                    System.out.println("vous êtes utilisateur. Vous ne pouvez modifier que votre compte.");
                } else {
                    System.out.println("vous n'êtes ni administrateur ni utilisateur ! Au revoir !");
                    break;
                }
                System.out.println("Modifier les informations personnelles n'est pas disponible. Revenez plus tard =)\n");
                // TODO: à implémenter !
                break;

            default:
                System.out.println("Choix impossible ! Veuillez saisir un numéro valide svp.");
                break;
        }
    }

    /**
     * Fonction de saisie email et mot de passe
     * @return concaténation mail & mdp
     */
    private static String monLogin() {
        String monMail = null;
        String monMdp = null;
        String mailEtMdp = null;
        Scanner myInput = new Scanner(System.in);
        System.out.println("Vous devez vous identifier pour accéder à cette fonctionnalité.");
        System.out.print("Veuillez saisir votre mail : ");
        monMail = myInput.nextLine();
        System.out.print("Veuillez saisir votre mot de passe : ");
        monMdp = myInput.nextLine();
        mailEtMdp = monMail + ';' + monMdp;
        return mailEtMdp;
    }

}


