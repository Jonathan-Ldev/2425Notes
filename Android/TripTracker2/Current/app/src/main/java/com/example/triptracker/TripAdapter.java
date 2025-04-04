package com.example.triptracker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {
    public static ArrayList<Trip> listOfTrips = new ArrayList<>();

    CRUDManager crud = new CRUDManager();

    public TripAdapter(Context applicationContext) {

        crud.getAllTrips(new CRUDManager.TripListCallback() {
            @Override
            public void onTripsLoaded(List<Trip> trips) {
                updateTrips(trips);
            }

            @Override
            public void onTripsLoadError(String errorMessage) {
                Log.e("TripAdapter", "Error loading trips:" + errorMessage);
            }
        });
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
                    i.putExtra("startDate",current.getStartDate());
                    i.putExtra("endDate",current.getEndDate());
                    i.putExtra("isPublic",current.isPublic());
                    i.putExtra("tripId",current.getTripId());
                    i.putExtra("userId",current.getUserId());
                    view.getContext().startActivity(i);
                }
            });

            containerView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Trip current = (Trip) containerView.getTag();
                    crud.deleteTrip(current, new CRUDManager.CrudCallBack() {
                        @Override
                        public void onComplete(boolean success, String errorMessage) {
                            if (success){
                                Toast.makeText(v.getContext(), "Trip Deleted", Toast.LENGTH_SHORT).show();
                                //Remove the item from the list and notify the adapter
                                int position = getAdapterPosition();
                                if(position != RecyclerView.NO_POSITION){
                                    listOfTrips.remove(position);
                                    notifyItemRemoved(position);
                                }
                            }
                            else{
                                Toast.makeText(v.getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    return true;
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

    private void updateTrips(List<Trip> trips){
        listOfTrips.clear();
        listOfTrips.addAll(trips);
        notifyDataSetChanged();
    }
}
