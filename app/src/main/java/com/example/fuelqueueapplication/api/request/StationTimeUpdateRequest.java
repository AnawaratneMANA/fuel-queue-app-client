package com.example.fuelqueueapplication.api.request;

public class StationTimeUpdateRequest {
    private String startingTime;
    private String endingTime;

    public StationTimeUpdateRequest(String startingTime, String endingTime) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }
}
