package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Usuario extends Persona{

    private String Rol;
    private ArrayList<Double> Ubicacion;

    public Usuario(String usuario, String password, String nombre, String rol, ArrayList<Double> ubicacion) {
        super(usuario, password, nombre);
        Rol = rol;
        Ubicacion = ubicacion;
    }

    public Usuario(String rol, ArrayList<Double> ubicacion) {
        Rol = rol;
        Ubicacion = ubicacion;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public ArrayList<Double> getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(ArrayList<Double> ubicacion) {
        Ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario Rol='" + Rol +", Ubicacion=" + Ubicacion;
    }
}
