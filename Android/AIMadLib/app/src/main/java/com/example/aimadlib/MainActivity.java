package com.example.aimadlib;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText adjective1EditText, adjective2EditText, adjective3EditText;
    private EditText verb1EditText, verb2EditText;
    private EditText noun1EditText, noun2EditText, noun3EditText;
    private Button generateStoryButton;
    private TextView storyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts
        adjective1EditText = findViewById(R.id.adjective1EditText);
        adjective2EditText = findViewById(R.id.adjective2EditText);
        adjective3EditText = findViewById(R.id.adjective3EditText);
        verb1EditText = findViewById(R.id.verb1EditText);
        verb2EditText = findViewById(R.id.verb2EditText);
        noun1EditText = findViewById(R.id.noun1EditText);
        noun2EditText = findViewById(R.id.noun2EditText);
        noun3EditText = findViewById(R.id.noun3EditText);

        // Initialize Button
        generateStoryButton = findViewById(R.id.generateStoryButton);

        // Initialize TextView
        storyTextView = findViewById(R.id.storyTextView);

        // Set OnClickListener for the button
        generateStoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAndDisplayStory();
            }
        });
    }

    private void generateAndDisplayStory() {
        // Get the user's input
        String adjective1 = adjective1EditText.getText().toString().trim();
        String adjective2 = adjective2EditText.getText().toString().trim();
        String adjective3 = adjective3EditText.getText().toString().trim();
        String verb1 = verb1EditText.getText().toString().trim();
        String verb2 = verb2EditText.getText().toString().trim();
        String noun1 = noun1EditText.getText().toString().trim();
        String noun2 = noun2EditText.getText().toString().trim();
        String noun3 = noun3EditText.getText().toString().trim();

        // Check if any input is empty
        if (adjective1.isEmpty() || adjective2.isEmpty() || adjective3.isEmpty() ||
                verb1.isEmpty() || verb2.isEmpty() ||
                noun1.isEmpty() || noun2.isEmpty() || noun3.isEmpty()) {
            storyTextView.setText("Please fill in all the blanks!");
            return; // Stop execution if any field is empty
        }

        // Generate the story
        String story = "It was a " + adjective1 + " day when a " + adjective2 + " " + noun1 + " decided to " + verb1 +
                " to the " + noun2 + ".  Along the way, it met a " + adjective3 + " " + noun3 + " and they decided to " + verb2 + " together. It was a very " + adjective3 + " journey!";

        // Display the story
        storyTextView.setText(story);
    }
}

