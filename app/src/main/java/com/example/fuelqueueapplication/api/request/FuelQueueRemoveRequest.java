package com.example.fuelqueueapplication.api.request;

/**
 * fuel queue remove request class
 * **/
public class FuelQueueRemoveRequest {
    private String EndDateTime;
    private String FuelAmount;

    public FuelQueueRemoveRequest(String endDateTime, String fuelAmount) {
        EndDateTime = endDateTime;
        FuelAmount = fuelAmount;
    }
}
