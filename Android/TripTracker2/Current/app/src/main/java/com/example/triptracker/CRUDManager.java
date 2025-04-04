package com.example.triptracker;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CRUDManager {
    /*  4 main functions of any database or SQL
            C - create
            R - read
            U - update
            D - delete
     */

    private static final String TAG = "CRUDManager";
    private FirebaseAuth auth;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();;

    public CRUDManager() {
        auth = FirebaseAuth.getInstance();
    }

    public interface CrudCallBack {
        void onComplete(boolean success, String errorMessage);
    }

    public interface TripListCallback {
        void onTripsLoaded(List<Trip> trips);
        void onTripsLoadError(String errorMessage);
    }

    //This file's main purpose is to house all f(x) that hit the db
    //////////////     CREATE SECTION   //////////////
    //write a new trip to the db
    public void writeNewTrip(Trip trip, final CrudCallBack callback){
        //Create a new child location for the trip
        String tripId = databaseReference.child("trips").push().getKey();
        //write the data to the db
        databaseReference.child("trips").child(tripId).setValue(trip).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                callback.onComplete(true,null);
            } else{
                callback.onComplete(false,task.getException().getMessage());
            }
        });
    }

    //////////////     READ SECTION   //////////////
    public void getAllTrips(TripListCallback callback){
        databaseReference.child("trips").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Trip> trips = new ArrayList<>();
                for (DataSnapshot eachTrip: snapshot.getChildren()){
                    Trip t = eachTrip.getValue(Trip.class);
                    t.setTripId(eachTrip.getKey());
                    trips.add(t);
                }
                callback.onTripsLoaded(trips);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onTripsLoadError(error.getMessage());
            }
        });
    }

    ////////////////// UPDATE SECTION ///////////////////////
    public void updateTrip(Trip trip, CrudCallBack callback){
        Map<String, Object> tripValues = trip.toMap();
        databaseReference.child("trips").child(trip.getTripId()).updateChildren(tripValues)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        callback.onComplete(true, null);
                    }
                    else{
                        callback.onComplete(false, task.getException().getMessage());
                    }
                });
    }

    ////////////////// DELETE SECTION ///////////////////////
    public void deleteTrip(Trip trip, CrudCallBack callBack){
        databaseReference.child("trips").child(trip.getTripId()).removeValue()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        callBack.onComplete(true, null);
                    }
                    else{
                        callBack.onComplete(false, task.getException().getMessage());
                    }
                });
    }

}