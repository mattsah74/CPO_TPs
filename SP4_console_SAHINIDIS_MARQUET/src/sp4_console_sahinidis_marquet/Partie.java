/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author louis & matthieu
 */
public class Partie {

    Joueur Listejoueurs[] = new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleDeJeu = new Grille();
    
    void attribuerCouleursAuxJoueurs() {
        Random r = new Random();
        boolean couleur;
        couleur = r.nextBoolean();
        if (couleur) {
            Listejoueurs[0].Couleur = "Rouge";
            Listejoueurs[1].Couleur = "Jaune";
        } else {
            Listejoueurs[0].Couleur = "Jaune";
            Listejoueurs[1].Couleur = "Rouge";
        }
    }

    Joueur ProchainJoueur(Joueur un_joueur) {
        if (Listejoueurs[0] == JoueurCourant) {
            return Listejoueurs[1];
        }
        return Listejoueurs[0];
    }

    void initialiserPartie() {
        //Mise en place de la grille
        grilleDeJeu.viderGrille();

        //Création des joueurs
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du J1 :");
        Joueur J1 = new Joueur(sc.nextLine());
        System.out.println("Choix du pseudo du J2 :");
        Joueur J2 = new Joueur(sc.nextLine());
        Listejoueurs[0] = J1;
        Listejoueurs[1] = J2;

        attribuerCouleursAuxJoueurs();

        System.out.println(J1.Nom + " est de couleur " + J1.Couleur);
        System.out.println(J2.Nom + " est de couleur " + J2.Couleur);

        // On donne des jetons aux joueurs
        for (int i = 0; i < 21; i++) {

            Jeton J = new Jeton(Listejoueurs[0].Couleur);

            J1.ajouterJeton(J);

            J2.ajouterJeton(new Jeton(J2.Couleur));
        }

        // Determine qui est le premier joueur
        Random r = new Random();
        boolean le_premier = r.nextBoolean();
        if (le_premier) {
            JoueurCourant = Listejoueurs[0];
        } else {
            JoueurCourant = Listejoueurs[1];
        }

        // Génération des 5 trous noirs et de 2 désintégrateurs sur les trous noirs
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            int ligne_trou_noir = r.nextInt(6);
            int colonne_trou_noir = r.nextInt(7);
            if (compteur < 2) {
                if (!grilleDeJeu.placerDesintegrateur(ligne_trou_noir, colonne_trou_noir)) {
                    compteur--;
                }
                compteur = compteur + 1;
            }
            if (!grilleDeJeu.placerTrouNoir(ligne_trou_noir, colonne_trou_noir)) {
                i--;
            }
        }

        // On place les trois derniers désintégrateurs
        for (int i = 0; i < 3; i++) {
            int ligne_désin = r.nextInt(6);
            int colonne_désin = r.nextInt(7);
            if (!grilleDeJeu.placerDesintegrateur(ligne_désin, colonne_désin) || grilleDeJeu.Cellules[ligne_désin][colonne_désin].presenceTrouNoir()) {
                i--;
            }
        }

