package com.example.triptracker2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddTripActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_trip);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //connect a java obj to our widgets
        EditText tripNameETXT = findViewById(R.id.tripNameETXT);
        EditText tripDescriptionETXT = findViewById(R.id.tripDescriptionETXT);
        CheckBox pubPrivCB = findViewById(R.id.pubPrivCB);
        Button startBTN = findViewById(R.id.startBTN);
        Button endBTN = findViewById(R.id.endBTN);
        Button saveBTN = findViewById(R.id.saveBTN);

        //add listener to save button
        saveBTN.setOnClickListener(view -> {
            String name = tripNameETXT.getText().toString();
            String description = tripDescriptionETXT.getText().toString();
            boolean isPublic = pubPrivCB.isChecked();
            saveTrip(name, description, isPublic);
        });
    }
    private void saveTrip(String name, String description, boolean isPublic){
        Trip t = new Trip(name,description);
       // StreamActivity.listOfTrips.add(t);
        Intent i = new Intent(this, StreamActivity.class);
        i.putExtra("name", t.getName());
        i.putExtra("description", t.getDescription());
        startActivity(i);
    }
}