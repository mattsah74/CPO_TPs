/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relation_1_sahinidis_marquet;

/**
 *
 * @author matth
 */
public class Personne {
    String nom;
    String prenom;
    Voiture [] liste_voitures;
    int nbVoitures;
    
    // création du constructeur
    public Personne(String sNom, String sPrenom){
        nom=sNom;
        prenom=sPrenom;
        liste_voitures= new Voiture[3];
        nbVoitures=0;
    }
    
    // ajustement du toString() pour correspondre aux besoins de la classe
    @Override
    public String toString() {
        String chaine_a_retourner;
        chaine_a_retourner = "Prénom : "+prenom+"\nNom : "+nom;
        return chaine_a_retourner;
    }
    public boolean ajouter_voiture( Voiture voiture_a_ajouter){
        if(voiture_a_ajouter.proprietaire!=null){
            return false;
        }
        else if (nbVoitures>=3){
            return false;
        }
        else {
            liste_voitures[nbVoitures]=voiture_a_ajouter;
            nbVoitures=nbVoitures+1;
            voiture_a_ajouter.proprietaire = this;
            return true;
        }         
    }
}

