package com.example.triptracker2;

import android.app.DatePickerDialog;
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

import java.util.Calendar;

public class TripDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trip_details);
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

        //pull the intent data and place it in the text fields
        Intent i = getIntent();
        tripNameETXT.setText(i.getStringExtra("name"));
        tripDescriptionETXT.setText(i.getStringExtra("description"));

        //setup the date pickers and save to button
        startBTN.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year1, monthOfYear, dayOfMonth) -> {
               startBTN.setText(dayOfMonth + "/" + (monthOfYear +1) + "/" + year1);
            }, year, month, day);
            datePickerDialog.show();
        });

        endBTN.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year1, monthOfYear, dayOfMonth) -> {
                startBTN.setText(dayOfMonth + "/" + (monthOfYear +1) + "/" + year1);
            }, year, month, day);
            datePickerDialog.show();
        });

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