package com.pruebas.protesta_social.logic;

import java.util.ArrayList;

public class Principal {

    public static String CrearGrupo(String palabra){
        int numero = 0;
        char[] letras = palabra.toCharArray();
        String Salida = "";
        char[] vocales = {'a','e','i','o','u'};
        for(char letra : letras){
                for(char y : vocales){
                    if(letra == y){
                        numero = 1;
                        break;
                    }
                }
            Salida += String.valueOf(numero);
        }
        return letras[0]+Salida+letras.length;
    }
}
