package com.example.evaluacion3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edit1, edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit1 = (EditText) findViewById(R.id.user);
        edit2 = (EditText) findViewById(R.id.passw);

    }
    public void inicio(View view){
        String nombre = edit1.getText().toString();
        String contraseña = edit2.getText().toString();
        if(nombre.equals("Android") && contraseña.equals("123")) {
            Intent a = new Intent(MainActivity.this, Menu_act.class);
            startActivity(a);

        }
        else
            {
                Toast.makeText(getBaseContext(), "Debe ingresar correcto usuario o contraseña!! ", Toast.LENGTH_LONG).show();
        }
    }

}







