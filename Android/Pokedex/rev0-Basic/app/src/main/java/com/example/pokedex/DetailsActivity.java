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

    private TextView nameTextView, descriptionTXT, stageTXT, healthTXT, lengthTXT, weightTXT, move1NameTXT, move2NameTXT, move1PowerTXT, move2PowerTXT, weaknessTXT, strengthTXT, retreatCostTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);


        //link the widgets to a java obj
        nameTextView = findViewById(R.id.pokemonNameTextView);
        descriptionTXT = findViewById(R.id.pokemonDescriptionTextView);
        stageTXT = findViewById(R.id.pokemonStageTextView);
        healthTXT = findViewById(R.id.pokemonHPTextView);
        lengthTXT = findViewById(R.id.pokemonLengthTextView);
        weightTXT = findViewById(R.id.pokemonWeightTextView);
        move1NameTXT = findViewById(R.id.pokemonMove1TextView);
        move2NameTXT = findViewById(R.id.pokemonMove2TextView);
        move1PowerTXT = findViewById(R.id.pokemonMove1PowerTextView);
        move2PowerTXT = findViewById(R.id.pokemonMove2PowerTextView);
        weaknessTXT = findViewById(R.id.pokemonWeaknessTextView);
        strengthTXT = findViewById(R.id.pokemonResistanceTextView);



        //get the intent data
        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number",0);
        String description = getIntent().getStringExtra("description");
        int stage = getIntent().getIntExtra("stage",0);
        int health = getIntent().getIntExtra("health",0);
        String length = getIntent().getStringExtra("length");
        String weight = getIntent().getStringExtra("weight");
        String move1Name = getIntent().getStringExtra("move1Name");
        String move2Name = getIntent().getStringExtra("move2Name");
        int move1DMG = getIntent().getIntExtra("move1DMG",0);
        int move2DMG = getIntent().getIntExtra("move2DMG",0);
        String weakness = getIntent().getStringExtra("weakness");
        String strength = getIntent().getStringExtra("strength");
        int retreatCost = getIntent().getIntExtra("retreatCost",0);

        //set the data to the widget
        nameTextView.setText(name);
        descriptionTXT.setText(description);
        stageTXT.setText(String.valueOf(stage));
        healthTXT.setText(String.valueOf(health));
        lengthTXT.setText(length);
        weightTXT.setText(weight);
        move1NameTXT.setText(move1Name);
        move2NameTXT.setText(move2Name);
        move1PowerTXT.setText(String.valueOf(move1DMG));
        move2PowerTXT.setText(String.valueOf(move2DMG));
        weaknessTXT.setText(weakness);
        strengthTXT.setText(strength);



    }
}