package com.pruebas.protesta_social.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Lugares;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnMapa, btnArengas, btnPanico;

    String Saludo;

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

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Mapa.class);
                startActivity(intent);
            }
        });
    }

    public static ArrayList<Lugar> Guardar_lugares(){
        ArrayList<Lugar> lugares_guardados = new ArrayList<Lugar>();
        final Lugar UN = new Lugar(4.6381938,-74.0840464,"Universidad Nacional de Colombia",true);
        Lugar HUN = new Lugar(4.6486159,-74.0958465,"Hospita Universitario Nacional",true);
        Lugar PB = new Lugar(4.5981206,-74.0760435,"Plaza de Bolivar",true);
        lugares_guardados.add(UN);
        lugares_guardados.add(HUN);
        lugares_guardados.add(PB);
        return lugares_guardados;
    }


}