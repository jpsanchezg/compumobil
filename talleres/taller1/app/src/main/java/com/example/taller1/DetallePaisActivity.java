package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetallePaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pais);
        TextView capital = findViewById(R.id.capital);
        TextView nombrepaisint = findViewById(R.id.nombrepaisint);
        TextView nombrepais = findViewById(R.id.nombrepais);
        TextView sigla = findViewById(R.id.sigla);
        Intent i = getIntent();
        Pais dene = (Pais)i.getSerializableExtra("datospais");

        if(Locale.getDefault().toString().equals("en_US")){
            capital.setText("Capital: "+dene.getCapital());
            nombrepais.setText("name of the country in spanish: "+ dene.getNombre_pais());
            nombrepaisint.setText("international country name: "+ dene.getNombre_pais_int());
            sigla.setText("country acronym: "+ dene.getSigla());
            setTitle(dene.getNombre_pais_int());
        }else{
            capital.setText("Capital: "+dene.getCapital());
            nombrepais.setText("Nombre normal del pais: "+dene.getNombre_pais());
            nombrepaisint.setText("Nombre internacional del pais: "+ dene.getNombre_pais_int());
            sigla.setText("Sigla del pais: "+ dene.getSigla().toLowerCase(Locale.ROOT));
            setTitle(dene.getNombre_pais());
        }

        ImageView bmImage = findViewById(R.id.bandera);
        Picasso.get().load("https://www.worldatlas.com/img/flag/"+dene.getSigla().toLowerCase(Locale.ROOT)+"-flag.jpg").into(bmImage);
    }


}