package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Centro_De_Salud extends Lugar{

    private String Telefono;

    public Centro_De_Salud(ArrayList<Double> coordenadas, String nombre, String telefono) {
        super(coordenadas, nombre);
        Telefono = telefono;
    }

    public Centro_De_Salud(String telefono) {
        Telefono = telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        return "Centro_De_Salud{" +
                "Telefono='" + Telefono + '\'' +
                '}';
    }
}
