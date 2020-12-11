package com.pruebas.protesta_social.logic;

import android.util.Log;

import androidx.annotation.NonNull;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.pruebas.protesta_social.objetos.Centro_De_Salud;
import com.pruebas.protesta_social.objetos.Derechos_Humanos;
import com.pruebas.protesta_social.objetos.Grupo;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Lugares;
import com.pruebas.protesta_social.objetos.Mensaje;
import com.pruebas.protesta_social.objetos.Punto_De_Encuentro;
import com.pruebas.protesta_social.objetos.Usuario;
import static com.pruebas.protesta_social.ui.Login.CodigoDelGrupo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Principal {

    private static DatabaseReference Referencia = FirebaseDatabase.getInstance().getReference();
    private static String Codigo;
    public static Lugares places = new Lugares();

    public void algo(){
    }

    public static String CrearGrupo(String palabra){
        int numero = 0;
        char[] letras = palabra.toCharArray();
        String Salida = "";
        char[] vocales = {'a','e','i','o','u'};
        for(char letra : letras){
                for(char y : vocales){
                    if(letra == y){
                        numero = 1;
                        break;
                    }else{
                        letra = Character.toLowerCase(letra);
                        if(letra == y){
                            numero = 2;
                            break;
                        }else{
                            numero = 3;
                        }
                    }
                }
            Salida += String.valueOf(numero);
        }
        return letras[0]+Salida+letras.length;
    }

    public static void Guardar_lugares(){
        FirebaseDatabase.getInstance().getReference().child("Lugares").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(int a = 0;a<=1000;a++){
                    try{
                        DataSnapshot t = snapshot.child(String.valueOf(a));
                        String Nom = t.child("nombre").getValue().toString();
                        Double Lat = Double.parseDouble(t.child("coordenadas").child("latitude").getValue().toString());
                        Double Lon = Double.parseDouble(t.child("coordenadas").child("longitude").getValue().toString());
                        try{
                            String Tel = t.child("telefono").getValue().toString();
                            Centro_De_Salud cs = new Centro_De_Salud(Lat,Lon,Nom,true,Tel);
                            places.setLugares(cs);
                        }catch (Exception e1){
                            try {
                                String Hor = t.child("hora").getValue().toString();
                                String Sin = t.child("sindicato").getValue().toString();
                                Punto_De_Encuentro pe = new Punto_De_Encuentro(Lat, Lon, Nom, true, Hor, Sin);
                                places.setLugares(pe);
                            }catch(Exception e2){
                                Lugar lc = new Lugar(Lat,Lon,Nom,true);
                                places.setLugares(lc);
                            }
                        }
                        Log.e("Holaaaa","Toy funcionando xd No explote xd");
                        Log.e("Hey",String.valueOf(a)+Nom);
                    }catch (Exception e){
                        Log.e("Holaaaa","No toy funcionando xd Explote xd"+e);
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static Usuario Crear_Usuario(String Name, String Usuario, String Password, String Sindicato){
            Usuario persona = new Usuario();
            persona.setNombre(Name);
            persona.setUsuario(Usuario);
            persona.setPassword(Password);
            persona.setSindicato(Sindicato);
            return persona;
    }

    public static Derechos_Humanos Crear_DDHH(String Name, String Usuario, String Password){
            Derechos_Humanos persona = new Derechos_Humanos();
            final String Grupo = "Derechos-Humanos";
            persona.setNombre(Name);
            persona.setUsuario(Usuario);
            persona.setPassword(Password);
            persona.setGrupo(Grupo);
            return persona;
    }

    public static void Guardar_Grupo(String Nombre){
        CodigoDelGrupo = Principal.CrearGrupo(Nombre);
        Grupo g = new Grupo(CodigoDelGrupo,NombreDeUsuario);
        Referencia.child("Persona").child(NombreDeUsuario).child("grupo").setValue(g.getCodigo());
        Referencia.child("Grupo").child(g.getCodigo()).setValue(g);
        FirebaseFirestore.getInstance().collection(CodigoDelGrupo);
    }

    public static void Guardar_Mensaje(String Msj, String Nombre){
        Random random = new Random();
        int t = random.nextInt(10000);
        com.pruebas.protesta_social.objetos.Mensaje mensaje = new Mensaje();
        mensaje.setName(Nombre);
        mensaje.setMensaje(Msj);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        String HoraActual = simpleDateFormat.format(new Date());
        String ordenador = new SimpleDateFormat("hh:mm:ss").format(new Date());
        mensaje.setHora(HoraActual);
        FirebaseFirestore.getInstance().collection(CodigoDelGrupo).document(ordenador+NombreDeUsuario+t).set(mensaje);
    }

    public static String Obtener_Codigo(){
        Referencia.child("Persona").child(NombreDeUsuario).child("grupo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Codigo = snapshot.getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return Codigo;
    }

    public static void Emergencia(){
        Random random = new Random();
        int t = random.nextInt(10000);
        com.pruebas.protesta_social.objetos.Mensaje mensaje = new Mensaje();
        mensaje.setName(NombreDeUsuario);
        mensaje.setMensaje(NombreDeUsuario+" Está en peligro. Abre tu mapa para obtener su ubicacion");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        String HoraActual = simpleDateFormat.format(new Date());
        String ordenador = new SimpleDateFormat("hh:mm:ss").format(new Date());
        mensaje.setHora(HoraActual);
        FirebaseFirestore.getInstance().collection("Derechos-Humanos").document(ordenador+NombreDeUsuario+t).set(mensaje);
    }

}
