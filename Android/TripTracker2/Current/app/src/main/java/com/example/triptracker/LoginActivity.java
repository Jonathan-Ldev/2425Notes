package com.example.triptracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    private EditText emailET, passwordET, nameET;
    private Button loginBTN, registerBTN;
    private TextView switchViewTXT;
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //Linking the widgets to java objects
        emailET = findViewById(R.id.enter_email);
        passwordET = findViewById(R.id.enter_password);
        loginBTN = findViewById(R.id.login_button);
        switchViewTXT = findViewById(R.id.switchView_Text);
        nameET = findViewById(R.id.nameEditText);
        registerBTN = findViewById(R.id.registerBTN);

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
        switchViewTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchView(v);
            }
        });

    }

    //Turn the register widgets visibility on and off
    public void switchView(View view){
        if(nameET.getVisibility() == View.INVISIBLE){
            nameET.setVisibility(View.VISIBLE);
            registerBTN.setVisibility(View.VISIBLE);
            loginBTN.setVisibility(View.INVISIBLE);
            switchViewTXT.setText("Already have an account?");
        }
        else{
            nameET.setVisibility(View.INVISIBLE);
            registerBTN.setVisibility(View.INVISIBLE);
            loginBTN.setVisibility(View.VISIBLE);
            switchViewTXT.setText("Need to Register?");
        }
    }

    private void registerUser(View view){
        String un = emailET.getText().toString();
        String pw = passwordET.getText().toString();
        String name = nameET.getText().toString();
        authManager
    }


}