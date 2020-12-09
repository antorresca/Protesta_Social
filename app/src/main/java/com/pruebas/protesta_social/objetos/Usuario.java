package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Usuario extends Persona{

    private String Sindicato;
    private ArrayList<Double> Ubicacion;

    public Usuario() {
    }

    public Usuario(String usuario, String password, String nombre, String sindicato, ArrayList<Double> ubicacion) {
        super(usuario, password, nombre);
        Sindicato = sindicato;
        Ubicacion = ubicacion;
    }

    public Usuario(String sindicato, ArrayList<Double> ubicacion) {
        Sindicato = sindicato;
        Ubicacion = ubicacion;
    }

    public String getSindicato() {
        return Sindicato;
    }

    public void setSindicato(String sindicato) {
        Sindicato = sindicato;
    }

    public ArrayList<Double> getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(ArrayList<Double> ubicacion) {
        Ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario Rol='" + Sindicato +", Ubicacion=" + Ubicacion;
    }
}
