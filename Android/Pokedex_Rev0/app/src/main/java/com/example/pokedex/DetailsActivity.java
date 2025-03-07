package com.example.pokedex;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {

    private TextView numberTextView, nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //link the widgets to a java obj
        nameTextView = findViewById(R.id.pokemonNameTXT);
        numberTextView = findViewById(R.id.pokemonNumberTXT);

        //get the intent data
        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number",0);

        //set the data to the widget
        nameTextView.setText("Pokemon Name: "+name);
        numberTextView.setText("Pokemon Number: "+String.valueOf(number));

    }
}