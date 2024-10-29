package com.example.intentpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //step 1: create global variables
    private Button screen1BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //step 2: connect java obj to widget
        screen1BTN = findViewById(R.id.screen1BTN);

        //step 3: setup your onclick
        screen1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //step 4: set up your intent object
                //Intent objName = new Constructor(WhereYouAreAt.this, WhereYou'reGoing.class
                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                //step : start the next activity
                startActivity(i);
                //explicit intent -> navigation without data
            }
        });
    }
}