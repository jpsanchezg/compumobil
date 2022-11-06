package com.jps.taller3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jps.taller3.databinding.ActivityMainBinding;
import com.jps.taller3.models.Usuario;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private FirebaseAuth mAuth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginMBTN.setVisibility(View.GONE);
        binding.RegisterBTN.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            updateUI(currentUser);
        } else {
            binding.loginMBTN.setVisibility(View.VISIBLE);
            binding.RegisterBTN.setVisibility(View.VISIBLE);
        }
        binding.loginMBTN.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));

        binding.RegisterBTN.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
    }


    private void updateUI(FirebaseUser user) {
        if (user != null) {
            myRef = FirebaseDatabase.getInstance().getReference("users").child(user.getUid());

            myRef.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        finish();
                    }
                }
            });

        }
    }
}