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
            new Pokemon("Bulbasaur",1, "Seed Pokemon ", 1, 70, "2'4 ", "15.2 lbs", "Vine Whip", "Razor Leaf", 10, 20, "Fire","Water", 2),
            new Pokemon("Ivysaur",2, "Seed Pokemon ", 2, 100, "3'3 ", "24.7 lbs ", "Summoning Aura", "Razor Leaf", 30, 60, "Fire", "Water", 3),
            new Pokemon("Venusaur",3, "Seed Pokemon ", 3, 220, "6'7 ", "221 lbs ", "Pollen Bomb", "Solar Typhoon", 80, 220, "Fire", "Water", 3),
            new Pokemon("Charmander",4, "Lizard Pokemon ", 1, 70, "2'0 ", "18.7 lbs ", "Blazing Destruction", "Steady Firebreathing", 10, 30, "Water", "Grass", 1),
            new Pokemon("Charmeleon",5, "Flame Pokemon ", 2, 90, "3'07 ", "41.9 lbs ", "Claw Slash", "Heat Blast", 30, 70, "Water", "Grass", 2),
            new Pokemon("Charizard",6 , "Flame Pokemon ", 3, 330, "5'07 ", "199.5 lbs ", "Brave Wing", "Explosive Vortex", 60, 330, "Water", "Grass", 2),
            new Pokemon("Squirtle",7 , "Tiny Turtle Pokemon ", 1, 70, "1'08 ", "19.8 lbs ", "Tackle", "Rain Splash", 10, 20, "Electric", "Fire", 1),
            new Pokemon("Wartortle",8 , "Turtle Pokemon ", 2, 90, "3'03 ", "49.6 lbs ", "Tackle", "Waterfall", 30, 70, "Electric", "Fire", 2),
            new Pokemon("Blastoise",9 , "Turtle Pokemon ", 3, 180, "5'03 ", "188.5 lbs ", "Rapid Spin", "Splash Bomb", 30, 120, "Electric", "Fire", 3),
            new Pokemon("Gengar",64 , "Shadow Pokemon ", 3, 130, "4'11 ", "89.3 lbs ", "Poltergeist", "Hollow Dive", 50, 110, "Dark", "Fighting", 0)
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
                    intent.putExtra("description",pokemonThatWeClickedOn.getDescription());
                    intent.putExtra("stage",pokemonThatWeClickedOn.getStage());
                    intent.putExtra("health",pokemonThatWeClickedOn.getHealth());
                    intent.putExtra("length",pokemonThatWeClickedOn.getLength());
                    intent.putExtra("weight",pokemonThatWeClickedOn.getWeight());
                    intent.putExtra("move1Name",pokemonThatWeClickedOn.getMove1Name());
                    intent.putExtra("move2Name",pokemonThatWeClickedOn.getMove2Name());
                    intent.putExtra("move1DMG",pokemonThatWeClickedOn.getMove1DMG());
                    intent.putExtra("move2DMG",pokemonThatWeClickedOn.getMove2DMG());
                    intent.putExtra("weakness",pokemonThatWeClickedOn.getWeakness());
                    intent.putExtra("strength",pokemonThatWeClickedOn.getStrength());
                    intent.putExtra("retreatCost",pokemonThatWeClickedOn.getRetreatCost());
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
