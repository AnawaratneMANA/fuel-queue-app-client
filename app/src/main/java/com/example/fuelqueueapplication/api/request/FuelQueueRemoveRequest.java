package com.example.fuelqueueapplication.api.request;

public class FuelQueueRemoveRequest {
    private String EndDateTime;
    private String FuelAmount;

    public FuelQueueRemoveRequest(String endDateTime, String fuelAmount) {
        EndDateTime = endDateTime;
        FuelAmount = fuelAmount;
    }
}
