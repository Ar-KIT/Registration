package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Retrieve intent and message
        Intent intent = getIntent();
        String fName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Set welcome message
        TextView welcomeMessage = findViewById(R.id.welcome_message);
        welcomeMessage.setText("Welcome to Google, " + fName + "!");
    }
}