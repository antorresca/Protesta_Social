package com.pruebas.protesta_social.objetos;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Lugar {

    private String Nombre;
    private boolean Estado;
    private LatLng coordenadas;

    public Lugar(double Latitud, double Longitud, String nombre, boolean estado) {
        coordenadas = new LatLng(Latitud, Longitud);
        Nombre = nombre;
        Estado = estado;
    }

    public Lugar() {
        coordenadas = new LatLng(4.6533326,-74.083652);
        Nombre = "Bogota";
        Estado = true;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public void setCoordenadas(double Latitud, double Longitud) {
        coordenadas = new LatLng(Latitud, Longitud);
    }

    public LatLng getCoordenadas() {
        return coordenadas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre+" \nCoordenadas:"+coordenadas.toString()+"\nEstado:"+Estado;
    }
}