        grilleDeJeu.afficherGrilleSurConsole();

    }

    int InfosActionsJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1) Jouer un Jeton");
        System.out.println("2) Récuperer un Jeton");
        System.out.println("3) Désintégrer un Jeton");
        int choix = sc.nextInt();
        while (choix > 3 || choix < 1) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        return choix;
    }

    void jouerJeton() {
        Scanner sc = new Scanner(System.in);
        boolean resultatAction;
        System.out.println("Veuillez saisir une colonne :");
        int colonne = sc.nextInt() - 1;
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne :");
            colonne = sc.nextInt() - 1;
        }

        resultatAction = grilleDeJeu.ajouterJetonDansColonne(JoueurCourant, colonne);
        while (!resultatAction) {
            System.out.println("La collone est pleine veuillez saisir une autre colonne :");
            colonne = sc.nextInt() - 1;
            resultatAction = grilleDeJeu.ajouterJetonDansColonne(JoueurCourant, colonne);
        }

    }

    boolean recupererJeton() {
        int colonne;
        int ligne;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir les coordonnées du jeton a récup :");
        System.out.println("Veuillez saisir la colonne :");
        colonne = sc.nextInt() - 1;
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne valide :");
            colonne = sc.nextInt() - 1;
        }
        System.out.println("Veuillez saisir la ligne :");
        ligne = sc.nextInt() - 1;
        while (ligne > 5 || ligne < 0) {
            System.out.println("Erreur : veuillez saisir une ligne valide :");
            ligne = sc.nextInt() - 1;
        }
        if (grilleDeJeu.Cellules[ligne][colonne].jetonCourant != null && grilleDeJeu.Cellules[ligne][colonne].lireCouleurDuJeton().equals(JoueurCourant.Couleur)) {
            //G.recupererJeton(ligne, colonne);
            JoueurCourant.ajouterJeton(grilleDeJeu.recupererJeton(ligne, colonne));
            grilleDeJeu.tasserGrille();
            //JoueurCourant.ajouterJeton(G.Cellules[ligne][colonne].recupererJeton());

            return true;
        } else {
            return false;
        }
    }

    boolean desintegrerJeton() {
        if (JoueurCourant.nombreDesintegrateurs == 0) {
            return false;
        }
        int colonne;
        int ligne;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir les coordonnées du jeton a désintégrer :");
        System.out.println("Veuillez saisir la colonne :");
        colonne = sc.nextInt() - 1;
        while (colonne > 6 || colonne < 0) {
            System.out.println("Erreur : veuillez saisir une colonne valide :");
            colonne = sc.nextInt() - 1;
        }
        System.out.println("Veuillez saisir la ligne :");
        ligne = sc.nextInt() - 1;
        while (ligne > 5 || ligne < 0) {
            System.out.println("Erreur : veuillez saisir une ligne valide :");
            ligne = sc.nextInt() - 1;
        }

        if (grilleDeJeu.Cellules[ligne][colonne].jetonCourant != null && !grilleDeJeu.Cellules[ligne][colonne].lireCouleurDuJeton().equals(JoueurCourant.Couleur)) {
            grilleDeJeu.supprimerJeton(ligne, colonne);
            grilleDeJeu.tasserGrille();
            JoueurCourant.utiliserDesintegrateur();
            return true;
        } else {
            return false;
        }
    }

    boolean TourJoueurCourant() {
        System.out.println("C'est a " + JoueurCourant.Nom + " de jouer (" + JoueurCourant.Couleur + ")");
        System.out.println("Il vous reste " + JoueurCourant.nombreJetonsRestant + " jetons");
        System.out.println("Il vous reste " + JoueurCourant.nombreDesintegrateurs + " désintégrateurs");
        int choix = InfosActionsJoueur();
        switch (choix) {
            case 1:
                jouerJeton();
                return true;
            //break;
            case 2:
                if (!recupererJeton()) {
                    System.out.println("Vous avez soit saisi un jeton qui n'est pas le vôtre ou un endroit sans jeton");
                    return false;
                }

                break;
            case 3:
                if (!desintegrerJeton()) {
                    System.out.println("Vous avez soit saisi un jeton qui est le vôtre ou vous n'avez pas de désintégrateur");
                    return false;
                }
                break;
        }
        return true;
    }

    void debuterPartie() {
        initialiserPartie();
        Scanner sc = new Scanner(System.in);

        do {
            while (!TourJoueurCourant()) {
                System.out.println("Recommencez votre tour");
            }
            grilleDeJeu.afficherGrilleSurConsole();

            JoueurCourant = ProchainJoueur(JoueurCourant);

        } while (grilleDeJeu.etreGagnantePourJoueur(Listejoueurs[0]) != true && grilleDeJeu.etreGagnantePourJoueur(Listejoueurs[1]) != true && grilleDeJeu.etreRemplie() != true);

        if (grilleDeJeu.etreGagnantePourJoueur(Listejoueurs[0]) == true && grilleDeJeu.etreGagnantePourJoueur(Listejoueurs[1]) == true) {
            System.out.println("C'est " + JoueurCourant.Nom + " qui a gagné !");
        } else {
            System.out.println("C'est " + ProchainJoueur(JoueurCourant).Nom + " qui a gagné !");
        }

    }

}
