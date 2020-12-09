package com.pruebas.protesta_social.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.pruebas.protesta_social.ui.Login.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pruebas.protesta_social.R;
import com.pruebas.protesta_social.logic.Principal;
import com.pruebas.protesta_social.objetos.*;

public class Registro extends AppCompatActivity {

    private Button btnBienvenido;
    private EditText NombreI, PassI;
    public static EditText UsuarioI;
    private FirebaseDatabase base;
    private DatabaseReference referencia;
    private Spinner OpcionesUsuarios;
    private String Opcion,Sindicato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnBienvenido = (Button) findViewById(R.id.btnRegistro);
        NombreI = findViewById(R.id.NombreIngreso);
        UsuarioI = findViewById(R.id.UsuarioIngreso);
        PassI = findViewById(R.id.ContrasenaIngreso);
        OpcionesUsuarios = findViewById(R.id.opciones);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones_usuario, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        OpcionesUsuarios.setAdapter(adapter);
        FirebaseApp.initializeApp(this);
        base = FirebaseDatabase.getInstance();
        referencia = base.getReference();
        DatabaseReference usuarios = FirebaseDatabase.getInstance().getReference();
        OpcionesUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Opcion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnBienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = NombreI.getText().toString();
                NombreDeUsuario = UsuarioI.getText().toString();
                String Password = PassI.getText().toString();
                if (Name.equals("") || NombreDeUsuario.equals("") || Password.equals("") || Opcion.equals("Seleccione")) {
                    Validacion(Name,NombreDeUsuario,Password,Opcion);
                } else {
                    usuarios.child("Persona").child(NombreDeUsuario).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                UsuarioI.setError("Usuario ya existente");
                            }else{
                                siguiente(Name,NombreDeUsuario,Password,Opcion,Sindicato);
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

    public void siguiente(String Name, String Usuario, String Password,String rol,String Sind){
        FirebaseApp.initializeApp(this);
        if(rol.equals("Particular")){
            Usuario persona = Principal.crear_Usuario(Name,Usuario,Password,Sind);
            referencia.child("Persona").child(Usuario).setValue(persona);
            Intent intento = new Intent(Registro.this,Sindicato.class);
            Toast.makeText(Registro.this, "Registro Existoso", Toast.LENGTH_SHORT).show();
            startActivity(intento);
        }else{
            Derechos_Humanos persona = Principal.crear_DDHH(Name,Usuario,Password);
            referencia.child("Persona").child(Usuario).setValue(persona);
            Grupo g = new Grupo("Derechos-Humanos",Usuario);
            referencia.child("Grupo").child("Derechos-Humanos").setValue(g);
            Intent intento = new Intent(Registro.this, Telefono.class);
            Toast.makeText(Registro.this, "Registro Existoso", Toast.LENGTH_SHORT).show();
            startActivity(intento);
        }
    }

    private void Validacion(String Nombre, String Usuario, String Password,String Rol) {

        if (Nombre.equals("")) {
            NombreI.setError("Requerido");
        } else {
            if (Usuario.equals("")) {
                UsuarioI.setError("Requerido");
            } else {
                if (Password.equals("")) {
                    PassI.setError("Requerido");
                }else{
                    if(Rol.equals("Seleccione")){
                        Toast.makeText(getApplicationContext(),"Seleccione su rol",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}