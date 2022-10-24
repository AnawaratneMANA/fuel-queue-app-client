package com.example.fuelqueueapplication.api.response;

public class FuelStationDetailsResponse {
    private String id;
    private String fuelStationName;
    private String stationOwner;
    private String serviceStartAt;
    private String serviceEndAt;
    private String fuelType;
    private int vehicleCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public void setFuelStationName(String fuelStationName) {
        this.fuelStationName = fuelStationName;
    }

    public String getStationOwner() {
        return stationOwner;
    }

    public void setStationOwner(String stationOwner) {
        this.stationOwner = stationOwner;
    }

    public String getServiceStartAt() {
        return serviceStartAt;
    }

    public void setServiceStartAt(String serviceStartAt) {
        this.serviceStartAt = serviceStartAt;
    }

    public String getServiceEndAt() {
        return serviceEndAt;
    }

    public void setServiceEndAt(String serviceEndAt) {
        this.serviceEndAt = serviceEndAt;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }
}
