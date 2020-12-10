package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Usuario extends Persona{

    private String Sindicato;

    public Usuario() {
    }

    public Usuario(String usuario, String password, String nombre, String sindicato) {
        super(usuario, password, nombre);
        Sindicato = sindicato;
    }

    public Usuario(String sindicato) {
        Sindicato = sindicato;
    }

    public String getSindicato() {
        return Sindicato;
    }

    public void setSindicato(String sindicato) {
        Sindicato = sindicato;
    }

    @Override
    public String toString() {
        return "Usuario Rol='" + Sindicato;
    }
}
