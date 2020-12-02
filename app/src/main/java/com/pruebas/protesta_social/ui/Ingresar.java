package com.pruebas.protesta_social.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import static com.pruebas.protesta_social.ui.Registro.*;
import static com.pruebas.protesta_social.ui.Login.*;
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
import com.pruebas.protesta_social.R;

public class Ingresar extends AppCompatActivity {

    public static EditText User,Pass;
    private Button Bienvenida;
    private DatabaseReference referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        Bienvenida = (Button) findViewById(R.id.btnBien);
        User = (EditText) findViewById(R.id.TxtUsuario);
        Pass = (EditText) findViewById(R.id.TxtPassword);

        Bienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NombreDeUsuario = User.getText().toString();
                String Password = Pass.getText().toString();
                if(NombreDeUsuario.equals("") || Password.equals("")){
                    Validar(NombreDeUsuario,Password);
                }else{
                    referencia = FirebaseDatabase.getInstance().getReference();
                    referencia.child("Persona").child(NombreDeUsuario).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                if(snapshot.child("password").getValue().toString().equals(Password)){
                                    Intent intent = new Intent(Ingresar.this,MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Imprimir1(1);
                                }
                            }else{
                                Imprimir1(2);
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

    public void Imprimir1(int a){
        switch (a){
            case 1:
                Toast.makeText(Ingresar.this,"Usuario o Password erroneos",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(Ingresar.this,"El Usuario no esta registrado",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(Ingresar.this,"Error",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void Validar(String U, String P){
        if(U.equals("")){
            User.setError("Requerido");
        }else{
            if (P.equals("")){
                Pass.setError("Requerido");
            }
        }
    }
}