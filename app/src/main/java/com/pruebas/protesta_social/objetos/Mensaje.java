package com.pruebas.protesta_social.objetos;

public class Mensaje {
    private String Name;
    private String Mensaje;
    private String Hora;

    public Mensaje() {
    }

    public Mensaje(String name, String mensaje, String hora) {
        Name = name;
        Mensaje = mensaje;
        Hora = hora;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }
}
