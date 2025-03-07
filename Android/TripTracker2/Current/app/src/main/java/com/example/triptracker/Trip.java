package com.example.triptracker;

import androidx.annotation.NonNull;

public class Trip {
    private String tripName,tripDescription,startDate,endDate;
    private boolean isPublic;

    public Trip(String tripName, String tripDescription, String startDate, String endDate, boolean isPublic) {
        this.tripName = tripName;
        this.tripDescription = tripDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPublic = isPublic;
    }
    public Trip(String tripName, String tripDescription){
        this.tripName = tripName;
        this.tripDescription = tripDescription;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    //toString - name and description
    @NonNull
    @Override
    public String toString() {
        return "Trip Name: " + tripName +
                "\n\tTrip Description: " + tripDescription;
    }
}
