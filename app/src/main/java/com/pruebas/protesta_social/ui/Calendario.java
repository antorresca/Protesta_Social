package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import com.pruebas.protesta_social.R;

import java.util.Calendar;

public class Calendario extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        tv =findViewById(R.id.TxtView);
    }

    public void AbrirCalendario (View view){
        Calendar cal= Calendar.getInstance();
        int anio=cal.get(Calendar.YEAR);
        int mes=cal.get(Calendar.MONTH);
        int dia=cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(Calendario.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = year + "/" + month + "/" + dayOfMonth;
                tv.setText(fecha);
            }

        } ,anio, mes, dia);
        dpd.show();
    }


}