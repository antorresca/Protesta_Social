package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.pruebas.protesta_social.R;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Telefono extends AppCompatActivity {

    private EditText Tel;
    private String Telefono;
    private Button Sigui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        Tel = findViewById(R.id.TxtTel);
        Sigui = findViewById(R.id.btnSigui);

        Sigui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Telefono = Tel.getText().toString();
                if(Telefono.equals("")){
                    Tel.setError("Requerido");
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Persona").child(NombreDeUsuario).child("telefono").setValue(Telefono);
                    startActivity(new Intent(Telefono.this,MainActivity.class));
                }
            }
        });

    }
}