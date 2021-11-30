/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;
import java.util.Random;

/**
 *
 * @author louis & matthieu
 */
public class Joueur {
    
    String Nom;
    String Couleur;
    Jeton ListeJetons[] = new Jeton [21];
    int nombreDesintegrateurs;
    int nombreJetonsRestant;
    
    Joueur(String nom_joueur){
        Nom = nom_joueur;
        nombreDesintegrateurs = 0;
        nombreJetonsRestant = 0;
    } 
    
    void affecterCouleur(String coul){
        Couleur = coul;
    }
    
    void ajouterJeton(Jeton un_jeton){
        ListeJetons[nombreJetonsRestant++] = un_jeton;
    }
    
    Jeton retirerJeton(){
        nombreJetonsRestant = nombreJetonsRestant-1;
        return ListeJetons[nombreJetonsRestant];
    }
    
    void obtenirDesintegrateur(){
        nombreDesintegrateurs += 1;
    }
    
    boolean utiliserDesintegrateur(){
        if(nombreDesintegrateurs==0){
            return false;
        }
        nombreDesintegrateurs--;
        return true;
    }
}
