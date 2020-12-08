package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pruebas.protesta_social.R;

public class Tips extends AppCompatActivity {
    Button btnDefensaPopular, btnMediosLibres, btnP_A_Legales, btnP_A_Medicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        btnDefensaPopular = (Button) findViewById(R.id.btnDefensaPopular);
        btnMediosLibres = (Button) findViewById(R.id.btnMediosLibres);
        btnP_A_Legales = (Button) findViewById(R.id.btnP_A_Legales);
        btnP_A_Medicos = (Button) findViewById(R.id.btnP_A_Medicos);

        btnDefensaPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pdfview1.class);
                startActivity(intent);
            }
        });

        btnMediosLibres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pdfview2.class);
                startActivity(intent);
            }
        });

        btnP_A_Legales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pdfview3.class);
                startActivity(intent);
            }
        });

        btnP_A_Medicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pdfview4.class);
                startActivity(intent);
            }
        });
    }

    public void ir_DefPopular(View view) {
        Intent intent = new Intent (Tips.this, pdfview1.class);
        startActivity(intent);
    }
    public void ir_MedLibre(View view) {
        Intent intent = new Intent (Tips.this, pdfview2.class);
        startActivity(intent);
    }
    public void ir_PALegales(View view) {
        Intent intent = new Intent (Tips.this, pdfview3.class);
        startActivity(intent);
    }
    public void ir_PAMedicos(View view) {
        Intent intent = new Intent (Tips.this, pdfview4.class);
        startActivity(intent);
    }
}