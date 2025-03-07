package com.example.triptracker;

import static com.example.triptracker.TripAdapter.listOfTrips;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StreamActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static TripAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private boolean mPublicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stream);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Button refreshBTN = findViewById(R.id.refreshBTN);


        recyclerView = findViewById(R.id.recycler_view);
        adapter = new TripAdapter(getApplicationContext());

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            startActivity(new Intent(this, TripDetailsActivity.class));
        });

        refreshBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshStream();
            }
        });
        }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //this will load up the menu above the page
        getMenuInflater().inflate(R.menu.trip_list_item_context_menu,menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trips_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_refresh) {
            Log.d("StreamActivity", "refresh button");
            refreshStream();
            return true;
        } else if (itemId == R.id.action_new) {
            Log.d("StreamActivity", "new button");
            startActivity(new Intent(StreamActivity.this, TripDetailsActivity.class));
            return true;
        } else if (itemId == R.id.action_logout) {
            Log.d("StreamActivity", "log out button");
            return true;
        } else if (itemId == R.id.action_settings) {
            Log.d("StreamActivity", "settings button");
            return true;
        } else if (itemId == R.id.action_public_trips) {
            Log.d("StreamActivity", "public trips button");
            return true;
        } else if (itemId == R.id.action_my_trips) {
            Log.d("StreamActivity", "private trips button");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //toggle between Public and Private trips
        if(mPublicView){
            menu.findItem(R.id.action_public_trips).setVisible(false);
            menu.findItem(R.id.action_my_trips).setVisible(true);
        } else{
            menu.findItem(R.id.action_public_trips).setVisible(true);
            menu.findItem(R.id.action_my_trips).setVisible(false);
        }
        return true;   //true or the menu won't show
    }
    private void refreshStream(){
            //pull data from intent that came from add trip
            //add to list of trips
            String name = getIntent().getStringExtra("name");
            String desc = getIntent().getStringExtra("description");
            Log.d("StreamActivity",name);
            listOfTrips.add(new Trip(name,desc));
            adapter.notifyDataSetChanged();
//            recyclerView = findViewById(R.id.recycler_view);
//            adapter = new TripAdapter(getApplicationContext());
//            layoutManager = new LinearLayoutManager(this);
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(layoutManager);
//            adapter.notifyDataSetChanged();
        }
    public static void refreshPage(){
        adapter.notifyDataSetChanged();
    }
}


//https://www.geeksforgeeks.org/pull-to-refresh-with-recyclerview-in-android-with-example/#