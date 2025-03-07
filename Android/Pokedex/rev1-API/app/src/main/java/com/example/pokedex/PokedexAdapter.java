package com.example.pokedex;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {

    //data to display - saving all of our data in this list
    private List<Pokemon> thePokemonList = new ArrayList<>();
    private RequestQueue requestQueue;

    //inner class = class inside of a class - code to build each card
    public class PokedexViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView textView;
        public PokedexViewHolder(@NonNull View itemView) {
            super(itemView);
            //containerView is each card we see
            containerView = itemView.findViewById(R.id.pokedex_card);
            //textView is the information in each card
            textView = itemView.findViewById(R.id.pokedex_card_txt);
            //making the cards do something when clicked
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //find out which Pokemon we clicked on by casting it from a containerView's Tag
                    Pokemon pokemonThatWeClickedOn = (Pokemon) containerView.getTag();
                    Log.d("Container OnClick",pokemonThatWeClickedOn.getName());
                    Intent intent = new Intent(view.getContext(),DetailsActivity.class);
                    //'key','value'
                    intent.putExtra("name",pokemonThatWeClickedOn.getName());
                    intent.putExtra("number",pokemonThatWeClickedOn.getNumber());
                    intent.putExtra("url",pokemonThatWeClickedOn.getUrl());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    //PokedexAdapter Constructor = allow our MainActivity to run code when it starts
    PokedexAdapter(Context c){
        requestQueue = Volley.newRequestQueue(c);
        loadPokemon();
    }

    @NonNull
    @Override
    //first method to run and it creates the ViewHolder
    // ViewHolder -> the viewing window of each Card (PokemonCard)
    // Example: Slack or Discord > Each message sent from a User
    public PokedexAdapter.PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_card,parent,false);
        return new PokedexViewHolder(view);
    }

    @Override
    //tells what each widget is in the card (ViewHolder)
    //This also helps sets up any clickable action we do with our cards
    public void onBindViewHolder(@NonNull PokedexAdapter.PokedexViewHolder holder, int position) {
        Pokemon pokemonThatWeClickedOn = thePokemonList.get(position);
        holder.textView.setText(pokemonThatWeClickedOn.getName());
        holder.containerView.setTag(pokemonThatWeClickedOn);
    }

    @Override
    //tells the adapter how long it needs to be or what size the recycler view needs to be
    //how many items are in my recycler view
    public int getItemCount() {
        return thePokemonList.size();
    }

    //creates the request to obtain the data from the API and place it in the ArrayList
    public void loadPokemon(){
        //figure out the API url
        String url = "https://pokeapi.co/api/v2/pokemon?limit=151";
        //setup the request - and lots lots more...
        //new JsonObjectRequest(web method, url, anyListeners, methods to happen after the request
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //if we get a 200 response code - HTTP response code
                try{
                    //to put everything in an ARRAY
                    JSONArray results = response.getJSONArray("results"); //"results" is the parameter in the json
                    //then loop through the array and get the name and url of each Pokemon
                    for(int i=0;i<results.length();i++){
                        JSONObject data = results.getJSONObject(i);
                        String name = data.getString("name");
                        String url = data.getString("url");
                        //finally add the pokemon to the list of pokemon
                        thePokemonList.add(new Pokemon(name,url));
                    }
                    notifyDataSetChanged();
                }
                catch (JSONException e){
                    Log.e("Adapter LoadPokemon", "Json error",e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Adapter LoadPokemon","Pokeapi: "+error);
            }
        });
        //add the request to the queue
        requestQueue.add(request);
    }
}
