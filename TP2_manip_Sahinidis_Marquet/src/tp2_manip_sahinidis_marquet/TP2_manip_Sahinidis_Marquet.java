/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_manip_sahinidis_marquet;

/**
 *
 * @author matth
 */

public class TP2_manip_Sahinidis_Marquet {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) { 
        // TODO code application logic here
        Tartiflette assiette1 = new Tartiflette(500);
        Tartiflette assiette2 = new Tartiflette(600);
        
        assiette2.nbCalories = 856;
        Tartiflette assiette3 = assiette2;
          //il n'y a que 2 tartiflettes car 'new' n'apparait que 2 fois
          //assiette2 et assiette3 étant la même tartiflette
        System.out.println("nb de calories de Assiette 3: " + assiette3.nbCalories);
        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories) ;
        System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories) ;
    
        assiette2 = assiette1;
        assiette1 = assiette3;
        
        System.out.println("nb decalories de Assiette 1: " + assiette1.nbCalories);
        System.out.println("nb de calories de Assiette 2: " + assiette2.nbCalories);
        
    
    
    /*Les lignes suivantes sont elles justes ?
    Moussaka assiette666 = assiette1 ; 
    Moussaka assiette667 = new Tartiflette() 
    NON, car on ne peut pas déclarer un objet d'une classe dans une autre classe
    ;*/
    
        Moussaka [] tableau = new Moussaka[10];

        for (int i=0;i<tableau.length;i++){
            tableau[i] = new Moussaka(100*(1+i));
            if (i==tableau.length-1){
                System.out.println(tableau[i]);  
            }
            else {
               System.out.print(tableau[i]+" ; ");
            }




        }
    }
}
    

