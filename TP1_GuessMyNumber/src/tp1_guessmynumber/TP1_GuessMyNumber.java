/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_guessmynumber;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author matth
 */
public class TP1_GuessMyNumber {

    /**
     * @param args the command line arguments
     */
            public static void main(String[] args) {
        
        Random generateurAleat = new Random(); /** crétation d'une variable random */
        int n = generateurAleat.nextInt(101); /** affectation d'une valeur aléatoire comprise entre 0 et 100 à la variable n */
        System.out.println(n);
        
        Scanner sc; /**création d'un raccourci pour la fonciton Scaner qui sert à prendre une valeur de l'utilisateur */
        sc = new Scanner(System.in); /** demande à l'utilisateur de saisir une information */
        
        System.out.println("Veuillez choisir votre niveau de difficulté :");
        System.out.println("1 = Facile, 2 = Moyen, 3 = Diffile, 4 = Cauchemar");
        int niv = sc.nextInt(); /** saisis du niveau de difficulté par l'utilisateur */
        
        int piege=10; /** initialisation de la variable piège */
        
        if (niv==1){ /** choix du niveau facile */
                if (n<50){ /** dit si le nombre à chercher se trouve entre 0 et 49 */
                    System.out.println("Le nombre chercher se trouve en dessous de 50.");
                }
                if (50<=n){ /** dit si le nombre à chercher se trouve entre 50 et 100 */
                    System.out.println("Le nombre chercher est compris entre 50 et 100.");
                }
            }
        
        System.out.println("Maintenant, veuillez saisir un nombre entre 0 et 100.");
        int val = sc.nextInt(); /** saisis du nombre choisis par l'utilisateur */
        int compteur = 1; /** intialisation de la variable compteur */
        
        while (val != n){ /** commencement du jeu guessMyNumber */
            if (piege==1 || piege==2 || piege==3){ /** 30% de malchance d'avoir une fausse information, pour le niveau Cauchemar */
                if (val>n){ /** Si le nombre choisis par l'utilisateur est supérieur au nombre rechercher */
                    System.out.println("Votre nombre est trop petit.");
                }
                if (val<n){ /** Si le nombre choisis par l'utilisateur est inférieur au nombre rechercher */
                    System.out.println("Votre nombre est trop grand.");
                }
                if (val==n){ /** Si le nombre choisis par l'utilisateur est égale au nombre rechercher */
                    break; /** Sortie de la boucle while = fin du jeu*/
                }
            } 
            else{ /** ici on est dans le cas où l'ordinateur renvoie une information correct à l'utilisateur */
                if (val>n){ /** Si le nombre choisis par l'utilisateur est supérieur au nombre rechercher */
                    System.out.println("Votre nombre est trop grand.");
                }
                if (val<n){ /** Si le nombre choisis par l'utilisateur est inférieur au nombre rechercher */
                    System.out.println("Votre nombre est trop petit.");
                }
                if (val==n){ /**Si le nombre choisis par l'utilisateur est égale au nombre rechercher */
                    break; /** sortie de la boucle while = fin du jeu */
                }
            }
            
            compteur+=1; /** la variable compteur est ici pour enregistrer le nombre de tentative réalisé */
            val = sc.nextInt();  /** demande a l'utilisateur de choisir un autre nombre puis continuation de la boucle */

            if (niv==3 || niv==4){ /** on entre dans cette condition que si le niveau difficile ou cauchemar est choisis */
                if (compteur==5){ /** Si le nombre ded tentatives arrivent à 5 le jeu s'arrête */
                System.out.println("Vous avez atteint le nombre maximal de tentative !");
                System.out.println("Vous avez perdu.");
                break; /** Sortie de la boucle while = fin du jeu */
                }
                if (niv==4){ /** condition de si le niveau cauchemar et choisis */
                    piege=generateurAleat.nextInt(10); /** relance la probabilité d'erreur et change la valeur de la variable piege */
                }  
            } 
        }
        if (val==n){ /** Si le nombre choisis par l'utilisateur correspond au nombre cherché */
             System.out.println("Bravo vous avez trouvé le nombre après "+ compteur +" tentatives."); /** indique que le joueur a gagné ainsi que le nomnbre de tentative effectué */
        }
    }
}
    
