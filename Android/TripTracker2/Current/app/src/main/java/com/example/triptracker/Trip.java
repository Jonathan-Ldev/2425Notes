package com.example.triptracker;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Trip {
    private String tripName,tripDescription,startDate,endDate, tripId, userId;
    private boolean isPublic;

    public Trip(String tripName, String tripDescription, String startDate, String endDate, String tripId, String userId, boolean isPublic) {
        this.tripName = tripName;
        this.tripDescription = tripDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tripId = tripId;
        this.userId = userId;
        this.isPublic = isPublic;
    }

    public Trip(String tripName, String tripDescription, String startDate, String endDate, boolean isPublic, String userId) {
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
    public Trip(){

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

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    //toMap - converts trip object to a map datatype for firebase
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("tripName", tripName);
        result.put("tripDescription", tripDescription);
        result.put("startDate", startDate);
        result.put("endDate", endDate);
        result.put("isPublic", isPublic);
        result.put("tripId", tripId);
        result.put("userId", userId);
        return result;
    }

    //toString - name and description
    @NonNull
    @Override
    public String toString() {
        return "Trip{" +
                "tripName='" + tripName + '\'' +
                ", tripDescription='" + tripDescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", tripId='" + tripId + '\'' +
                ", userId='" + userId + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}