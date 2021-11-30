/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

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
