/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author matth
 */
public class Partie {

    Grille grillejeu;
    String nomjoueur;
    int mode = 0;

    void initialiserpartie() {

        Scanner sc = new Scanner(System.in);
        int bon = 0;
        int modetemporaire = 0;
        System.out.println("___________________MASTERMIND by Matthieu and Anthony___________________");
        System.out.println("Bonjour !\nBienvenue sur le Mastermind imaginé par Matthieu et Anthony");
        System.out.println("Entrez votre nom :");
        nomjoueur = sc.next();
        System.out.println(" ");
        System.out.println("A vous de jouer " + nomjoueur + " !");
        System.out.println("Il existe 3 modes de jeu :\n1- Le mode 'Simple' (Aligne les 3 couleurs dans l'ordre imaginé par l'ordinateur en moins de 12 essais, tu as le choix entre 4 couleurs différentes)\n2- Le mode 'Normal' (Aligne 4 couleurs en moins de 12 essais, tu as le choix entre 4 couleurs différentes)\n3- Le mode 'Extrême' (Aligne 5 couleurs en moins de 15 essis,tu as le choix entre 6 couleurs différentes)");
        while (bon != 1) {
            System.out.println("\nVeuillez saisir un mode de jeu (1, 2, ou 3) :");
            modetemporaire = sc.nextInt();
            // System.out.println(modetemporaire);
            if (modetemporaire == 1 || modetemporaire == 2 || modetemporaire == 3) {
                if (modetemporaire == 1) {
                    mode = 1;
                } else if (modetemporaire == 2) {
                    mode = 2;
                } else if (modetemporaire == 3) {
                    mode = 3;
                }
                // System.out.println(mode);
                bon = 1;
            } else {
                System.out.println("Je n'ai pas compris...");
                System.out.println(" ");
                continue;
            }

        }

        grillejeu = new Grille(mode);

    }

