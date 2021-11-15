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
        for(int i=0; i<=7; i++ ){
            for (int j=0; j<=6; j++){
                CellulesJeu[j][i] = new Cellule();
            }
        }
    }
    public void ajouterJetonDansColonne(Jeton jet, int c){
        int a =0;
        if(CellulesJeu[0][c]==null){
            for(int i=0; i<=6; i++){
                if(CellulesJeu[i][c]==null){
                    a = i;
                }
            }
            CellulesJeu[a][c].affecterJeton(jet);
        }
        else{
            System.out.println("Cette colonne est pleine");
        }
    }
    public boolean etreRemplie(){
        int a=0;
        for(int i=0; i<=7; i++ ){
            for (int j=0; j<=6; j++){
                if (CellulesJeu[j][i]==null){
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
        for(int i=0; i<=7; i++ ){
            for (int j=0; j<=6; j++){
                CellulesJeu[j][i] = null;
            }
        }  
    }
    public void afficherGrilleSurConsole(){
        for(int i=0; i<=7; i++ ){
            for (int j=0; j<=6; j++){
                System.out.print(CellulesJeu[j][i]);
            }
        }  System.out.print("\n");
    }
}

