package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.annotations.Until;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import static com.pruebas.protesta_social.ui.Login.*;

public class Sala_Chat extends AppCompatActivity {

    private Button Crear, Codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala__chat);

        Crear = (Button) findViewById(R.id.btnCrearGrupo);
        Codigo = (Button) findViewById(R.id.btnCodigoGrupo);

        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CodigoDelGrupo = Principal.CrearGrupo(NombreDeUsuario);
                Principal.Guardar_Grupo(NombreDeUsuario, CodigoDelGrupo);
                Toast.makeText(Sala_Chat.this,"Grupo Creado",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Sala_Chat.this, Chat.class));
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