    public void debuterpartie() throws FileNotFoundException {
        int finpartie = 1; // Pour arrêter la partie finpartie = 2.
        int valcouleur = 0;
        String couleur;
        int niemecouleur = 1;
        int bon = 0;
        int nbRB[] = new int[2];
        Scanner scan = new Scanner(System.in);
        int nbtour = 0; // comptabilise le nombre de tours avant victoire pour enregistrer le score

        int nbcolonne = 0;// nbcolonne sera le nombre de colonnes associées à la grille de jeu correspondsante au mode choisi par l'utilisateur
        int nbligne = 0; // pareil que nbcolonne mais correspondant au nombre de tours total
        if (mode == 1) {
            nbcolonne = 3;
            nbligne = 12;
        } else if (mode == 2) {
            nbcolonne = 4;
            nbligne = 12;
        } else {
            nbcolonne = 5;
            nbligne = 15;
        }

        System.out.println("Allons ordinateur, initialise une suite de couleurs pour voir de quoi " + nomjoueur + " est capable");
        grillejeu.creercombinaison(mode); // La liste de référence est créée
        grillejeu.affichercombinaison(mode);

        while (finpartie != 2) {

            if (mode == 1) {
                for (int i = 0; i < 12; i++) { // Début des 12 boucles pour trouver la ligne de l'ordinateur.
                    niemecouleur = 1;
                    nbtour += 1;
                    for (int j = 0; j < 3; j++) {
                        bon = 0;
                        while (bon != 2) { // l'utilisateur doit donner une valeur correcte
                            if (mode == 1 || mode == 2) {
                                System.out.println("Pour rappel, voici le code couleur :\n  -1 = Rouge\n  -2 = Jaune\n  -3 = Bleu\n  -4 = Vert");
                            } else {
                                System.out.println("Pour rappel, voici le code couleur :\n  -1 = Rouge\n  -2 = Jaune\n  -3 = Bleu\n  -4 = Vert\n  -5 = Orange\n  -6 = Marron");
                            }

                            System.out.println("Rentrez une valeur pour placer la " + niemecouleur + " ère/ème couleur");

                            valcouleur = scan.nextInt();
                            System.out.println(" ");

                            if (valcouleur == 1 || valcouleur == 2 || valcouleur == 3 || valcouleur == 4) {
                                bon = 2;
                            } else {
                                System.out.println("Je n'ai pas compris, réessayez.");
                                continue;
                            }
                        }

                        if (valcouleur == 1) {
                            Boule b = new Boule("rouge");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 2) {
                            Boule b = new Boule("jaune");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 3) {
                            Boule b = new Boule("bleu");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 4) {
                            Boule b = new Boule("vert");
                            grillejeu.ajouterboule(b, i, j, mode);
                        }

                        niemecouleur += 1;

                    }

                    System.out.println("Voyons ce qu'il en est :");

                    nbRB = grillejeu.verifiercombi(i, mode);
                    grillejeu.affichergrilleetindic(mode);

                    if (nbRB[0] == 3) {
                        System.out.println("Vous avez gagné");
                        PrintWriter writer = new PrintWriter(nomjoueur + ".txt");
                        writer.println(nomjoueur);
                        writer.println("Ce joueur a gagné en " + nbtour + " tours.");
                        writer.close();
                        finpartie = 2;
                        break;
                    } else if (i == 11 && nbRB[0] != 3) {
                        System.out.println("Vous avez perdu.");
                        finpartie = 2;
                        break;
                    } else {
                        System.out.println("Vous y êtes presque, continuez !");
                    }

                }
            } else if (mode == 2) {
                for (int i = 0; i < 12; i++) { // Début des 12 boucles pour trouver la ligne de l'ordinateur.
                    niemecouleur = 1;
                    nbtour += 1;
                    for (int j = 0; j < 4; j++) {
                        bon = 0;
                        while (bon != 2) { // l'utilisateur doit donner une valeur correcte
                            if (mode == 1 || mode == 2) {
                                System.out.println("Pour rappel, voici le code couleur :\n  -1 = Rouge\n  -2 = Jaune\n  -3 = Bleu\n  -4 = Vert");
                            } else {
                                System.out.println("Pour rappel, voici le code couleur :\n  -1 = Rouge\n  -2 = Jaune\n  -3 = Bleu\n  -4 = Vert\n  -5 = Orange\n  -6 = Marron");
                            }

                            System.out.println("Rentrez une valeur pour placer la " + niemecouleur + " ère/ème couleur");

                            valcouleur = scan.nextInt();
                            System.out.println(" ");

                            if (valcouleur == 1 || valcouleur == 2 || valcouleur == 3 || valcouleur == 4) {
                                bon = 2;
                            } else {
                                System.out.println("Je n'ai pas compris, réessayez.");
                                continue;
                            }
                        }

                        if (valcouleur == 1) {
                            Boule b = new Boule("rouge");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 2) {
                            Boule b = new Boule("jaune");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 3) {
                            Boule b = new Boule("bleu");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 4) {
                            Boule b = new Boule("vert");
                            grillejeu.ajouterboule(b, i, j, mode);
                        }

                        niemecouleur += 1;

                    }

                    System.out.println("Voyons ce qu'il en est :");

                    nbRB = grillejeu.verifiercombi(i, mode);
                    grillejeu.affichergrilleetindic(mode);

                    if (nbRB[0] == 4) {
                        System.out.println("Vous avez gagné");
                        PrintWriter writer = new PrintWriter(nomjoueur + ".txt");
                        writer.println(nomjoueur);
                        writer.println("Ce joueur a gagné en " + nbtour + " tours.");
                        writer.close();
                        finpartie = 2;
                        break;
                    } else if (i == 11 && nbRB[0] != 4) {
                        System.out.println("Vous avez perdu.");
                        finpartie = 2;
                        break;
                    } else {
                        System.out.println("Vous y êtes presque, continuez !");
                    }

                }
            } else if (mode == 3) {
                for (int i = 0; i < 15; i++) { // Début des 12 boucles pour trouver la ligne de l'ordinateur.
                    niemecouleur = 1;
                    nbtour += 1;
                    for (int j = 0; j < 5; j++) {
                        bon = 0;
                        while (bon != 2) { // l'utilisateur doit donner une valeur correcte
                            if (mode == 1 || mode == 2) {
                                System.out.println("Pour rappel, voici le code couleur :\n  -1 = Rouge\n  -2 = Jaune\n  -3 = Bleu\n  -4 = Vert");
                            } else {
                                System.out.println("Pour rappel, voici le code couleur :\n  -1 = Rouge\n  -2 = Jaune\n  -3 = Bleu\n  -4 = Vert\n  -5 = Orange\n  -6 = Marron");
                            }

                            System.out.println("Rentrez une valeur pour placer la " + niemecouleur + " ère/ème couleur");

                            valcouleur = scan.nextInt();
                            System.out.println(" ");

                            if (valcouleur == 1 || valcouleur == 2 || valcouleur == 3 || valcouleur == 4 || valcouleur == 5 || valcouleur == 6) {
                                bon = 2;
                            } else {
                                System.out.println("Je n'ai pas compris, réessayez.");
                                continue;
                            }
                        }

                        if (valcouleur == 1) {
                            Boule b = new Boule("rouge");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 2) {
                            Boule b = new Boule("jaune");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 3) {
                            Boule b = new Boule("bleu");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 4) {
                            Boule b = new Boule("vert");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 5) {
                            Boule b = new Boule("orange");
                            grillejeu.ajouterboule(b, i, j, mode);
                        } else if (valcouleur == 6) {
                            Boule b = new Boule("marron");
                            grillejeu.ajouterboule(b, i, j, mode);
                        }

                        niemecouleur += 1;

                    }

                    System.out.println("Voyons ce qu'il en est :");

                    nbRB = grillejeu.verifiercombi(i, mode);
                    grillejeu.affichergrilleetindic(mode);

                    if (nbRB[0] == 5) {
                        System.out.println("Vous avez gagné");
                        PrintWriter writer = new PrintWriter(nomjoueur + ".txt");
                        writer.println(nomjoueur);
                        writer.println("Ce joueur a gagné en " + nbtour + " tours.");
                        writer.close();
                        finpartie = 2;
                        break;
                    } else if (i == 14 && nbRB[0] != 5) {
                        System.out.println("Vous avez perdu.");
                        finpartie = 2;
                        break;
                    } else {
                        System.out.println("Vous y êtes presque, continuez !");
                    }

                }
            }

        }

    }

}
