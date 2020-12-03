package com.pruebas.protesta_social.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.pruebas.protesta_social.logic.Contenedor;
import com.pruebas.protesta_social.objetos.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pruebas.protesta_social.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Chat extends AppCompatActivity {

    private TextView Comunicador,Titulo;
    private EditText Msj;
    private ImageButton Enviar;
    private RecyclerView Mensajes;
    private List<Mensaje> ListMensajes;
    private Contenedor ContenedorMsjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Comunicador = (TextView) findViewById(R.id.Nombre_Usuario);
        Titulo = (TextView) findViewById(R.id.TxtCodigo_del_Grupo);
        Msj = (EditText) findViewById(R.id.CEditMensaje);
        Enviar = (ImageButton) findViewById(R.id.BtnEnviar);
        Mensajes = (RecyclerView) findViewById(R.id.CMensajes);
        ListMensajes = new ArrayList<>();
        ContenedorMsjs = new Contenedor(ListMensajes);
        Mensajes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Mensajes.setAdapter(ContenedorMsjs);
        Mensajes.setHasFixedSize(true);
        Comunicador.setText(NombreDeUsuario);
        Titulo.setText("Codigo Grupo : "+FirebaseDatabase.getInstance().getReference()
                .child(NombreDeUsuario).child("Grupo").toString());

        FirebaseFirestore.getInstance().collection(FirebaseDatabase.getInstance().getReference().child(NombreDeUsuario).child("Grupo").toString())
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentChange mDocumentChange : value.getDocumentChanges()){
                    if(mDocumentChange.getType() == DocumentChange.Type.ADDED){
                        ListMensajes.add(mDocumentChange.getDocument().toObject(Mensaje.class));
                        ContenedorMsjs.notifyDataSetChanged();
                        Mensajes.smoothScrollToPosition(ListMensajes.size());
                    }
                }
            }
        });

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Msj.length()!=0){
                    Mensaje mensaje = new Mensaje();
                    mensaje.setName(NombreDeUsuario);
                    mensaje.setMensaje(Msj.getText().toString());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
                    String HoraActual = simpleDateFormat.format(new Date());
                    mensaje.setHora(HoraActual);
                    FirebaseFirestore.getInstance().collection("Chat").add(mensaje);
                    Msj.setText("");
                }
            }
        });
    }
}