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
//public class Grille {
//    Boule grille [][] = new Boule[12][4]; // initialise notre grille
//    String combi [] = new String[4]; // initialise une ligne pour la combinaison
//    String listecoul[]={"jaune","rouge","bleu","vert"};
//    
//    
//    public Grille() { // constructeur qui remplit la grille avec des boules null = cases vides
//        for (int i=0; i<12; i++) {
//            for (int j=0; j<4; j++) {
//                grille[i][j] = null;
//            }
//        }
//    }
//    
//    public void creercombinaison(){ // permet de creer la combinaison aléatoire a trouver 
//        Random nb = new Random();
//        for(int i= 0 ; i<4; i++){
//            int alea = nb.nextInt(4);
//            combi[i] = listecoul[alea];
//        }
//    }
//    
//    public void ajouterboule(Boule b1, int l, int c){
//        grille[l][c] = b1;
//    }
//    
//    public void retirerboule(int l, int c){
//        grille[l][c] = null;
//    }
//    
//    public void affichercombinaison(){
//        for(int i= 0 ; i<4; i++){
//            System.out.print(combi[i]+ " ");
//        }
//    }
//    
//    public int verifiercombi(int l){
//        int nbrouge =0; //nombre de rouge total
//        int nbblanc=0;  // nombre de blanc final
//        int nbblanctot = 0; //nombre de blanc total (en comptant les rouges)
//        
//        
//        return nbrouge;
//    }
//        
//     
//    
//    
//    
//    
//    public void affichergrille(){
//        
//    }
//    
//}
public class Grille {
    Boule grille [][] = new Boule[12][4]; // initialise notre grille
    String combi [] = new String[4]; // initialise une ligne pour la combinaison
    String listecoul[]={"jaune","rouge","bleu","vert"};
    int aide[][] = new int [12][2];
    
    
    public Grille() { // constructeur qui remplit la grille avec des boules null = cases vides
        for (int i=0; i<12; i++) {
            for (int j=0; j<4; j++) {
                grille[i][j] = null;
            }
        }
    }
    
    public void creercombinaison(){ // permet de creer la combinaison aléatoire a trouver 
        Random nb = new Random();
        for(int i= 0 ; i<4; i++){
            int alea = nb.nextInt(4);
            combi[i] = listecoul[alea];
        }
    }
    
    public void ajouterboule(Boule b1, int l, int c){
        grille[l][c] = b1;
    }
    
    public void retirerboule(int l, int c){
        grille[l][c] = null;
    }
    
    public void affichercombinaison(){
        for(int i= 0 ; i<4; i++){
            if(combi[i] == "jaune"){
                System.out.print("J ");
            }else if(combi[i] == "rouge"){
                System.out.print("R ");
            }else if(combi[i] == "bleu"){
                System.out.print("B ");
            }else if(combi[i] == "vert"){
                System.out.print("Ve ");
            }
        }
    }
    
    public int[] verifiercombi(int l) {
        int nbR = 0; // nombre rouge final
        int nbB = 0;  // nombre blanc final
        boolean Check[] = new boolean[4];

        for (int i = 0; i < 4; i++) {
            if (grille[l][i].Couleur == combi[i]) {
                nbR += 1;
                Check[i] = true;
            }
        }

        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (grille[l][j].Couleur != combi[j] && Check[k] == false && grille[l][k].Couleur == combi[j]) {
                    nbB += 1;
                    Check[k] = true;
                    break;
                }

            }

        }
        
        for (int n = 0; n < 2; n++){
            if (n == 0){
                aide[l][n] = nbR;
            }else{
                aide[l][n] = nbB;
            }
        }
        
        int [] valeursRB = {nbR, nbB}; // Comme je ne peux pas retourner deux int, je retourne un tableau contenant mes deux valeurs avec le nombre de rouge en premier.
        
        return valeursRB;
    } 
        
     
    
    
    
    
    public void affichergrilleetindic() {
        /*int valeursRB1 [] = new int[2];
        for (int l = 0 ; l < 2; l++){
            valeursRB1 [l] = val[l];
        }
         */

        System.out.print("Voici la grille de jeu :                       ");
        System.out.print("Voici les indications de l'ordinateur :");
        System.out.println(" ");
        System.out.println("________________________                       ______");

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                if (grille[i][j] != null) {
                    if (j == 0) {
                        System.out.print("|" + grille[i][j].Couleur + "|");
                    } else {
                        System.out.print(grille[i][j].Couleur + "|");
                    }
                } else {
                    if (j == 0) {
                        System.out.print("|");
                    } else {
                        System.out.print(" |");
                    }
                }
                
                if (j < 2) {
                    if (j == 0) {
                        System.out.print("           |" + aide[i][j] + "|");
                    } else {
                        System.out.print(aide[i][j] + "|");
                    }
                }
            }
        System.out.println(" ");
        }
        
    }
        
        
        
    public void verifcombi(){
        
    }
    
    public void ajoutercouleur(){
        
    }
    
}

