/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

/**
 *
 * @author matth
 */
import java.util.Scanner;

public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public Cellule(){ //*initialise les attributs avec des valeurs par défauts*/
        jetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    }
    
    public boolean affecterJeton(Jeton id){
        if (jetonCourant==null){
            jetonCourant=id;
            return true;
        }
        else{
            return false;
        }
    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant!=null){
            return jetonCourant.Couleur;
        }
        else{
            return "vide";
        }
    }
//    public Jeton recupereJeton(){
//        return jetonCourant;
//    }
                
//    public boolean supprimerJeton (Jeton id){
//        if (jetonCourant==id){
//            jetonCourant=null;
//            return true;
//        }
//        else{
//            return false;
//        }
//    } 
    
}   

