package com.pruebas.protesta_social.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.objetos.*;

public class Registro extends AppCompatActivity {

    private Button btnBienvenido;
    private EditText NombreI, UsuarioI, PassI;
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
                String Usuario = UsuarioI.getText().toString();
                String Password = PassI.getText().toString();
                if (Name.equals("") || Usuario.equals("") || Password.equals("")) {
                    Validacion(Name,Usuario,Password);
                } else {
                    usuarios.child("Persona").child(Usuario).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                Imprimir(2);
                            }else{
                                Imprimir(3);
                                siguiente();
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

    public void siguiente(){
        String Name = NombreI.getText().toString();
        String Usuario = UsuarioI.getText().toString();
        String Password = PassI.getText().toString();
        FirebaseApp.initializeApp(this);
        Persona persona = new Persona();
        persona.setNombre(Name);
        persona.setUsuario(Usuario);
        persona.setPassword(Password);
        referencia.child("Persona").child(Usuario).setValue(persona);
        Imprimir(3);
        Intent intent = new Intent(Registro.this, MainActivity.class);
        startActivity(intent);
    }

    public void Imprimir(int a) {
        switch (a) {
            case 1:
                Toast.makeText(this, "Llegue", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Registro Existoso", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Problema", Toast.LENGTH_SHORT).show();
                break;
        }

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
                else{
                    Imprimir(4);
                }
            }

        }
    }
}