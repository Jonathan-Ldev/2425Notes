package com.example.triptracker;

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

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {
    public static ArrayList<Trip> listOfTrips = new ArrayList<>(Arrays.asList(
            new Trip("Trip 1","test1"),
            new Trip("Trip 2","test2"),
            new Trip("Trip 3","test3")));
    public TripAdapter(Context applicationContext) {

    }
    public class TripViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout containerView;
        public TextView nameTextView;
        public TextView descTextView;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            containerView = itemView.findViewById(R.id.trip_card_layout);
            nameTextView = itemView.findViewById(R.id.trip_card_name);
            descTextView = itemView.findViewById(R.id.trip_card_desc);
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Trip current = (Trip) containerView.getTag();
                    Intent i = new Intent(view.getContext(), TripDetailsActivity.class);
                    i.putExtra("name",current.getTripName());
                    i.putExtra("description",current.getTripDescription());
                    view.getContext().startActivity(i);
                }
            });

        }
    }

    @NonNull
    @Override
    public TripAdapter.TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_card,parent,false);
        return new TripViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TripAdapter.TripViewHolder holder, int position) {
        Trip current = listOfTrips.get(position);
        Log.d("TripAdapter", String.valueOf(current));
        holder.nameTextView.setText(current.getTripName());
        holder.descTextView.setText(current.getTripDescription());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return listOfTrips.size();
    }
}
