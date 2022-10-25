package com.example.fuelqueueapplication.api.request;

public class FuelQueueRequest {


    private String VehicleNumber;
    private String StationId;
    private String UserId;
    private String PumpId;


    public FuelQueueRequest(String vehicleNumber, String stationId, String userId, String pumpId) {
        VehicleNumber = vehicleNumber;
        StationId = stationId;
        UserId = userId;
        PumpId = pumpId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getStationId() {
        return StationId;
    }

    public void setStationId(String stationId) {
        StationId = stationId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPumpId() {
        return PumpId;
    }

    public void setPumpId(String pumpId) {
        PumpId = pumpId;
    }
}
