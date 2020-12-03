package com.pruebas.protesta_social.objetos;

public class Persona {

    private String Usuario;
    private String Password;
    private String Nombre;
    private String Grupo;

    public Persona(String usuario, String password, String nombre) {
        Usuario = usuario;
        Password = password;
        Nombre = nombre;
        Grupo = "";
    }

    public Persona() {
        Usuario = "";
        Password = "";
        Nombre = "";
        Grupo = "";
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona Usuario=" + Usuario +", Password='" + Password +", Nombre='" + Nombre+", Grupo="+Grupo;
    }
}
