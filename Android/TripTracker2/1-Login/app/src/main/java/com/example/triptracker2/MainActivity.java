package com.example.triptracker2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //Master username and password
    private String masterUsername = "hi5@gmail.com";
    private String masterPassword = "hiC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //Linking the widgets to java objects
        EditText emailTXT = findViewById(R.id.enterEmail);
        EditText passwordTXT = findViewById(R.id.enterPassword);
        Button loginBTN = findViewById(R.id.loginButton);
        TextView switchViewTXT = findViewById(R.id.switchViewText);

        //Login Button Navigates to StreamActivity
        loginBTN.setOnClickListener(view -> {
            //check if username and password matches the master username and password
            String un = emailTXT.getText().toString();
            String pw = passwordTXT.getText().toString();

            //check if email format
            //check if password has bad characters - SQL injection check
            //check if email or password is blank
            if (un.isBlank() || pw.isBlank()){

            } else if(un.contains("@") || un.contains(".")){

            } else if(un.contains("--") || un.contains("//") || un.contains("\\") || un.contains("/*") || un.contains("*/")){

            } else{
                startActivity(new Intent(this, StreamActivity.class));
            }
            Snackbar.make(view, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
        });


    }
}