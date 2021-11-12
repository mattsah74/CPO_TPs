/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relation_1_sahinidis_marquet;

/**
 *
 * @author matth
 */
public class Voiture {
    String modele;
    String marque;
    int puissanceCV;
    Personne proprietaire;
    
    
    public Voiture(String sonModele, String saMarque, int saPuiss){
        modele = sonModele;
        marque = saMarque;
        puissanceCV = saPuiss;
    }
    // ajustement du toString() pour correspondre aux besoins de la classe
    @Override
    public String toString() {
        String chaine_a_retourner;
        chaine_a_retourner = "une " + marque+ " "+ modele+" avec une puissance de " + puissanceCV + " CV.";
        return chaine_a_retourner;
    }
}

