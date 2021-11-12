/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package tp2_convertisseurobjet_sahinidis_marquet;

/**
*
* @author louis
*/
public class Convertisseur {
    int convertiseur;
    public static float CelciusVersKelvin( float tempCelcius) {
        float tempKelvin= (float) (tempCelcius + 273.15);
        return tempKelvin;
    }
    public static float KelvinVersCelcius( float tempKelvin) {
        float tempCelcius= (float) (tempKelvin- 273.15);
        return tempCelcius;
    }
    public static float FarenheitVersCelcius( float tempF) {
        float tempC= (float)((tempF-32)*5.0/9);
        return tempC;
    }
    public static float CelciusVersFarenheit( float tempCelcius) {
        float tempF= (float) (tempCelcius*9.0/5+32);
        return tempF;            
    }
    public static float KelvinVersFarenheit( float tempKelvin) {
        float tempF= (float) ((tempKelvin- 273.15)*9.0/5+32);
        return tempF;
    }
    public static float FarenheitVersKelvin( float tempF) {
        float tempK= (float)((tempF-32)*5.0/9+273.15);
        return tempK;
    }
}
