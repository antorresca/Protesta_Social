package com.pruebas.protesta_social.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.pruebas.protesta_social.logic.Contenedor;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.pruebas.protesta_social.R;
import java.util.ArrayList;
import java.util.List;

import static com.pruebas.protesta_social.ui.Login.*;

public class Chat extends AppCompatActivity {

    private TextView Comunicador,Titulo;
    private EditText Msj;
    private ImageButton Enviar;
    private RecyclerView Mensajes;
    private List<Mensaje> ListMensajes;
    private Contenedor ContenedorMsjs;
    private CollectionReference chat;

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
        CodigoDelGrupo = Principal.Obtener_Codigo();
        try{
            if(CodigoDelGrupo==null || CodigoDelGrupo==""){
                Titulo.setText("Recarga el chat para obtener el codigo");
            }else {
                Titulo.setText("Codigo Grupo : " + CodigoDelGrupo);
            }
        }catch (Exception e){
            Titulo.setText("Error");
        }

        try{
            chat = FirebaseFirestore.getInstance().collection(CodigoDelGrupo);
        }catch(Exception e){
            chat = FirebaseFirestore.getInstance().collection("Chat");
        }
        chat.addSnapshotListener(new EventListener<QuerySnapshot>() {
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
                    Principal.Guardar_Mensaje(Msj.getText().toString(),NombreDeUsuario);
                    Msj.setText("");
                }
            }
        });
    }
}