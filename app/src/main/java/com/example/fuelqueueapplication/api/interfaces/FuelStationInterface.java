package com.example.fuelqueueapplication.api.interfaces;

import com.example.fuelqueueapplication.api.response.FuelStationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FuelStationInterface {
    @GET("/api/FuelStation/getFuelStations")
    Call<List<FuelStationResponse>> getAllFuelStations();

}

// TODO: Interface define #1
// TODO: request / response define
