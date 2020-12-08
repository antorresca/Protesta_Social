package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Grupo {

    private String  Codigo;
    private String Propietario;

    public Grupo() {
    }

    public Grupo(String codigo, String usuario) {
        Codigo = codigo;
        Propietario = usuario;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }
}
