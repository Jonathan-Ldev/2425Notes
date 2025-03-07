package com.example.triptracker2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder>{

    public static ArrayList<Trip> listOfTrips = new ArrayList<>(Arrays.asList(
            new Trip("Trip 1", "Description 1"),
            new Trip("Trip 2", "Description 2"),
            new Trip("Trip 3", "Description 3"),
            new Trip("Trip 4", "Description 4")
    ));

    public TripAdapter(Context context){

    }

    public class TripViewHolder extends RecyclerView.ViewHolder{
        public ConstraintLayout containerView;
        public TextView nameTextView;
        public TextView descTextView;
        public TripViewHolder(@NonNull View itemView){
            super(itemView);
            containerView = itemView.findViewById(R.id.trip_card);
            nameTextView = itemView.findViewById(R.id.trip_card_name);
            descTextView = itemView.findViewById(R.id.trip_card_desc);
            containerView.setOnClickListener(v -> {
            Trip trip = (Trip) v.getTag();
            Log.d("TripAdapter", trip.getName()+" was clicked");
            Intent i = new Intent(v.getContext(), TripDetailsActivity.class);
            i.putExtra("name",trip.getName());
            i.putExtra("description",trip.getDescription());
            itemView.getContext().startActivity(i);
            });
        }
    }


    @NonNull
    @Override
    public TripAdapter.TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_card, parent, false);
        return new TripViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TripAdapter.TripViewHolder holder, int position) {
        Trip current = listOfTrips.get(position);
        Log.d("TripAdapter",String.valueOf(position));
        holder.nameTextView.setText(current.getName());
        holder.descTextView.setText(current.getDescription());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return listOfTrips.size();
    }
}
