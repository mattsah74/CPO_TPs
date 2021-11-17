/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_sahinidis_marquet;

/**
 *
 * @author matth
 */
public class Grille {
    Cellule[][] CellulesJeu = new Cellule [6][7];
    public Grille(){
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                CellulesJeu[j][i] = new Cellule();
            }
        }
    }
    public boolean ajouterJetonDansColonne(Jeton jet, int c){
        int a =0;
        
        if(CellulesJeu[0][c].jetonCourant==null){
            for(int i=0; i<=5; i++){
                if(CellulesJeu[i][c].jetonCourant==null){
                    a = i; 
                }
            }
            CellulesJeu[a][c].affecterJeton(jet);
            return true;
        }
        else{
            System.out.println("Cette colonne est pleine");
            return false;
        }
    }
    public boolean etreRemplie(){
        int a=0;
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                if (CellulesJeu[j][i].jetonCourant==null){
                    a+=1;
                }
            }
        } 
        if (a==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void viderGrille(){
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                CellulesJeu[j][i].jetonCourant = null;
            }
        }  
    }
    public void afficherGrilleSurConsole(){
        for(int i=0; i<=6; i++ ){
            for (int j=0; j<=5; j++){
                System.out.print(CellulesJeu[j][i].jetonCourant);
            }
        }  System.out.print("\n");
    }
    public boolean celluleOccupee(int l, int c){
        if(CellulesJeu[l][c].jetonCourant== null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String lireCouleurDuJeton(int l, int c){
        if (CellulesJeu[l][c].jetonCourant== null){
            String couleur = "";
            Jeton jet;     
            jet = CellulesJeu[l][c].jetonCourant;
            couleur = jet.lireCouleur();
            return couleur;
        }
        else{
            return ("Il n'y a pas de jeton ici") ;
        }
    }
    public boolean colonneRemplie(int c){
        int a =0;
        for(int i=0; i<=5; i++){
                if(CellulesJeu[i][c].jetonCourant!=null){
                    a += 1; 
                }
        }
        if(a==0){
            return false;
        }
        else{
            return true;
        }
        
    }
    public boolean etreGagnantePourJoueur(Joueur j1){
        String coul;
        coul = j1.couleur; 
        int verif = 0; /*variable intermediaire */
        /*verification de gauche à droite*/
        for(int c=0; c<=3; c++ ){  
            for (int l=0; l<=5; l++){
                Jeton jet = new Jeton(coul);
                if (CellulesJeu[l][c].jetonCourant==null && CellulesJeu[l][c].jetonCourant!=jet){
                    return false;
                }
                else{
                    for(int k=0; k<4; k++){
                        if (CellulesJeu[l][c+k].jetonCourant!=null && CellulesJeu[l][c].jetonCourant==jet){
                            k
                        }
                    }
                }
            }
        } 
    }
}

