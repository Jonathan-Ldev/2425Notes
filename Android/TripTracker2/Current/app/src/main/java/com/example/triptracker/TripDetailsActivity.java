package com.example.triptracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class TripDetailsActivity extends AppCompatActivity {

    private String name, desc, startDate, endDate, tripId, userId;
    private boolean isPublic;
    private int existingTrip;
    private CRUDManager crudManager;
    private CheckBox privateTripCB;
    private FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trip_details);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        crudManager = new CRUDManager();

        Button saveBTN = findViewById(R.id.save_button);
        EditText tripNameET = findViewById(R.id.enter_trip_name);
        EditText tripDescriptionET = findViewById(R.id.enter_trip_description);
        Button startDateBTN = findViewById(R.id.start_date_button);
        Button endDateBTN = findViewById(R.id.end_date_button);
        TextView testTXT = findViewById(R.id.testTXT);
        privateTripCB = findViewById(R.id.trip_public);

        //Pull data from intent that came from StreamActivity
        name = getIntent().getStringExtra("name");
        desc = getIntent().getStringExtra("description");
        startDate = getIntent().getStringExtra("startDate");
        endDate = getIntent().getStringExtra("endDate");
        isPublic = getIntent().getBooleanExtra("isPublic", false);
        tripId = getIntent().getStringExtra("tripId");
        userId = getIntent().getStringExtra("userId");

        //If the name and desc are null, don't set the text, and if they are not null, set the text
        if(name != null){
            testTXT.setText(name);
            tripNameET.setText(name);
            tripDescriptionET.setText(desc);
            startDateBTN.setText(startDate);
            endDateBTN.setText(endDate);
            privateTripCB.setChecked(isPublic);
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
            //Get the data from the edit texts
            name = tripNameET.getText().toString();
            desc = tripDescriptionET.getText().toString();
            startDate = startDateBTN.getText().toString();
            endDate = endDateBTN.getText().toString();
            isPublic = privateTripCB.isChecked();

            //Get the current user to see if logged in
            FirebaseUser currentUser = auth.getCurrentUser();
            if(currentUser != null){
                String uid = currentUser.getUid();
                Trip t = new Trip(name, desc, startDate, endDate, tripId, uid, isPublic);
                Log.d("TripDetailsActivity",t.toString());
                //tripId of the trip object is not null means we already exist
                if(t.getTripId() != null){
                    updateTrip(t);
                }
                else{
                    writeNewTrip(t);
                }
            }
            else{
                Toast.makeText(TripDetailsActivity.this, "You are not logged in", Toast.LENGTH_SHORT).show();
            }
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

    private void writeNewTrip(Trip trip){
        crudManager.writeNewTrip(trip, new CRUDManager.CrudCallBack() {

            @Override
            public void onComplete(boolean success, String errorMessage) {
                if(success){
                    //If it is saved, then head back to the StreamActivity
                    startActivity(new Intent(TripDetailsActivity.this, StreamActivity.class));
                }
                else{
                    //If it is not saved, then Toast the error message
                    Toast.makeText(TripDetailsActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateTrip(Trip trip){
        crudManager.updateTrip(trip, new CRUDManager.CrudCallBack(){
            @Override
            public void onComplete(boolean success, String errorMessage){
                if(success){
                    startActivity(new Intent(TripDetailsActivity.this, StreamActivity.class));
                }
                else{
                    Toast.makeText(TripDetailsActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}



//https://www.geeksforgeeks.org/how-to-popup-datepicker-while-clicking-on-edittext-in-android/