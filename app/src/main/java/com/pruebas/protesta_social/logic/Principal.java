package com.pruebas.protesta_social.logic;

import java.util.ArrayList;

public class Principal {

    public static String CrearGrupo(String palabra){
        int numero = 0;
        String Salida = "";
        char[] vocales = {'a','e','i','o','u'};
        for(char letra : palabra.toCharArray()){
            try{
                numero = Integer.valueOf(letra);
            }catch(Exception e){
                for(char y : vocales){
                    if(letra == y){
                        numero = 1;
                        break;
                    }
                }
            }
            Salida += String.valueOf(numero);
        }
        return Salida;
    }
}
