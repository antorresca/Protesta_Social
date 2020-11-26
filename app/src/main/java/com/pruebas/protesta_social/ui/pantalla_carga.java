package com.pruebas.protesta_social.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import com.pruebas.protesta_social.R;

public class pantalla_carga extends AppCompatActivity {

    private final int DURACION = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pantalla_carga);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(pantalla_carga.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION);
    }
}