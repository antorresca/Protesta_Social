package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Lugar {

    private ArrayList<Double> Coordenadas;
    private String Nombre;
    private boolean Estado;

    public Lugar(double Latitud, double Longitud, String nombre, boolean estado) {
        Coordenadas.add(Latitud);
        Coordenadas.add(Longitud);
        Nombre = nombre;
        Estado = estado;
    }

    public Lugar() {
        Coordenadas.add(4.6533326);
        Coordenadas.add(-74.083652);
        Nombre = "Bogota";
        Estado = true;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public ArrayList<Double> getCoordenadas() {
        return Coordenadas;
    }

    public void setCoordenadas(double Latitud, double Longitud) {
        Coordenadas.add(Latitud);
        Coordenadas.add(Longitud);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre+" \nCoordenadas: Lat"+Coordenadas.get(0).toString()+" Coordenadas: Long"+Coordenadas.get(1).toString()+"\nEstado:"+Estado;
    }
}
