/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

/**
 *
 * @author matth
 */

public class Partie {
    Joueur [] ListeJoueurs = new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleJeu;
    String [] ListeCouleurs = {"jaune", "rouge"};
    public void attribuerCouleursAuxJoueurs(){
        double x = Math.random();
        ListeJoueurs[1].couleur = ListeCouleurs[(int)x];
        ListeJoueurs[2].couleur = ListeCouleurs[(-(int)x)+1];
    }
    public void debuterPartie(){
        while(grilleJeu.etreRemplie()==false && grilleJeu.etreGagnantePourJoueur(JoueurCourant)){
            grilleJeu.afficherGrilleSurConsole();
            JoueurCourant.ajouterJeton(jetonCourant);
             
        }
//        fin du jeu
    }
}
