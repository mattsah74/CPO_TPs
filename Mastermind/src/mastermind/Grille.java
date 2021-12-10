/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;
import java.util.Random;

/**
 *
 * @author matth
 */
public class Grille {
    Boule grille [][] = new Boule[12][4]; // initialise notre grille
    String combi [] = new String[4]; // initialise une ligne pour la combinaison
    String listecoul[]={"jaune","rouge","bleu","vert"};
    
    
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
            System.out.print(combi[i]+ " ");
        }
    }
    
    public int verifiercombi(int l){
        int nbrouge =0; //nombre de rouge total
        int nbblanc=0;  // nombre de blanc final
        int nbblanctot = 0; //nombre de blanc total (en comptant les rouges)
        for(int i=0; i<4; i++){
            if(grille[l][i].Couleur == combi[i]){
                nbrouge +=1;
            }
        }
        
    }
    
    
    
    
    public void affichergrille(){
        
    }
    
}
