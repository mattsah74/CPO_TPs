/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastermind;

/**
 *
 * @author matth
 */


public class Mastermind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grille gri = new Grille();
        gri.creercombinaison();
        gri.affichercombinaison();
    }
    
}
