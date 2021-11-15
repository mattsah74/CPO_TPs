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
    Cellule [] CellulesJeu = new Cellule [6][7];
    public Grille(){
        for(int i=0; i<=7; i++ ){
            for (int j=0; j<=6; j++){
                CellulesJeu[j][i] = new Cellule;
            }
        }
    }
}

