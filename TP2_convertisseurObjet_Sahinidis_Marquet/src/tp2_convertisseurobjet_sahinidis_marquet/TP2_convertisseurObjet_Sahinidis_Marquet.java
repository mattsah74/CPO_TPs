/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package tp2_convertisseurobjet_sahinidis_marquet;

import java.util.Scanner;
import static tp2_convertisseurobjet_sahinidis_marquet.Convertisseur.CelciusVersFarenheit;
import static tp2_convertisseurobjet_sahinidis_marquet.Convertisseur.CelciusVersKelvin;
import static tp2_convertisseurobjet_sahinidis_marquet.Convertisseur.FarenheitVersCelcius;
import static tp2_convertisseurobjet_sahinidis_marquet.Convertisseur.FarenheitVersKelvin;
import static tp2_convertisseurobjet_sahinidis_marquet.Convertisseur.KelvinVersCelcius;
import static tp2_convertisseurobjet_sahinidis_marquet.Convertisseur.KelvinVersFarenheit;

/**
*
* @author louis
*/
public class TP2_convertisseurObjet_Sahinidis_Marquet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Bonjour, saisissez une température en Celcius, en Farenheit ou en Kelvin : ");
        //Saisie de la valeur à convertir
        float temp= sc.nextFloat();
        System.out.println("Saisissez la conversion que vous souhaiter effectuer :");
        //Affichage du monde
        System.out.println("1/ De Celcius vers Kelvin \n2/ De Kelvin vers Celcius \n3/ De Farenheit vers Celcius \n4/ De Celcius vers Farenheit \n5/ De Kelvin vers Farenheit \n6/ De Farenheit vers Kelvin");
        int rep = sc.nextInt();
        
        // appel de la fonction correspondant à la bonne conversion
        if (rep==1){
            float temp2 = CelciusVersKelvin(temp);
            System.out.println(temp+" degrés Celcius est égal à "+ temp2+" degrés Kelvin");
        }
        if (rep==2){
            float temp2 = KelvinVersCelcius(temp);
            System.out.println(temp+" degrés Kelvin est égal à "+ temp2+" degrés Celcius");
        }
        if (rep==3){
            float temp2 = FarenheitVersCelcius(temp);
            System.out.println(temp+" degrés Farenheit est égal à "+ temp2+" degrés Celcius");
        }
        if (rep==4){
            float temp2 = CelciusVersFarenheit(temp);
            System.out.println(temp+" degrés Celcius est égal à "+ temp2+" degrés Farenheit");
        }
        if (rep==5){
            float temp2 = KelvinVersFarenheit(temp);
            System.out.println(temp+" degrés Kelvin est égal à "+ temp2+" degrés Farenheit");
        }
        if (rep==6){
            float temp2 = FarenheitVersKelvin(temp);
            System.out.println(temp+" degrés Farenheit est égal à "+ temp2+" degrés Kelvin");
        }
                
        //Récupération d'une température en Celcius
        //float tempC= sc.nextFloat();
        //System.out.println(tempC+"°C");
        //Calcul de la température en Kelvin
        /*float tempK= (float) (tempC + 273.15);
        System.out.println(tempC + "°C = " +tempK+"°K");
        System.out.println(CelciusVersKelvin((float) 98.0)+"°K(conversion C-->K)");
        System.out.println(KelvinVersCelcius((float) 98.0)+"°C (conversion K-->C)");
        System.out.println(KelvinVersFarenheit((float) 98.0)+"°F (conversion K-->F)");
        System.out.println(CelciusVersFarenheit((float) 98.0)+"°F (conversion C-->F)");
        System.out.println(FarenheitVersKelvin((float) 98.0)+"°K(conversion F-->K)");
        */
    }
}
