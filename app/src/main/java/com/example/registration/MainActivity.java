package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.registration.MESSAGE";
    private EditText firstName, lastName, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        Button createButton = findViewById(R.id.createButton);

        createButton.setOnClickListener(v -> {
            String firstNameText = firstName.getText().toString();
            String lastNameText = lastName.getText().toString();
            String usernameText = email.getText().toString();
            String passwordText = password.getText().toString();
            String confirmPasswordText = confirmPassword.getText().toString();

            // Validate the input fields
            if (TextUtils.isEmpty(firstNameText) || TextUtils.isEmpty(lastNameText) || TextUtils.isEmpty(usernameText) ||
                    TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(confirmPasswordText)) {
                Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else if (!passwordText.equals(confirmPasswordText)) {
                Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                create();
            }
        });
    }

    public void create() {
        String fName = firstName.getText().toString();

        // Intent to start second activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, fName);
        startActivity(intent);
    }
}