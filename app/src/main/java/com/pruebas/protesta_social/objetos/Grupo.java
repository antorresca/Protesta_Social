package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Grupo {

    private String  Codigo;
    private ArrayList<String> Usuarios;

    public Grupo() {
    }

    public Grupo(String codigo, String usuario) {
        Codigo = codigo;
        Usuarios.add(usuario);
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public ArrayList<String> getUsuarios() {
        return Usuarios;
    }

    public void setUsuario(String usuario) {
        Usuarios.add(usuario);
    }
}
