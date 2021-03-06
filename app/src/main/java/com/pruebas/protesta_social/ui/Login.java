package com.pruebas.protesta_social.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;

public class Login extends AppCompatActivity {

    private Button btnRegistro;
    private Button btnIngresar;
    public static String NombreDeUsuario,CodigoDelGrupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Principal.Guardar_lugares();
        CodigoDelGrupo = "";
        NombreDeUsuario = "";

        btnRegistro = (Button) findViewById(R.id.btnRegister);
        btnIngresar = (Button) findViewById(R.id.btnIngreso);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),Registro.class);
                startActivity(intent1);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),Ingresar.class);
                startActivity(intent2);
            }
        });
    }

}