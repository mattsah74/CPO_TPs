/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author matth
 */
public class Grille {

    Boule grillemode1[][] = new Boule[12][3]; // initialise notre grille du mode 1
    Boule grillemode2[][] = new Boule[12][4]; // initialise notre grille du mode 2
    Boule grillemode3[][] = new Boule[15][5]; // initialise notre grille du mode 3
    String combi1[] = new String[3]; // initialise une ligne pour la combinaison mode 1
    String combi2[] = new String[4]; // initialise une ligne pour la combinaison mode 2
    String combi3[] = new String[5]; // initialise une ligne pour la combinaison mode 3
    String listecoul12[] = {"jaune", "rouge", "bleu", "vert"}; // couleurs mode 1 et 2
    String listecoul3[] = {"jaune", "rouge", "bleu", "vert", "orange", "marron"}; //couleurs mode 3
    int aide12[][] = new int[12][2]; // grille qui nous donnera le nombre de jetons correctement^placée et le nombre de jetons de la bonne couleur présents
    int aide3[][] = new int[15][2];

    public Grille(int mode) { // constructeur qui remplit la grille avec des boules null = cases vides
        if (mode == 1) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 3; j++) {
                    grillemode1[i][j] = null;
                }
            }
        } else if (mode == 2) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 4; j++) {
                    grillemode2[i][j] = null;
                }
            }
        } else if (mode == 3) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    grillemode3[i][j] = null;
                }
            }
        }

    }

    public void creercombinaison(int mode) { // permet de creer la combinaison aléatoire a trouver 
        Random nb = new Random();
        if (mode == 1) {
            for (int i = 0; i < 3; i++) {
                int alea = nb.nextInt(3);
                combi1[i] = listecoul12[alea];
            }
        } else if (mode == 2) {
            for (int i = 0; i < 4; i++) {
                int alea = nb.nextInt(4);
                combi2[i] = listecoul12[alea];
            }
        } else if (mode == 3) {
            for (int i = 0; i < 5; i++) {
                int alea = nb.nextInt(5);
                combi3[i] = listecoul3[alea];
            }
        }

    }

    public void ajouterboule(Boule b1, int l, int c, int mode) {
        if (mode == 1) {
            grillemode1[l][c] = b1;
        } else if (mode == 2) {
            grillemode2[l][c] = b1;
        } else if (mode == 3) {
            grillemode3[l][c] = b1;
        }
    }

    public void retirerboule(int l, int c, int mode) {
        if (mode == 1) {
            grillemode1[l][c] = null;
        } else if (mode == 2) {
            grillemode2[l][c] = null;
        } else if (mode == 3) {
            grillemode3[l][c] = null;
        }
    }

    public void affichercombinaison(int mode) {
        if (mode == 1) {
            for (int i = 0; i < 3; i++) {
                if (combi1[i] == "jaune") {
                    System.out.print("J ");
                } else if (combi1[i] == "rouge") {
                    System.out.print("R ");
                } else if (combi1[i] == "bleu") {
                    System.out.print("B ");
                } else if (combi1[i] == "vert") {
                    System.out.print("V ");
                }
            }
        } else if (mode == 2) {
            for (int i = 0; i < 4; i++) {
                if (combi2[i] == "jaune") {
                    System.out.print("J ");
                } else if (combi2[i] == "rouge") {
                    System.out.print("R ");
                } else if (combi2[i] == "bleu") {
                    System.out.print("B ");
                } else if (combi2[i] == "vert") {
                    System.out.print("V ");
                }
            }
        } else if (mode == 3) {
            for (int i = 0; i < 5; i++) {
                if (combi3[i] == "jaune") {
                    System.out.print("J ");
                } else if (combi3[i] == "rouge") {
                    System.out.print("R ");
                } else if (combi3[i] == "bleu") {
                    System.out.print("B ");
                } else if (combi3[i] == "vert") {
                    System.out.print("V ");
                } else if (combi3[i] == "orange") {
                    System.out.print("O ");
                } else if (combi3[i] == "marron") {
                    System.out.print("M ");
                }
            }
        }

    }

    public int[] verifiercombi(int l, int mode) {
        int nbR = 0; // nombre rouge final
        int nbB = 0;  // nombre blanc final

        // On crée un tableau qui va nous permettre de vérifier les pions bien placés puis ceux mal placés mais bien présents
        boolean Check[] = new boolean[mode + 2];

        if (mode == 1) {
            for (int i = 0; i < 3; i++) {
                if (grillemode1[l][i].Couleur == combi1[i]) {
                    nbR += 1;
                    Check[i] = true;
                }
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (grillemode1[l][j].Couleur != combi1[j] && Check[k] == false && grillemode1[l][k].Couleur == combi1[j]) {
                        nbB += 1;
                        Check[k] = true;
                        break;
                    }

                }

            }

            for (int n = 0; n < 2; n++) {
                if (n == 0) {
                    aide12[l][n] = nbR;
                } else {
                    aide12[l][n] = nbB;
                }
            }

        } else if (mode == 2) {
            for (int i = 0; i < 4; i++) {
                if (grillemode2[l][i].Couleur == combi2[i]) {
                    nbR += 1;
                    Check[i] = true;
                }
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (grillemode2[l][j].Couleur != combi2[j] && Check[k] == false && grillemode2[l][k].Couleur == combi2[j]) {
                        nbB += 1;
                        Check[k] = true;
                        break;
                    }

                }

            }

            for (int n = 0; n < 2; n++) {
                if (n == 0) {
                    aide12[l][n] = nbR;
                } else {
                    aide12[l][n] = nbB;
                }
            }

        } else if (mode == 3) {
            for (int i = 0; i < 5; i++) {
                if (grillemode3[l][i].Couleur == combi3[i]) {
                    nbR += 1;
                    Check[i] = true;
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (grillemode3[l][j].Couleur != combi3[j] && Check[k] == false && grillemode3[l][k].Couleur == combi3[j]) {
                        nbB += 1;
                        Check[k] = true;
                        break;
                    }

                }

            }

            for (int n = 0; n < 2; n++) {
                if (n == 0) {
                    aide3[l][n] = nbR;
                } else {
                    aide3[l][n] = nbB;
                }
            }

        }

        int[] valeursRB = {nbR, nbB}; // Comme je ne peux pas retourner deux int, je retourne un tableau contenant mes deux valeurs avec le nombre de rouge en premier.

        return valeursRB;
    }

    public void affichergrilleetindic(int mode) {

        int val = 0;

        System.out.print("Voici la grille de jeu :                       ");
        System.out.print("Voici les indications de l'ordinateur :");
        System.out.println(" ");
        System.out.println("________________________                       _______________________________________");

        if (mode == 1) {
            for (int i = 0; i < 12; i++) {
                val = 0;
                for (int j = 0; j < 5; j++) {
                    if (j < 3) {
                        if (grillemode1[i][j] != null) {
                            if (j == 0) {
                                if (grillemode1[i][j].Couleur == "rouge") {
                                    System.out.print("      |\033[31mR\033[0m|");
                                } else if (grillemode1[i][j].Couleur == "vert") {
                                    System.out.print("      |V|");
                                } else if (grillemode1[i][j].Couleur == "bleu") {
                                    System.out.print("      |B|");
                                } else if (grillemode1[i][j].Couleur == "jaune") {
                                    System.out.print("      |J|");
                                }
                                val = 1;
                            } else {
                                if (grillemode1[i][j].Couleur == "rouge") {
                                    System.out.print("\033[31mR\033[0m|");
                                } else if (grillemode1[i][j].Couleur == "vert") {
                                    System.out.print("V|");
                                } else if (grillemode1[i][j].Couleur == "bleu") {
                                    System.out.print("B|");
                                } else if (grillemode1[i][j].Couleur == "jaune") {
                                    System.out.print("J|");
                                }
                            }
                        } else {
                            if (j == 0) {
                                System.out.print("      |");
                            } else {
                                System.out.print(" |");
                            }
                        }
                    } else {
                        if (j == 3) {
                            if (val == 1) {
                                System.out.print("                                              |" + aide12[i][0] + "|");
                            } else {
                                System.out.print(" |                                              |" + aide12[i][0] + "|");
                            }
                        } else {
                            System.out.print(aide12[i][1] + "|");
                        }

                    }
                }
                System.out.println(" ");
            }

        } else if (mode == 2) {
            for (int i = 0; i < 12; i++) {
                val = 0;
                for (int j = 0; j < 6; j++) {
                    if (j < 4) {
                        if (grillemode2[i][j] != null) {
                            if (j == 0) {
                                if (grillemode2[i][j].Couleur == "rouge") {
                                    System.out.print("      |\033[31mR\033[0m|");
                                } else if (grillemode2[i][j].Couleur == "vert") {
                                    System.out.print("      |V|");
                                } else if (grillemode2[i][j].Couleur == "bleu") {
                                    System.out.print("      |B|");
                                } else if (grillemode2[i][j].Couleur == "jaune") {
                                    System.out.print("      |J|");
                                }
                                val = 1;
                            } else {
                                if (grillemode2[i][j].Couleur == "rouge") {
                                    System.out.print("\033[31mR\033[0m|");
                                } else if (grillemode2[i][j].Couleur == "vert") {
                                    System.out.print("V|");
                                } else if (grillemode2[i][j].Couleur == "bleu") {
                                    System.out.print("B|");
                                } else if (grillemode2[i][j].Couleur == "jaune") {
                                    System.out.print("J|");
                                }
                            }
                        } else {
                            if (j == 0) {
                                System.out.print("      |");
                            } else {
                                System.out.print(" |");
                            }
                        }
                    } else {
                        if (j == 4) {
                            if (val == 1) {
                                System.out.print("                                              |" + aide12[i][0] + "|");
                            } else {
                                System.out.print(" |                                              |" + aide12[i][0] + "|");
                            }
                        } else {
                            System.out.print(aide12[i][1] + "|");
                        }

                    }
                }
                System.out.println(" ");
            }

        } else if (mode == 3) {
            for (int i = 0; i < 15; i++) {
                val = 0;
                for (int j = 0; j < 7; j++) {
                    if (j < 5) {
                        if (grillemode3[i][j] != null) {
                            if (j == 0) {
                                if (grillemode3[i][j].Couleur == "rouge") {
                                    System.out.print("      |\033[31mR\033[0m|");
                                } else if (grillemode3[i][j].Couleur == "vert") {
                                    System.out.print("      |V|");
                                } else if (grillemode3[i][j].Couleur == "bleu") {
                                    System.out.print("      |B|");
                                } else if (grillemode3[i][j].Couleur == "jaune") {
                                    System.out.print("      |J|");
                                } else if (grillemode3[i][j].Couleur == "orange") {
                                    System.out.print("      |O|");
                                } else if (grillemode3[i][j].Couleur == "marron") {
                                    System.out.print("      |M|");
                                }
                                val = 1;
                            } else {
                                if (grillemode3[i][j].Couleur == "rouge") {
                                    System.out.print("\033[31mR\033[0m|");
                                } else if (grillemode3[i][j].Couleur == "vert") {
                                    System.out.print("V|");
                                } else if (grillemode3[i][j].Couleur == "bleu") {
                                    System.out.print("B|");
                                } else if (grillemode3[i][j].Couleur == "jaune") {
                                    System.out.print("J|");
                                } else if (grillemode3[i][j].Couleur == "orange") {
                                    System.out.print("O|");
                                } else if (grillemode3[i][j].Couleur == "marron") {
                                    System.out.print("M|");
                                }
                            }

                        } else {
                            if (j == 0) {
                                System.out.print("      |");
                            } else {
                                System.out.print(" |");
                            }
                        }
                    } else {
                        if (j == 5) {
                            if (val == 1) {
                                System.out.print("                                              |" + aide3[i][0] + "|");
                            } else {
                                System.out.print(" |                                              |" + aide3[i][0] + "|");
                            }
                        } else {
                            System.out.print(aide3[i][1] + "|");
                        }

                    }
                }
                System.out.println(" ");
            }
        }

    }
}
