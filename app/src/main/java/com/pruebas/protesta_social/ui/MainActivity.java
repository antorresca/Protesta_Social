package com.pruebas.protesta_social.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.objetos.Lugar;
import com.pruebas.protesta_social.objetos.Lugares;

import java.util.ArrayList;

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

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Mapa.class);
                startActivity(intent);
            }
        });
    }

    public static ArrayList<Lugar> Guardar_lugares() {
        ArrayList<Lugar> lugares_guardados = new ArrayList<Lugar>();
        final Lugar UN = new Lugar(4.6381938, -74.0840464, "Universidad Nacional de Colombia", true);
        final Lugar HUN = new Lugar(4.6486159, -74.0958465, "Hospita Universitario Nacional", true);
        final Lugar PB = new Lugar(4.5981206, -74.0760435, "Plaza de Bolivar", true);
        final Lugar PN = new Lugar(4.6238922, -74.061574, "Parque Nacional", true);
        final Lugar HP = new Lugar(4.6472533, -74.0974426, "Hospital de la Policia", true);
        final Lugar CR = new Lugar(4.6731833, -74.0891943, "Cruz Roja", true);
        final Lugar ME = new Lugar(4.623215, -74.0827248, "Hospital Universitario Mederi", true);
        final Lugar IR = new Lugar(4.5986259, -74.0642973, "Instituto Roosevelt", true);
        final Lugar CM = new Lugar(4.6270462, -74.0692266, "Clinica Magdalena", true);
        final Lugar CMY = new Lugar(4.6367632, -74.0650575, "Clinica Marly", true);
        final Lugar HCO = new Lugar(4.6169033, -74.081163, "Hospital Central Oriental", true);
        final Lugar CNU = new Lugar(4.6342842, -74.0708978, "Clinica Nueva", true);
        final Lugar HM = new Lugar(4.6353246, -74.0618594, "Hospital Militar Central", true);
        final Lugar CU = new Lugar(4.6482242, -74.1065512, "Clinica Universitaria Colombia", true);
        final Lugar PE = new Lugar(4.6247963, -74.0671206, "Plazoleta Ecopetrol", true);
        final Lugar UD = new Lugar(4.6281256, -74.0655418, "Universidad Distrital", true);
        final Lugar UP = new Lugar(4.6583654, -74.0591799, "Universidad Pedagogica", true);
        final Lugar CMC = new Lugar(4.6150676, -74.067326, "Universidad Colegio Mayor de Cundinamarca", true);
        lugares_guardados.add(UN);
        lugares_guardados.add(HUN);
        lugares_guardados.add(PB);
        lugares_guardados.add(PN);
        lugares_guardados.add(HP);
        lugares_guardados.add(CR);
        lugares_guardados.add(ME);
        lugares_guardados.add(IR);
        lugares_guardados.add(CM);
        lugares_guardados.add(CMY);
        lugares_guardados.add(HCO);
        lugares_guardados.add(CNU);
        lugares_guardados.add(HM);
        lugares_guardados.add(CU);
        lugares_guardados.add(PE);
        lugares_guardados.add(UD);
        lugares_guardados.add(UP);
        lugares_guardados.add(CMC);
        return lugares_guardados;
    }

    public static LatLng Crear(){
        Lugar b = new Lugar();
        return b.getCoordenadas();
    }


}