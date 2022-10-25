package com.example.fuelqueueapplication.api.request;

public class FuelQueueRequest {
    private String StationId;
    private String VehicleNumber;
    private String UserId;
    private String PumpId;
    private String Status;
    private String StartingDateTime;

    public FuelQueueRequest(String stationId, String vehicleNumber, String userId, String pumpId,
                            String status, String startingDateTime) {
        StationId = stationId;
        VehicleNumber = vehicleNumber;
        UserId = userId;
        PumpId = pumpId;
        Status = status;
        StartingDateTime = startingDateTime;
    }
}
