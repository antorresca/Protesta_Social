package com.pruebas.protesta_social.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.pruebas.protesta_social.R;

public class MainActivity extends AppCompatActivity {


    Button btnMapa, btnArengas, btnPanico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMapa = (Button) findViewById(R.id.btn_mapa);
        btnArengas = (Button) findViewById(R.id.btn_arengas);

        btnArengas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), arengas.class);
                startActivity(intent);
            }
        });
    }
}