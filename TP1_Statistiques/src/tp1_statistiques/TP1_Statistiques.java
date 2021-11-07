/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_statistiques;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author matth
 */
public class TP1_Statistiques {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Scanner sc; /**création d'un raccourci pour la fonciton Scaner qui sert à prendre une valeur de l'utilisateur */
        sc = new Scanner(System.in); /** demande à l'utilisateur de saisir une information */
        
        Random generateurAleat = new Random(); /** crétation d'une variable random */
        
        System.out.println("Veuillez saisir un nombre de lancé de dé :");
        int m = sc.nextInt();
        double tabDouble [] = new double [6]; /** Initialisation du tableau d'entier */
        
        for (int i=0; i<m; i++){ /** boucle qui compte le nombre de fois où tel ou tel face tombe et ajoute +1 dans la case correspondante du tableau */
            int valD = generateurAleat.nextInt(6); /** affectation d'une valeur aléatoire comprise entre 0 et 5 à la variable n */
            if (valD==0){ /** compte le nombre de fois où le chiffre 1 tombe */
              tabDouble [0]+=1;
            }
            if (valD==1){ /** compte le nombre de fois où le chiffre 2 tombe */
              tabDouble [1]+=1;
            }
            if (valD==2){ /** compte le nombre de fois où le chiffre 3 tombe */
              tabDouble [2]+=1;
            }
            if (valD==3){ /** compte le nombre de fois où le chiffre 4 tombe */
              tabDouble [3]+=1;
            }
            if (valD==4){ /** compte le nombre de fois où le chiffre 5 tombe */
              tabDouble [4]+=1;
            }
            if (valD==5){ /** compte le nombre de fois où le chiffre 6 tombe */
              tabDouble [5]+=1;
            }
        }
        for (int j=0; j<6; j++){ /** Boucle qui permet de changer le résultat du tableau précédent en pourcentage*/
            tabDouble [j]=tabDouble[j]*100/m;
        }
        System.out.println("Les valeurs ci-dessous, sont toutes en pourcentages :");
        System.out.println(Arrays.toString(tabDouble)); /** affiche le tableau aisni que ses valeurs */
    }   
}