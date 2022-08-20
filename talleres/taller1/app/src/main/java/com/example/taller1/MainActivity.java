package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private int contLY =0; // contador de layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fibo = findViewById(R.id.fiboBTN);
        Button facto = findViewById(R.id.factoBTN);
        Button Pais = findViewById(R.id.paisesBTN);
        TextView contador = findViewById(R.id.contadorfifac);
        EditText pos = findViewById(R.id.posicionesTXT);
        Spinner factotxt = findViewById(R.id.factoTXT);


        contador.setText("0");
        fibo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , FibonacciActivity.class);
                pos.setError(null);
                String posiblePosicion = pos.getText().toString();
                if("".equals(posiblePosicion)){
                    pos.setError("Introduce un número");
                    pos.requestFocus();
                    return;
                }else
                {
                    contLY ++;
                    intent.putExtra("posicion",pos.getText().toString());
                    startActivity(intent);
                    contador.setText(Integer.toString(contLY) +"  ingreso a fibonacci el:  "+ java.text.DateFormat.getDateTimeInstance().format(new Date()));
                }


            }
        });
        facto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , FactorialActivity.class);
                String Sfacto = (String) factotxt.getSelectedItem();
                if(!Sfacto.equals("Selecciona un numero")) {
                    contLY ++;
                    intent.putExtra("factorial", Sfacto);
                    startActivity(intent);
                    contador.setText(Integer.toString(contLY)+"  ingreso a factorial el:  "+ java.text.DateFormat.getDateTimeInstance().format(new Date()));
                }
                else{
                    ((TextView)factotxt.getSelectedView()).setError("Error message");
                }
            }
        });

        Pais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , PaisActivity.class);
                startActivity(intent);
            }
        });


    }




}