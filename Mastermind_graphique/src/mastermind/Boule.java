/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

/**
 *
 * @author matth
 */
public class Boule {
    String Couleur;
    Boule grille1 [][] = new Boule[12][4];
    
    
    public Boule(String coul){
        Couleur = coul;
    }
    
    // ajout d'un commentaire
    public String lireCouleurBoule(){
        return Couleur;
    }
}
