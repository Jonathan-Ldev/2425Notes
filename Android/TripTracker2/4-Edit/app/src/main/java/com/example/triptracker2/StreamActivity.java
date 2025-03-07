package com.example.triptracker2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StreamActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static TripAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button refreshBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stream);


        //get the intent
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String description = i.getStringExtra("description");



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // navigate to add trip activity
            startActivity(new Intent(this, TripDetailsActivity.class));
        });

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new TripAdapter(getApplicationContext());

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}