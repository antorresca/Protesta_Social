package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Punto_De_Encuentro extends Lugar{

    private String Hora;
    private String Sindicato;

    public Punto_De_Encuentro(double Latitud, double Longitud, String nombre, boolean estado, String hora, String sindicato) {
        super(Latitud, Longitud, nombre, estado);
        Hora = hora;
        Sindicato = sindicato;
    }

    public Punto_De_Encuentro(String hora, String sindicato) {
        Hora = hora;
        Sindicato = sindicato;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getSindicato() {
        return Sindicato;
    }

    public void setSindicato(String sindicato) {
        Sindicato = sindicato;
    }

    @Override
    public String toString() {
        return "Punto_De_Encuentro Hora=" + Hora +", Sindicato='" + Sindicato;
    }
    }

