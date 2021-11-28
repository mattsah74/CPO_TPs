/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author matth
 */

public class Partie {
    Joueur [] ListeJoueurs = new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleJeu = new Grille();
    String [] ListeCouleurs = {"jaune", "rouge"};
   

    public void attribuerCouleursAuxJoueurs(){
        Joueur Joueur1 = new Joueur("Joueur1", "c", 0, 0);
        Joueur Joueur0 = new Joueur("Joueur0", "c", 0, 0);
        ListeJoueurs[0]= Joueur0;
        ListeJoueurs[1]= Joueur1;
        Random rand = new Random();
        int x = rand.nextInt(2);
        ListeJoueurs[1].affecterCouleur(ListeCouleurs[x]);
        ListeJoueurs[0].affecterCouleur(ListeCouleurs[(-x)+1]);
//        double x = Math.random();
//        ListeJoueurs[1].couleur = ListeCouleurs[(int)x];
//        ListeJoueurs[2].couleur = ListeCouleurs[(-(int)x)+1];
    }
    
    public void debuterPartie(){
        JoueurCourant = ListeJoueurs[0];
        while(grilleJeu.etreRemplie()==false && grilleJeu.etreGagnantePourJoueur(JoueurCourant)==false){
            if (JoueurCourant == ListeJoueurs[0]){
                JoueurCourant = ListeJoueurs[1];
            }
            else {
                JoueurCourant = ListeJoueurs[0];
            }
            System.out.println("C'est au tour de joueur " + JoueurCourant.couleur);
            grilleJeu.afficherGrilleSurConsole();
            Scanner sc;
            sc = new Scanner(System.in);
            System.out.println("Rentrez la valeur de la colonne");
            int coup = sc.nextInt();
            while(coup>6 || coup<0 || grilleJeu.colonneRemplie(coup)==true){
                System.out.println("Rentrez une bonne valeur de colonne non-remplie");
                coup = sc.nextInt();
            }
            
            Jeton jetonCourant = new Jeton(JoueurCourant.couleur);
            JoueurCourant.ajouterJeton(jetonCourant);
            grilleJeu.ajouterJetonDansColonne(jetonCourant, coup);
            String coulres = JoueurCourant.couleur; //garde la valeur du dernier joueur pour l'afficher si besoin
        }
        grilleJeu.afficherGrilleSurConsole();
        System.out.println("Le joueur gagnant est le joueur " + JoueurCourant.couleur);
        
//        fin du jeu
    }
}
