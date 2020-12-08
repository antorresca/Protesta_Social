package com.pruebas.protesta_social.logic;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pruebas.protesta_social.objetos.Centro_De_Salud;
import com.pruebas.protesta_social.objetos.Grupo;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Mensaje;
import com.pruebas.protesta_social.objetos.Persona;
import com.pruebas.protesta_social.objetos.Punto_De_Encuentro;
import com.pruebas.protesta_social.ui.AgregarGrupo;
import com.pruebas.protesta_social.ui.Chat;
import com.pruebas.protesta_social.ui.Ingresar;
import com.pruebas.protesta_social.ui.MainActivity;

import static com.pruebas.protesta_social.ui.Login.CodigoDelGrupo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Principal {

    private static DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private static String Codigo;

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

    public static ArrayList<Lugar> Guardar_lugares() {
        ArrayList<Lugar> lugares_guardados = new ArrayList<Lugar>();
        final Lugar UN = new Punto_De_Encuentro(4.6381938, -74.0840464, "Universidad Nacional de Colombia", true,"01:00 pm","Estudiantil");
        final Lugar HUN = new Centro_De_Salud(4.6486159, -74.0958465, "Hospita Universitario Nacional", true,"3904888");
        final Lugar PB = new Punto_De_Encuentro(4.5981206, -74.0760435, "Plaza de Bolivar", true,"01:00 pm","Todos");
        final Lugar PN = new Punto_De_Encuentro(4.6238922, -74.061574, "Parque Nacional", true,"01:00 pm","Trabajadores");
        final Lugar HP = new Centro_De_Salud(4.6472533, -74.0974426, "Hospital de la Policia", true,"5804401");
        final Lugar CR = new Centro_De_Salud(4.6731833, -74.0891943, "Cruz Roja", true,"");
        final Lugar ME = new Centro_De_Salud(4.623215, -74.0827248, "Hospital Universitario Mederi", true,"5600520");
        final Lugar IR = new Lugar(4.5986259, -74.0642973, "Instituto Roosevelt", true);
        final Lugar CM = new Lugar(4.6270462, -74.0692266, "Clinica Magdalena", true);
        final Lugar CMY = new Centro_De_Salud(4.6367632, -74.0650575, "Clinica Marly", true,"3436600");
        final Lugar HCO = new Centro_De_Salud(4.6169033, -74.081163, "Hospital Central Oriental", true,"2685221");
        final Lugar CNU = new Lugar(4.6342842, -74.0708978, "Clinica Nueva", true);
        final Lugar HM = new Centro_De_Salud(4.6353246, -74.0618594, "Hospital Militar Central", true,"3486868");
        final Lugar CU = new Centro_De_Salud(4.6482242, -74.1065512, "Clinica Universitaria Colombia", true,"5948650");
        final Lugar PE = new Lugar(4.6247963, -74.0671206, "Plazoleta Ecopetrol", true);
        final Lugar UD = new Punto_De_Encuentro(4.6281256, -74.0655418, "Universidad Distrital", true,"01:00 pm","Estudiantil");
        final Lugar UP = new Punto_De_Encuentro(4.6583654, -74.0591799, "Universidad Pedagogica", true,"01:00 pm","Estudiantil");
        final Lugar CMC = new Punto_De_Encuentro(4.6150676, -74.067326, "Universidad Colegio Mayor de Cundinamarca", true,"01:00 pm","Estudiantil");
        final Lugar SED = new Punto_De_Encuentro(4.6496677,-74.1019179,"Secretaria de Educacion Distrital",true,"10:00am","Profesoral");
        lugares_guardados.add(UN);
        lugares_guardados.add(HUN);
        lugares_guardados.add(PB);
        lugares_guardados.add(PN);
        lugares_guardados.add(HP);
        lugares_guardados.add(CR);
        lugares_guardados.add(ME);
        lugares_guardados.add(IR);
        lugares_guardados.add(CM);
        lugares_guardados.add(CMY);
        lugares_guardados.add(HCO);
        lugares_guardados.add(CNU);
        lugares_guardados.add(HM);
        lugares_guardados.add(CU);
        lugares_guardados.add(PE);
        lugares_guardados.add(UD);
        lugares_guardados.add(UP);
        lugares_guardados.add(CMC);
        lugares_guardados.add(SED);
        return lugares_guardados;
    }

    public static Persona crear_Usuario(String Name, String Usuario, String Password){
        Persona persona = new Persona();
        persona.setNombre(Name);
        persona.setUsuario(Usuario);
        persona.setPassword(Password);
        return persona;
    }

    public static void Guardar_Grupo(String Nombre){
        CodigoDelGrupo = Principal.CrearGrupo(Nombre);
        Grupo g = new Grupo(CodigoDelGrupo,NombreDeUsuario);
        referencia.child("Persona").child(NombreDeUsuario).child("grupo").setValue(g.getCodigo());
        referencia.child("Grupo").child(g.getCodigo()).setValue(g);
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
        referencia.child("Persona").child(NombreDeUsuario).child("grupo").addValueEventListener(new ValueEventListener() {
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
}
