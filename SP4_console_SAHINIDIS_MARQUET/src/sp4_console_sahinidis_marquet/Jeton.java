/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

/**
 *
 * @author matth 
 */
public class Jeton {
    String Couleur;
    public Jeton(String CouleurJeton){
        Couleur=CouleurJeton;
    }
    public String lireCouleur(){
        return Couleur;
    }
    public String couleurDuJetonVue(){
        if ("Jaune".equals(Couleur)){
            return"\u001B[33m O";
        }
        return"\u001B[31m O";
    }

}

