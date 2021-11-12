/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_relation_1_sahinidis_marquet;

/**
 *
 * @author matth
 */
public class TP2_relation_1_Sahinidis_Marquet {
    public static void main(String[] args) {
        
        Voiture uneClio= new Voiture ("Clio", "Renault", 5 );
        Voiture uneAutreClio= new Voiture ("Clio", "Renault", 5 );
        Voiture une2008= new Voiture ("2008", "Peugeot", 6 );
        Voiture uneMicra= new Voiture ("Micra", "Nissan", 4 );

        Personne bob = new Personne("Bobby", "Sixkiller");
        Personne reno= new Personne("Reno", "Raines");

        System.out.println("liste des voitures disponibles :\n"+ uneClio+ "\n"+ uneAutreClio+ "\n"+ une2008+ "\n"+ uneMicra + "\n");

        bob.liste_voitures[0] = uneClio;
        bob.nbVoitures = 1;
        uneClio.proprietaire = bob;

        bob.liste_voitures[1] = uneMicra;
        bob.nbVoitures = 2;
        uneMicra.proprietaire = bob;

        System.out.println("la premiere voiture de Bob est " + bob.liste_voitures[0] );
        System.out.println("la seconde voiture de Bob est " + bob.liste_voitures[1] +"\n");

        reno.liste_voitures[0] = uneAutreClio;
        reno.nbVoitures = 1;
        uneAutreClio.proprietaire = reno;

        /*.liste_voitures[1] = une2008;
        reno.nbVoitures = 2;
        une2008.proprietaire = reno;
        */

        reno.ajouter_voiture(une2008);

        System.out.println("la premiere voiture de Reno est " + reno.liste_voitures[0] );
        System.out.println("la seconde voiture de Reno est " + reno.liste_voitures[1] + "\n");
    }

    }

