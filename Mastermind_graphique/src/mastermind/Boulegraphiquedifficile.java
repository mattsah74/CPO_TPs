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
public class Boulegraphiquedifficile extends JButton {
    Boule bouleassoc;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/car_vide.png"));
    ImageIcon img_bleu = new javax.swing.ImageIcon(getClass().getResource("/images/car_bleu.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/car_rouge.png"));
    ImageIcon img_vert = new javax.swing.ImageIcon(getClass().getResource("/images/car_vert.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/car_jaune.png"));
    ImageIcon img_indrouge = new javax.swing.ImageIcon(getClass().getResource("/images/carind_rouge.png"));
    ImageIcon img_indblanc = new javax.swing.ImageIcon(getClass().getResource("/images/carind_blanc.png"));
    ImageIcon img_indvide = new javax.swing.ImageIcon(getClass().getResource("/images/carind_vide.png"));
    
    public Boulegraphiquedifficile (Boule uneboule){
        bouleassoc = uneboule;
    }
    
    @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        for(int i=14; i>=0; i--){
            for(int j=0; j<5; j++){
                if(bouleassoc.Couleur == "rouge"){
                    setIcon(img_rouge);
                }
                else if(bouleassoc.Couleur == "jaune"){
                    setIcon(img_jaune);
                }        
                else if(bouleassoc.Couleur == "vert"){
                    setIcon(img_vert);
                }
                else if(bouleassoc.Couleur == "bleu"){
                    setIcon(img_bleu);
                }
                else if(bouleassoc.Couleur == "temp"){
                    setIcon(img_vide);
                }
                else if(bouleassoc.Couleur == "indrouge"){
                    setIcon(img_indrouge);
                }
                else if(bouleassoc.Couleur == "indblanc"){
                    setIcon(img_indblanc);
                }
            }
        }
    }
}
