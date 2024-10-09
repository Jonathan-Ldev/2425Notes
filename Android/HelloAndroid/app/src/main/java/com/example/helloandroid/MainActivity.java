package com.example.helloandroid;
//DO NOT... DO NOT SCREW WITH THE PACKAGE...

//import all libraries
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//public - for all files to access it
//class -> defining a class for the JVM
//MainActivity -> this is where your entire app starts
//extends AppCompactActivity -> DO NOT TOUCH... the library that makes this
//  class have widget and app methods
public class MainActivity extends AppCompatActivity {

    //The decorator that overwrites the onCreate methods from the AppCompactActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //All functions go below the onCreate stuff
    //a f(x) for the button to take in user input and output to text view
    public void sayHello(View v){
        //View v -> is an object of the View class which assist the button to find this f(x)
        //  This goes back to the Model View Controller MVC or Game Loop
        //  YOU MUST DO THIS for using an onClick

        //obtain the info from the widgets
        //WhatLibrary objName = widget from the XML
        EditText userInput = findViewById(R.id.userInputEDT);
        TextView greetingText = findViewById(R.id.outputTXT);

        //output something to the outputTXT
        String input = String.valueOf(userInput.getText());
        greetingText.setText("Hi "+input+", nice to meet you!");

    }


}