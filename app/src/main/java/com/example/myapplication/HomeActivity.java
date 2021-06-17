package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private TextView email,name;
    private Button btnLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        btnLogout = findViewById(R.id.btn_logout);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email.setText(mAuth.getCurrentUser().getEmail());
        name.setText(mAuth.getCurrentUser().getDisplayName());
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent myIntent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(myIntent);
                HomeActivity.this.finish();
            }
        });
    }
}