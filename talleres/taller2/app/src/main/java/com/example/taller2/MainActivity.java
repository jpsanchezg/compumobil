package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton mapasbtn, imagenesbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapasbtn = findViewById(R.id.btnMapa);
        imagenesbtn = findViewById(R.id.btnImagenes);
        mapasbtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        });
        imagenesbtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainImagenesActivity.class);
            startActivity(intent);
        });
    }
}