package com.pruebas.protesta_social.ui;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.Centro_De_Salud;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Punto_De_Encuentro;
import java.util.ArrayList;
import static com.pruebas.protesta_social.ui.Login.*;

public class MainActivity extends AppCompatActivity {

    private ImageView Imagen;
    private Button btnMapa, btnArengas, btnPanico, btnCalendario,btnChat;
    private Intent intent;
    private DatabaseReference referencia;
    private String g;
    private Intent intento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Imagen = (ImageView) findViewById(R.id.Logo_pantalla1);
        btnMapa = (Button) findViewById(R.id.btn_mapa);
        btnArengas = (Button) findViewById(R.id.btn_arengas);
        btnChat = (Button) findViewById(R.id.btnChat);
        btnCalendario = (Button) findViewById(R.id.btn_Calendar);
        referencia = FirebaseDatabase.getInstance().getReference();

        Toast.makeText(MainActivity.this,"Hola "+NombreDeUsuario,Toast.LENGTH_SHORT).show();

        FirebaseDatabase.getInstance().getReference().child("Persona").child(NombreDeUsuario).child("grupo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                CodigoDelGrupo = snapshot.getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        btnArengas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), arengas.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Mapa.class);
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
                        if(g.equals("No")){
                            intent = new Intent(getApplicationContext(),Sala_Chat.class);
                        }else {
                            intent = new Intent(getApplicationContext(),Chat.class);
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
                Intent intent = new Intent(MainActivity.this,Calendario.class);
                startActivity(intent);
            }
        });
    }

}