package com.pruebas.protesta_social.objetos;

import java.util.ArrayList;

public class Lugares {

    private ArrayList<Lugar> Luga = new ArrayList<Lugar>();

    public Lugares(){
        Luga = Luga;
    }

    public Lugares(ArrayList<Lugar> lugares) {
        Luga = lugares;
    }

    public ArrayList<Lugar> getLugares() {
        return Luga;
    }

    public void setLugares(Lugar lugares) {
        Luga.add(lugares);
    }
}
