package com.pruebas.protesta_social.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.Grupo;

import java.util.Map;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class AgregarGrupo extends AppCompatActivity {

    private EditText Codigo_Grupo;
    private Button Agregar_Grupo;
    private String StCodigo;
    private DatabaseReference asignacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_gurpo);

        Codigo_Grupo = (EditText) findViewById(R.id.TxtCodigoGrupo);
        Agregar_Grupo = (Button) findViewById(R.id.btnAgregarGrupo);
        asignacion = FirebaseDatabase.getInstance().getReference();

        Agregar_Grupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StCodigo = Codigo_Grupo.getText().toString();
                if(StCodigo.equals("")){
                    Codigo_Grupo.setError("Requerido");
                }else {
                    asignacion.child("Grupo").child(StCodigo).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                asignacion.child("Persona").child(NombreDeUsuario).child("grupo").setValue(StCodigo);
                                Intent intent = new Intent(AgregarGrupo.this,Chat.class);
                                startActivity(intent);
                            }else{
                                Codigo_Grupo.setError("El codigo no es valido");
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });


    }
}