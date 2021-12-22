/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_puissance_4_sahinidis_marquet_console;

/**
 *
 * @author louis & matthieu
 */
public class Jeton {
    String Couleur;
    
    Jeton(String coul){
        Couleur = coul;
    }
    
    // ajout d'un commentaire
    String lireCouleur(){
        return Couleur;
    }
    
    // notez le vert
    @Override
    public String toString(){
        if("Rouge".equals(Couleur))
            return "\u001B[31m O ";
        return "\u001B[33m O ";
    }
}
