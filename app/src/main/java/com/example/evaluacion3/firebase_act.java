package com.example.evaluacion3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;

import java.util.UUID;

import Clases.Firebaseclass;


public class firebase_act extends AppCompatActivity {

    private EditText nombre, destino, promocion;
    private Button guardado, lista;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        nombre = (EditText) findViewById(R.id.etnombre);
        destino = (EditText) findViewById(R.id.etdestino);
        promocion = (EditText) findViewById(R.id.etpromocion);
        guardado = (Button) findViewById(R.id.btn);
        lista = (Button) findViewById(R.id.btnlista);

        inicializarBase();

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lis = new Intent(firebase_act.this,Listadoclientes_act.class);
                startActivity(lis);
            }
        });

        guardado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nombre.getText().toString().isEmpty())
                {
                    Firebaseclass clase = new Firebaseclass();
                    clase.setId(UUID.randomUUID().toString());
                    clase.setNombre(nombre.getText().toString());
                    clase.setDestino(destino.getText().toString());
                    clase.setPromocion(promocion.getText().toString());

                    databaseReference.child("Personas").child(clase.getId()).setValue(clase);

                    Toast.makeText(getBaseContext(), "Persona guardado con exito!!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Debe ingresar los datos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void inicializarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }


}


