package com.pruebas.protesta_social.objetos;

import com.google.android.gms.maps.model.LatLng;

public class Lugar {

    private String Nombre;
    private boolean Estado;
    private LatLng Coordenadas;

    public Lugar(double Latitud, double Longitud, String nombre, boolean estado) {
        Coordenadas = new LatLng(Latitud, Longitud);
        Nombre = nombre;
        Estado = estado;
    }

    public Lugar() {
        Coordenadas = new LatLng(4.6533326,-74.083652);
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
        Coordenadas = new LatLng(Latitud, Longitud);
    }

    public LatLng getCoordenadas() {
        return Coordenadas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return Nombre+" \nCoordenadas:"+ Coordenadas.toString()+"\nEstado:"+Estado;
    }
}
