/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mastermind;

import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author matth
 */
public class fenetreDeJeu_facile extends javax.swing.JFrame {

    Grille grillejeu = new Grille(1);
    String nomjoueur;
    int mode;
    Boule grillemode1[][] = new Boule[12][3]; // initialise notre grille du mode 1
    Boule grilleindice1[][] = new Boule[12][3]; //initialise grille indice du mode 2
    String combi1[] = new String[3]; // initialise une ligne pour la combinaison mode 1
    String listecoul12[] = {"jaune", "rouge", "bleu", "vert"}; // couleurs mode 1 et 2
    int aide12[][] = new int[12][2]; // grille qui nous donnera le nombre de jetons correctement^placée et le nombre de jetons de la bonne couleur présents
    Boule[][] grille;
    Boule bouleselec;
    int numcolonne = 0;
    boolean validation = false;
    int numligne = 0;
    

    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu_facile() {
        initComponents();
        for (int i = 0; i < 12; i++) { // cree le tableau de jeu 
            for (int j = 0; j < 4; j++) {
                Boule b2 = new Boule("temp"); //initialise avec des boules de base 
                grillemode1[i][j] = b2;
                Boulegraphiquefacile boulegraph = new Boulegraphiquefacile(grillemode1[i][j]); 
                pan_grillejeu.add(boulegraph);

            }
        }
        for (int i = 0; i < 12; i++) { // cree le tableau indice
            for (int j = 0; j < 4; j++) {
                Boule b2 = new Boule("temp"); //initialise avec des boules de base 
                grilleindice1[i][j] = b2;
                Boulegraphique boulegraph = new Boulegraphique(grilleindice1[i][j]);
                pan_indice.add(boulegraph);
            }
        }
        grillejeu = new Grille(mode);
        creercombinaison(mode);
        String a = String.valueOf(combi1[0]);
        String b = String.valueOf(combi1[1]);
        String c = String.valueOf(combi1[2]);
        
        message.setText("L'ordinateur a déjà choisi sa combinaison.\nA vous de trouver laquelle c'est...\n\nCliquez sur le numéro de la colonne en bas \nPuis sur la couleur que vous souhaitez mettre");
        message.setText(a+b+c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pan_indice = new javax.swing.JPanel();
        pan_infojeu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomjoueurgraph = new javax.swing.JTextField();
        btn_startfacile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_startmoyen = new javax.swing.JButton();
        btn_startdur = new javax.swing.JButton();
        pan_message = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        pan_grillejeu = new javax.swing.JPanel();
        pan_couleur = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        numcase = new javax.swing.JLabel();
        btn_valider = new javax.swing.JButton();
        btn_marron = new javax.swing.JButton();
        btn_bleu1 = new javax.swing.JButton();
        btn_rouge = new javax.swing.JButton();
        btn_vert = new javax.swing.JButton();
        btn_jaune = new javax.swing.JButton();
        btn_orange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_indice.setBackground(new java.awt.Color(204, 102, 0));
        pan_indice.setLayout(new java.awt.GridLayout(12, 4));
        getContentPane().add(pan_indice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 600));

        pan_infojeu.setBackground(new java.awt.Color(0, 153, 204));
        pan_infojeu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("MASTERMIND");
        pan_infojeu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        nomjoueurgraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomjoueurgraphActionPerformed(evt);
            }
        });
        pan_infojeu.add(nomjoueurgraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, -1));

        btn_startfacile.setText("Facile");
        btn_startfacile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startfacileActionPerformed(evt);
            }
        });
        pan_infojeu.add(btn_startfacile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel2.setText("Nom du Joueur : ");
        pan_infojeu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btn_startmoyen.setText("Moyen");
        btn_startmoyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startmoyenActionPerformed(evt);
            }
        });
        pan_infojeu.add(btn_startmoyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        btn_startdur.setText("Difficile");
        btn_startdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startdurActionPerformed(evt);
            }
        });
        pan_infojeu.add(btn_startdur, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        getContentPane().add(pan_infojeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 280, 130));

        pan_message.setBackground(new java.awt.Color(0, 153, 204));
        pan_message.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        pan_message.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 130));

        getContentPane().add(pan_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 280, 150));

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 620, -1, -1));

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, -1));

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, -1, -1));

        pan_grillejeu.setBackground(new java.awt.Color(204, 102, 0));
        pan_grillejeu.setLayout(new java.awt.GridLayout(12, 3));
        getContentPane().add(pan_grillejeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 400, 600));

        pan_couleur.setBackground(new java.awt.Color(0, 153, 204));
        pan_couleur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Choisissez la couleur pour la ");
        pan_couleur.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));
        pan_couleur.add(numcase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, 20));

        btn_valider.setText("Valider");
        btn_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validerActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        btn_marron.setBackground(new java.awt.Color(153, 51, 0));
        btn_marron.setForeground(new java.awt.Color(0, 0, 0));
        btn_marron.setText("Marron");
        btn_marron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marronActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_marron, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        btn_bleu1.setBackground(new java.awt.Color(51, 0, 255));
        btn_bleu1.setForeground(new java.awt.Color(0, 0, 0));
        btn_bleu1.setText("Bleu");
        btn_bleu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bleu1ActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_bleu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        btn_rouge.setBackground(new java.awt.Color(255, 0, 0));
        btn_rouge.setForeground(new java.awt.Color(0, 0, 0));
        btn_rouge.setText("Rouge");
        btn_rouge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rougeActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_rouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        btn_vert.setBackground(new java.awt.Color(0, 153, 0));
        btn_vert.setForeground(new java.awt.Color(0, 0, 0));
        btn_vert.setText("Vert");
        btn_vert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vertActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_vert, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        btn_jaune.setBackground(new java.awt.Color(255, 255, 51));
        btn_jaune.setForeground(new java.awt.Color(0, 0, 0));
        btn_jaune.setText("Jaune");
        btn_jaune.setToolTipText("");
        btn_jaune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jauneActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_jaune, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        btn_orange.setBackground(new java.awt.Color(255, 102, 0));
        btn_orange.setForeground(new java.awt.Color(0, 0, 0));
        btn_orange.setText("Orange");
        btn_orange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orangeActionPerformed(evt);
            }
        });
        pan_couleur.add(btn_orange, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        getContentPane().add(pan_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 280, 180));

        setBounds(0, 0, 1034, 681);
    }// </editor-fold>//GEN-END:initComponents

    private void nomjoueurgraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomjoueurgraphActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomjoueurgraphActionPerformed

    private void btn_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_validerActionPerformed
        validation = true;
        int[] indice= verifiercombi(numligne,mode);
        int nbR = indice[0];
        int nbB = indice[1];
        majgrilleindice(indice, numligne);
        pan_indice.repaint();
        message.setText("Pour rappel:\n  Rouge: une bonne couleur bien placée \n  Blanc: une bonne couleur mais mal placée \n \nAttention l'emplacement des indices ne \ncorrespond pas forcément à celui de votre \ncombinaison !");
        String prenom = nomjoueurgraph.getText();
        if(nbR == 3){
            message.setText("Bravo "+prenom+" ! Vous avez gagné !");
            btn_startfacile.setEnabled(true);
            btn_startmoyen.setEnabled(true);
            btn_startdur.setEnabled(true);
        }
        else if(numligne==11){
            message.setText("Dommage, c'est perdu...");
        }
        numligne +=1;
    }//GEN-LAST:event_btn_validerActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        numcase.setText("1ère colonne");
        numcolonne = 0;
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        numcase.setText("2ème colonne");
        numcolonne = 1;
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        numcase.setText("3ème colonne");
        numcolonne = 2;
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn_startmoyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startmoyenActionPerformed
        pan_message.setVisible(true);
        pan_grillejeu.setVisible(true);
        pan_indice.setVisible(true);
        pan_couleur.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        btn_startfacile.setEnabled(false);
        btn_startmoyen.setEnabled(false);
        btn_startdur.setEnabled(false);
        btn_orange.setEnabled(false);
        btn_marron.setEnabled(false);
        mode = 2;
        
        
        
    }//GEN-LAST:event_btn_startmoyenActionPerformed

    private void btn_bleu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bleu1ActionPerformed
        Boule bouleselec = new Boule("bleu");
        jouerdanscolonne("bleu", numligne, numcolonne, mode);
        pan_grillejeu.repaint();
    }//GEN-LAST:event_btn_bleu1ActionPerformed

    private void btn_rougeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rougeActionPerformed
        Boule bouleselec = new Boule("rouge");
        jouerdanscolonne("rouge", numligne, numcolonne, mode);
        pan_grillejeu.repaint();
    }//GEN-LAST:event_btn_rougeActionPerformed

    private void btn_vertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vertActionPerformed
        Boule bouleselec = new Boule("vert");
        jouerdanscolonne("vert", numligne, numcolonne, mode);
        pan_grillejeu.repaint();
    }//GEN-LAST:event_btn_vertActionPerformed

    private void btn_jauneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jauneActionPerformed
        Boule bouleselec = new Boule("jaune");
        jouerdanscolonne("jaune", numligne, numcolonne, mode);
        pan_grillejeu.repaint();
    }//GEN-LAST:event_btn_jauneActionPerformed

    private void btn_orangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orangeActionPerformed
        Boule bouleselec = new Boule("orange");
        jouerdanscolonne("orange", numligne, numcolonne, mode);
        pan_grillejeu.repaint();
    }//GEN-LAST:event_btn_orangeActionPerformed

    private void btn_marronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marronActionPerformed
        Boule bouleselec = new Boule("marron");
        jouerdanscolonne("marron", numligne, numcolonne, mode);
        pan_grillejeu.repaint();
    }//GEN-LAST:event_btn_marronActionPerformed

    private void btn_startdurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startdurActionPerformed
        pan_message.setVisible(true);
        pan_grillejeu.setVisible(true);
        pan_indice.setVisible(true);
        pan_couleur.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        btn_startfacile.setEnabled(false);
        btn_startmoyen.setEnabled(false);
        btn_startdur.setEnabled(false);
        mode = 3;
    }//GEN-LAST:event_btn_startdurActionPerformed

    private void btn_startfacileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startfacileActionPerformed
        pan_message.setVisible(true);
        pan_grillejeu.setVisible(true);
        pan_indice.setVisible(true);
        pan_couleur.setVisible(true);
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        btn4.setVisible(true);
        btn_startfacile.setEnabled(false);
        btn_startmoyen.setEnabled(false);
        btn_startdur.setEnabled(false);
        mode = 1;

    }//GEN-LAST:event_btn_startfacileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu_facile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu_facile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu_facile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu_facile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu_facile().setVisible(true);
            }
        });
    }

    public void jouerdanscolonne(String coul, int l, int c, int mode) {
        if (mode == 1) {
            grillemode1[l][c].Couleur = coul;
        pan_grillejeu.repaint();
        }
    }

    public void majgrilleindice(int tab[], int l){
        int nbR = tab[0];
        int nbB = tab[1];
        int temp =0;
        for(int i=0; i<nbR; i++){
            grilleindice1[l][i].Couleur = "indrouge";
            
        }
        for(int j=3; j>=(3-nbB) ; j--){
            grilleindice1[l][j].Couleur = "indblanc";
        }
    }
    
    public int[] verifiercombi(int l, int mode) {
        int nbR = 0; // nombre rouge final
        int nbB = 0;  // nombre blanc final

        // On crée un tableau qui va nous permettre de vérifier les pions bien placés puis ceux mal placés mais bien présents
        boolean Check[] = new boolean[mode + 2];
        if (mode == 1) {
            for (int i = 0; i < 3; i++) {
                if (grillemode1[l][i].Couleur == combi1[i]) {
                    nbR += 1;
                    Check[i] = true;
                }
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (grillemode1[l][j].Couleur != combi1[j] && Check[k] == false && grillemode1[l][k].Couleur == combi1[j]) {
                        nbB += 1;
                        Check[k] = true;
                        break;
                    }

                }

            }

            for (int n = 0; n < 2; n++) {
                if (n == 0) {
                    aide12[l][n] = nbR;
                } else {
                    aide12[l][n] = nbB;
                }
            }

        } 

        int[] valeursRB = {nbR, nbB}; // Comme je ne peux pas retourner deux int, je retourne un tableau contenant mes deux valeurs avec le nombre de rouge en premier.

        return valeursRB; //blablabla
    }
    
    public void creercombinaison(int mode) { // permet de creer la combinaison aléatoire a trouver 
        Random nb = new Random();
        if (mode == 1) {
            for (int i = 0; i < 3; i++) {
                int alea = nb.nextInt(3);
                combi1[i] = listecoul12[alea];
            }
        }

    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn_bleu1;
    private javax.swing.JButton btn_jaune;
    private javax.swing.JButton btn_marron;
    private javax.swing.JButton btn_orange;
    private javax.swing.JButton btn_rouge;
    private javax.swing.JButton btn_startdur;
    private javax.swing.JButton btn_startfacile;
    private javax.swing.JButton btn_startmoyen;
    private javax.swing.JButton btn_valider;
    private javax.swing.JButton btn_vert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea message;
    private javax.swing.JTextField nomjoueurgraph;
    private javax.swing.JLabel numcase;
    private javax.swing.JPanel pan_couleur;
    private javax.swing.JPanel pan_grillejeu;
    private javax.swing.JPanel pan_indice;
    private javax.swing.JPanel pan_infojeu;
    private javax.swing.JPanel pan_message;
    // End of variables declaration//GEN-END:variables
}