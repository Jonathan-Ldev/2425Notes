package com.example.pokedex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailsActivity extends AppCompatActivity {

    private TextView numberTextView, nameTextView, typeTextView, moveTextView;
    private RequestQueue requestQueue;

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
        typeTextView = findViewById(R.id.pokemonTypeTXT);
        moveTextView = findViewById(R.id.pokemonMovesTXT);

        //get the intent data
        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number",0);
        String url = getIntent().getStringExtra("url");

        //set the data to the widget
        nameTextView.setText("Pokemon Name: "+name);
        numberTextView.setText("Pokemon Number: "+String.valueOf(number));
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        loadDetails(url);

    }

    private void loadDetails(String url){
        //setup our request
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //grab response and save to Array
                //take what data we need
                try{
                    String number = response.getString("id");
                    numberTextView.setText(number);

                    //Types
                    //telling response to get the JSONArray types
                    JSONArray typeEntries = response.getJSONArray("types");
                    String types = "";
                    for(int i=0;i<typeEntries.length();i++){
                        JSONObject typeEntry = typeEntries.getJSONObject(i);
                        int slot = typeEntry.getInt("slot");
                        String type = typeEntry.getJSONObject("type").getString("name");
                        typeTextView.append(type+" ");
                        Log.d("Type Entry",slot+": "+type);
                    }

                    //Moves
                    JSONArray movesEntries = response.getJSONArray("moves");
                    String moveList="";
                    for(int i=0;i<movesEntries.length();i++){
                        JSONObject moveEntry = movesEntries.getJSONObject(i);
                        String move = moveEntry.getJSONObject("move").getString("name");
                        moveList+=(move+"\n");
                    }
                    moveTextView.append(moveList);
                    Log.d("Move Entry",moveList);

                }catch(JSONException e){
                    Log.e("DetailsActivity", "JSON Error"+e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Pokemon Detail Pull","API: "+error);
            }
        });

        //add to the queue
        requestQueue.add(request);
    }
}