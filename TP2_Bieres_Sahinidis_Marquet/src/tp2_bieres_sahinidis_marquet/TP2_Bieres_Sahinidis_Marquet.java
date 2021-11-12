/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package tp2_bieres_sahinidis_marquet;;

import tp2_bieres_sahinidis_marquet.BouteilleBiere;

/**
*
* @author louis
*/
public class TP2_Bieres_Sahinidis_Marquet  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // création d'une variable de type bouteilleBiere nommée uneBiere
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls ", (float)7.0 ,"Dubuisson");        
        
        /* //attribution des données aux différents aux attributs de la classe
        uneBiere.nom = "Cuvée des trolls";
        uneBiere.degreAlcool = (float) 7.0;
        uneBiere.brasserie = "Dubuisson";
        uneBiere.ouverte = false;
        */
        
        // on applique la fonction lireEtiquette à l'objet uneBiere
        uneBiere.lireEtiquette();
        
        /*// meme processus que pour uneBiere
        BouteilleBiere uneBiere2 = new BouteilleBiere();
        uneBiere2.nom = "Leffe";
        uneBiere2.degreAlcool = (float) 6.6;
        uneBiere2.brasserie = "Abbaye de Leffe";
        
        */
        BouteilleBiere autreBiere = new BouteilleBiere("Leffe", (float)6.6 ,"Abbaye de Leffe");
        autreBiere.lireEtiquette();
        
        BouteilleBiere autreBiere2 = new BouteilleBiere("Rince Cochon", (float) 8.5, "Haacht");
        BouteilleBiere autreBiere3 = new BouteilleBiere("Chouffe", (float) 8.0, "Brasserie D'Achouffe");
        autreBiere2.lireEtiquette();
        autreBiere3.lireEtiquette();
        
        //Application de la nouvelle fonction décapsuler à la variable uneBiere
        uneBiere.Decapsuler();
        // Affichage de l'attribut ouvert de la variable
        System.out.println(uneBiere.ouverte);
        
        System.out.println(uneBiere);
         
        autreBiere2.Decapsuler();
        System.out.println(autreBiere2);
        System.out.println(autreBiere3);      
    }    
}
