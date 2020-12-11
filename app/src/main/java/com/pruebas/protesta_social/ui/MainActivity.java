package com.pruebas.protesta_social.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.Centro_De_Salud;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Punto_De_Encuentro;

import java.util.ArrayList;

import static com.pruebas.protesta_social.logic.Principal.places;
import static com.pruebas.protesta_social.ui.Login.*;


public class MainActivity extends AppCompatActivity {

    private Button btnMapa, btnArengas, btnTips, btnPanico, btnCalendario, btnChat;
    private Intent intent;
    private DatabaseReference referencia;
    private String g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMapa = (Button) findViewById(R.id.btn_mapa);
        btnArengas = (Button) findViewById(R.id.btn_arengas);
        btnChat = (Button) findViewById(R.id.btnChat);
        btnCalendario = (Button) findViewById(R.id.btn_Calendar);
        btnTips = (Button) findViewById(R.id.btn_tips);
        btnPanico = (Button) findViewById(R.id.btn_panico);
        referencia = FirebaseDatabase.getInstance().getReference();
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},1000);

        Toast.makeText(MainActivity.this, "Hola " + NombreDeUsuario, Toast.LENGTH_SHORT).show();

        FirebaseDatabase.getInstance().getReference().child("Persona").child(NombreDeUsuario).child("grupo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CodigoDelGrupo = snapshot.getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        if(CodigoDelGrupo.equals("Derechos-Humanos")){
            FirebaseDatabase.getInstance().getReference().child("Ayuda").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try {
                        Log.e("Hola","Legue aca xd");
                        String Nombre = snapshot.child("nombre").getValue().toString();
                        double Lat = Double.parseDouble(snapshot.child("coordenadas").child("latitude").getValue().toString());
                        double Lon = Double.parseDouble(snapshot.child("coordenadas").child("longitude").getValue().toString());
                        Lugar Emergencia = new Lugar(Lat, Lon, "Emergencia " + Nombre, true);
                        places.setLugares(Emergencia);
                    }catch(Exception e){
                        Log.e("Hola","Jueputaaa "+e);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        btnArengas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Arengas.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mapa.class);
                startActivity(intent);
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                referencia.child("Persona").child(NombreDeUsuario).child("grupo").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        g = snapshot.getValue().toString();
                        if (g.equals("No")) {
                            intent = new Intent(getApplicationContext(), Sala_Chat.class);
                        } else {
                            intent = new Intent(getApplicationContext(), Chat.class);
                        }
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calendario.class);
                startActivity(intent);
            }
        });

        btnTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tips.class);
                startActivity(intent);
            }
        });

        btnPanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Principal.Emergencia();
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                }
                try{
                LocationManager ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Location l = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(ubicacion!=null && l!=null){
                double latitude = l.getLatitude();
                double longitud = l.getLongitude();
                Lugar ayuda = new Lugar();
                ayuda.setCoordenadas(latitude,longitud);
                ayuda.setNombre(NombreDeUsuario);
                ayuda.setEstado(true);
                FirebaseDatabase.getInstance().getReference().child("Ayuda").setValue(ayuda);
                Toast.makeText(MainActivity.this, "Tu ubicacion fue compartida con personal capacitado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Es necesario acceder a tu ubicacion actual, activala el gps de tu dispositivo",Toast.LENGTH_SHORT).show();
                }}
                catch(Exception e){
                    Toast.makeText(MainActivity.this,"Es necesario que *Atenas* acceda a tu ubicacion actual, concedele el permiso desde tu dispositivo",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}