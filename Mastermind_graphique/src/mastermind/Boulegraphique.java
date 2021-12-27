/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author matth
 */
public class Boulegraphique extends JButton {
    Boule bouleassoc;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/car_blanc.png"));
    
    public Boulegraphique (Boule uneboule){
        bouleassoc = uneboule;
    }
    
    @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        setIcon(img_vide); // On attribue l'image de base de la grille
    }
}
