package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pruebas.protesta_social.logic.Contenedor;
import com.pruebas.protesta_social.objetos.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pruebas.protesta_social.R;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    private TextView Comunicador;
    private EditText Mensaje;
    private ImageButton Enviar;
    private RecyclerView Mensajes;
    private List<Mensaje> ListMensajes;
    private Contenedor ContenedorMsjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Comunicador = (TextView) findViewById(R.id.Nombre_Usuario);
        Mensaje = (EditText) findViewById(R.id.CEditMensaje);
        Enviar = (ImageButton) findViewById(R.id.BtnEnviar);
        Mensajes = (RecyclerView) findViewById(R.id.CMensajes);
        ListMensajes = new ArrayList<>();
        ContenedorMsjs = new Contenedor(ListMensajes);
        Mensajes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Mensajes.setAdapter(ContenedorMsjs);
        Mensajes.setHasFixedSize(true);
    }
}