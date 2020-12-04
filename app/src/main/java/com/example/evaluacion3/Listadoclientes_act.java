package com.example.evaluacion3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Clases.Firebaseclass;


public class Listadoclientes_act extends AppCompatActivity {

    private ListView lista;
    private Button borrar;
    private ArrayList<Firebaseclass> listfireclass = new ArrayList<Firebaseclass>();

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    Firebaseclass fireclassSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadoclientes_act);

        lista = (ListView)findViewById(R.id.list);
        borrar = (Button)findViewById(R.id.eliminar);

        iniciar();

        databaseReference.child("Personas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Firebaseclass L = objSnapshot.getValue(Firebaseclass.class);
                    listfireclass.add(L);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listfireclass);
                    lista.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fireclassSelected = (Firebaseclass) parent.getItemAtPosition(position);
            }
        });
    }

    public void Br(View v)
    {
        Firebaseclass P = new Firebaseclass();
        P.setId(fireclassSelected.getId());
        databaseReference.child("Personas").child(P.getId()).removeValue();

        Toast.makeText(this, " Persona eliminada de la base!! ", Toast.LENGTH_LONG).show();
    }

    public void iniciar(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}
