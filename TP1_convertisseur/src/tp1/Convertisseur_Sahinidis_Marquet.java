/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

import java.util.Scanner;

/**
 *
 * @author matth
 */
public class Convertisseur_Sahinidis_Marquet {
    public static void main(String[] args) {
        String ch1= " ";
        String ch2 = " ";
        double val1, val, temp, ch; //val1= valeur originel , val = temp a modifier , temp=valeur temporaire,  ch= choix de conversion
        System.out.println("Bonjour, saisissez la valeur a convertir: ");
        Scanner sc;
        sc = new Scanner(System.in);
        val = sc.nextDouble();
        val1=val;
        System.out.println("Saisissez la conversion que vous souhaitez :");
        System.out.println("1)Celsius to kelvin \n2)Kelvin to Celsius \n3)Kelvin to Fahrenheit \n4)Fahrenheit to Kelvin \n5)Fahrenheit to Celsius \n6)Celsius to Fahrenheit");
        ch = sc.nextInt();
        if (ch==1) {
            ch1 = "Celsius";
            ch2 ="Kelvin";
            temp = val;
            val = temp + 273;
        }
        if (ch==2) {
            ch1 = "Kelvin";
            ch2 = "Celsius";
            temp = val;
            val = temp - 273;
        }
        if (ch==3) {
            ch1 = "Kelvin";
            ch2 ="Fahrenheit";
            temp = val;
            val = ((temp -273.15)*1.8)+32;
        }
        if (ch==4) {
            ch1 = "Fahrenheit";
            ch2 ="Kelvin";
            temp = val;
            val = ((temp -32)*5.0)/9;
            temp = val;
            val=temp+273.15;
        }
        if (ch==5) {
            ch1 = "Fahrenheit";
            ch2 ="Celsius";
            temp = val;
            val = ((temp -32)*5.0)/9;
        }
        if (ch==6) {
            ch1 = "Celsius";
            ch2 ="Fahrenheit";
            temp = val;
            val = ((temp*9)/5.0)+32;
        }
        System.out.print(val1+" degres ");
        System.out.print(ch1);
        System.out.print(" est égal à "+val+" degres ");
        System.out.print(ch2);
    }
}