package com.example.triptracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class TripDetailsActivity extends AppCompatActivity {

    private int existingTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trip_details);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Button saveBTN = findViewById(R.id.save_button);
        EditText tripNameET = findViewById(R.id.enter_trip_name);
        EditText tripDescriptionET = findViewById(R.id.enter_trip_description);
        Button startDateBTN = findViewById(R.id.start_date_button);
        Button endDateBTN = findViewById(R.id.end_date_button);
        TextView testTXT = findViewById(R.id.testTXT);

        //Pull data from intent that came from StreamActivity
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("description");

        //If the name and desc are null, don't set the text, and if they are not null, set the text
        if(name != null){
            testTXT.setText(name);
            tripNameET.setText(name);
            tripDescriptionET.setText(desc);
            existingTrip = TripAdapter.listOfTrips.indexOf(new Trip(name,desc));
        }

        //Start Date Button opens DatePickerDialog and sets the button text to the selected date
        startDateBTN.setOnClickListener(v ->{
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, monthOfYear, dayOfMonth) -> {
                startDateBTN.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
            }, year, month, day);
            datePickerDialog.show();
        });

        //End Date Button opens DatePickerDialog and sets the button text to the selected date
        endDateBTN.setOnClickListener(v ->{
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, monthOfYear, dayOfMonth) -> {
                endDateBTN.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
            }, year, month, day);
            datePickerDialog.show();
        });

        //Save Button navigates to StreamActivity and saves data as Trip object to Intent
        saveBTN.setOnClickListener(v -> {
            Trip t = new Trip(tripNameET.getText().toString(),tripDescriptionET.getText().toString());
            Intent i = new Intent(this, StreamActivity.class);
            i.putExtra("name",t.getTripName());
            i.putExtra("description",t.getTripDescription());
            //TODO: `per our saving method, we cannot technically save the data back to the list, will fix later
            startActivity(i);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trip_details_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            // Handle home action
            return true;
        } else if (itemId == R.id.action_post) {
            // Handle post action
            return true;
        } else if (itemId == R.id.action_logout) {
            // Handle logout action
            return true;
        } else if (itemId == R.id.action_settings) {
            // Handle settings action
            return true;
        } else if (itemId == R.id.action_delete) {
            // Handle delete action
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}

//https://www.geeksforgeeks.org/how-to-popup-datepicker-while-clicking-on-edittext-in-android/