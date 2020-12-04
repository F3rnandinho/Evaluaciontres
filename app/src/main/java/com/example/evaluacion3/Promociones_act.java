package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.PreciosPromo;

public class Promociones_act extends AppCompatActivity {

    private Spinner spinn;
    private EditText promo, valor;
    private Button calculo;
    private TextView cliente, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        spinn = (Spinner) findViewById(R.id.spinner);
        promo = (EditText) findViewById(R.id.tx1);
        valor = (EditText) findViewById(R.id.tx2);
        calculo = (Button) findViewById(R.id.btn);
        cliente = (TextView) findViewById(R.id.textView1);
        precio = (TextView) findViewById(R.id.textView2);

        ArrayList<String> listaclientes = (ArrayList<String>) getIntent().getSerializableExtra("listadoclientes");
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaclientes);
        spinn.setAdapter(a);

    calculo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String texto = promo.getText().toString();
            String Personas = spinn.getSelectedItem().toString();
            String resultado = valor.getText().toString();
            int total;
            PreciosPromo P = new PreciosPromo();

            if(valor.equals("Pizzas promo")) {
                total = P.getPizzaspromo() + Integer.parseInt(resultado);
                String l = String.valueOf(total);
                cliente.setText("Estimado/a"+ Personas + " el final segun promocion y envio es: ");
                precio.setText("$" + l );
            }

            if(valor.equals("Master pizza")) {
                total = P.getMasterPizza() + Integer.parseInt(resultado);
                String m = String.valueOf(total);
                cliente.setText("Estimado/a "+ Personas + " el final segun promocion y envio es: ");
                precio.setText("$" + m );
            }

            if(valor.equals("Pizza max")) {
                total = P.getPizzamax() + Integer.parseInt(resultado);
                String n = String.valueOf(total);
                cliente.setText("Estimado/a "+ Personas +" el final segun promocion y envio es: ");
                precio.setText("$" + n );
            }


        }
    });
}
}

