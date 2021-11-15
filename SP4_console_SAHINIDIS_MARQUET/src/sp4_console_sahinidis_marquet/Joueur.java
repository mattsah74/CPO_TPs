/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;
import java.util.Random;

/**
 *
 * @author matth
 */
public class Joueur {
    Jeton [] tab = new Jeton [21];
    String nom;
    String couleur;
    int ListeJetons;
    int nombreJetonsRestants;
    int nombreDesintegrateurs;
   // String [] couleur = {"jaune", "rouge"};
    public Joueur(String lenom, String couleur1, int listejet, int nbjetrest, int nbdesint){
        nom = lenom;
        couleur = couleur1;
        ListeJetons = listejet;
        nombreJetonsRestants = nbjetrest;
        nombreDesintegrateurs = nbdesint;
    }
    public void affecterCouleur(String couleur1){
        couleur = couleur1;
    }
    // public void ajouterJeton(Jeton){
        
    
}
