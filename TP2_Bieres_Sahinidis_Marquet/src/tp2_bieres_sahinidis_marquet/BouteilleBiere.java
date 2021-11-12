/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package tp2_bieres_sahinidis_marquet;;

/**
*
* @author louis
*/

public class BouteilleBiere {
    String nom;
    float degreAlcool;
    String brasserie;
    Boolean ouverte;
    
    public void lireEtiquette(){
        System.out.println("Bouteille de " + nom +" (" + degreAlcool +" degres) \nBrasserie: " + brasserie );
    }
    
    public boolean Decapsuler(){
        if (ouverte == true){
          System.out.println("La bouteille est déja ouverte");
          return false;
        }
        else {
            ouverte = true;
            return true;
        }
    }
    
    public BouteilleBiere(String unNom, float unDegre, String uneBrasserie) {
        nom = unNom;
        degreAlcool = unDegre;
        brasserie = uneBrasserie;
        ouverte = false;
    }
    
    @Override
    public String toString() {
        String chaine_a_retourner;
        chaine_a_retourner = nom+ " (" + degreAlcool +" degrés) Ouverte ? ";
        if (ouverte == true ) {
            chaine_a_retourner +="oui";
        }
        else {
            chaine_a_retourner +="non";
        }
        return chaine_a_retourner;
    }

}
