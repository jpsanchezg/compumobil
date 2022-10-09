package com.example.tallermapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SelectMapsActivity extends AppCompatActivity {
    Button bntgoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_maps);
        bntgoogle = findViewById(R.id.googlemapsBTN);
        bntgoogle.setOnClickListener(v -> {
            startActivity(new Intent(this, MapsActivity.class));
        });

    }
}