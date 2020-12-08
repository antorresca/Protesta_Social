package com.pruebas.protesta_social.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.pruebas.protesta_social.ui.Login.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.*;

public class Registro extends AppCompatActivity {

    private Button btnBienvenido;
    private EditText NombreI, PassI;
    public static EditText UsuarioI;
    private FirebaseDatabase base;
    private DatabaseReference referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnBienvenido = (Button) findViewById(R.id.btnRegistro);
        NombreI = findViewById(R.id.NombreIngreso);
        UsuarioI = findViewById(R.id.UsuarioIngreso);
        PassI = findViewById(R.id.ContrasenaIngreso);
        FirebaseApp.initializeApp(this);
        base = FirebaseDatabase.getInstance();
        referencia = base.getReference();
        DatabaseReference usuarios = FirebaseDatabase.getInstance().getReference();
        btnBienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = NombreI.getText().toString();
                NombreDeUsuario = UsuarioI.getText().toString();
                String Password = PassI.getText().toString();
                if (Name.equals("") || NombreDeUsuario.equals("") || Password.equals("")) {
                    Validacion(Name,NombreDeUsuario,Password);
                } else {
                    usuarios.child("Persona").child(NombreDeUsuario).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                UsuarioI.setError("Usuario ya existente");
                            }else{
                                siguiente(Name,NombreDeUsuario,Password);
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

    public void siguiente(String Name, String Usuario, String Password){
        FirebaseApp.initializeApp(this);
        Persona persona = Principal.crear_Usuario(Name,Usuario,Password);
        referencia.child("Persona").child(Usuario).setValue(persona);
        Toast.makeText(Registro.this, "Registro Existoso", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Registro.this, MainActivity.class));
    }

    private void Validacion(String Nombre, String Usuario, String Password) {

        if (Nombre.equals("")) {
            NombreI.setError("Requerido");
        } else {
            if (Usuario.equals("")) {
                UsuarioI.setError("Requerido");
            } else {
                if (Password.equals("")) {
                    PassI.setError("Requerido");
                }
            }
        }
    }
}