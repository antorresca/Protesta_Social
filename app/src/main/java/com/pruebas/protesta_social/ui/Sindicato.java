package com.pruebas.protesta_social.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pruebas.protesta_social.R;

import static com.pruebas.protesta_social.ui.Login.NombreDeUsuario;

public class Sindicato extends AppCompatActivity {

    private Spinner SindicatosU;
    private String Sindicato;
    private Button Sig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sindicato);

        SindicatosU = findViewById(R.id.Sindicatos);
        Sig = findViewById(R.id.Siguiete);
        ArrayAdapter<CharSequence> s = ArrayAdapter.createFromResource(this,
                    R.array.sindicatos, android.R.layout.simple_spinner_item);
            s.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            SindicatosU.setAdapter(s);
            SindicatosU.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Sindicato = parent.getItemAtPosition(position).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        Sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Sindicato.equals("")){
                    Toast.makeText(Sindicato.this,"Seleccione sindicato",Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Persona").child(NombreDeUsuario).child("sindicato").setValue(Sindicato);
                    startActivity(new Intent(Sindicato.this,MainActivity.class));
                }
            }
        });
    }
}