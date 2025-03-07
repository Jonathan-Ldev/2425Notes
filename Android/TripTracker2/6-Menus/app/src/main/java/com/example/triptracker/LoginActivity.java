package com.example.triptracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    //Master username and password
    private String masterUsername = "b@gmail.com";
    private String masterPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //Linking the widgets to java objects
        EditText emailET = findViewById(R.id.enter_email);
        EditText passwordET = findViewById(R.id.enter_password);
        Button loginBTN = findViewById(R.id.login_button);
        TextView switchViewTXT = findViewById(R.id.switchView_Text);

        //Login Button navigates to StreamActivity
        loginBTN.setOnClickListener(v -> {
            //check if username and password matches the master username and password
            String un = emailET.getText().toString();
            String pw = passwordET.getText().toString();

            //check if email format
            //check if password has bad characters - SQL injection check
            //check if email or password is blank
            if (un.isBlank() ||
                pw.isBlank() ||
                !un.contains("@") ||
                !un.contains(".") ||
                un.contains("--") ||
                un.contains("//") ||
                un.contains("\\") ||
                un.contains("/*") ||
                un.contains("*/")) {
//                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

            } else if (un.equals(masterUsername) && pw.equals(masterPassword)) {
                //send the username to the StreamActivity to display
                startActivity(new Intent(this, StreamActivity.class));
            }
            Snackbar.make(v, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
        });
    }
}