package com.example.triptracker2;

import androidx.annotation.NonNull;

public class Trip {
    private String name;
    private String description;
    private boolean isPublic;

    public Trip(String name, String description) {
        this.name = name;
        this.description = description;
        this.isPublic = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    @NonNull
    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
