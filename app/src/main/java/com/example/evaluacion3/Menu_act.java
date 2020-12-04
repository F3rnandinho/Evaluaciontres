package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private VideoView  videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        videoview = (VideoView) findViewById(R.id.video);
        String v ="android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri x = Uri.parse(v);
        MediaController media = new MediaController(this);
        videoview.setMediaController(media);
        videoview.setVideoURI(x);
        videoview.requestFocus();
        videoview.setZOrderOnTop(true);
        videoview.start();



    }
    public void Firebase(View view)
    {

        Intent f = new Intent(Menu_act.this, firebase_act.class);
        startActivity(f);

    }
        public void Promos(View view)
        {

            ArrayList<String> Personas = new ArrayList<String>();
            Personas.add("Ramiro");
            Personas.add("Rosa");
            Personas.add("Robert");

            Intent P = new Intent(Menu_act.this, Promociones_act.class);
            P.putExtra("listaClientes", Personas);
            startActivity(P);
    }
}