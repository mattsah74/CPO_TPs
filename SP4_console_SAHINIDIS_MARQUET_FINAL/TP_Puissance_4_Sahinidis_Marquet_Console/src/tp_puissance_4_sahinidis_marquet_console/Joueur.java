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
