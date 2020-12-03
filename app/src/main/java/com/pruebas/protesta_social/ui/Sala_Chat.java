package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.Grupo;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Sala_Chat extends AppCompatActivity {
    private Button Crear, Codigo;
    private DatabaseReference datos;
    private String Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala__chat);

        Crear = (Button) findViewById(R.id.btnCrearGrupo);
        Codigo = (Button) findViewById(R.id.btnCodigoGrupo);
        datos = FirebaseDatabase.getInstance().getReference();

        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group = Principal.CrearGrupo(NombreDeUsuario);
                Grupo g = new Grupo(Group,NombreDeUsuario);
                datos.child("Persona").child(NombreDeUsuario).child("Grupo").setValue(g.getCodigo());
                datos.child("Grupo").child(g.getCodigo()).setValue(g);
                Toast.makeText(Sala_Chat.this,"Grupo creado",Toast.LENGTH_SHORT).show();
                FirebaseFirestore.getInstance().collection(Group);
                Intent intent = new Intent(Sala_Chat.this,Chat.class);
                startActivity(intent);
            }
        });

        Codigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sala_Chat.this,AgregarGrupo.class);
                startActivity(intent);
            }
        });
    }
}