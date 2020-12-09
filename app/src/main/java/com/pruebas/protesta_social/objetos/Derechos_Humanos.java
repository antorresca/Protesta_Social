package com.pruebas.protesta_social.objetos;

public class Derechos_Humanos extends Persona {

    private String Telefono;

    public Derechos_Humanos() {
    }

    public Derechos_Humanos(String usuario, String password, String nombre, String telefono) {
        super(usuario, password, nombre);
        Telefono = telefono;
    }

    public Derechos_Humanos(String telefono) {
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
        return "Derechos Humanos \n Telefono=" + Telefono;
    }
}
