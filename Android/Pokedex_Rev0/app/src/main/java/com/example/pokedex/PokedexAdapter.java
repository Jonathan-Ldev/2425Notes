package com.example.pokedex;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {

    //data to display - saving all of our data in this list
    private List<Pokemon> thePokemonList = Arrays.asList(
            new Pokemon("Bulbasaur",1),
            new Pokemon("Ivysaur",2),
            new Pokemon("Venusaur",3)
    );

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
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    //first method to run and it creates the ViewHolder
    // ViewHolder -> the viewing window of each Card (PokemonCard)
    // Example: Slack or Discord > Each message sent from a  User
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
}
