package com.example.fuelqueueapplication.api.interfaces;

import com.example.fuelqueueapplication.api.response.FuelStationDetailsResponse;
import com.example.fuelqueueapplication.api.response.FuelStationResponse;
import com.example.fuelqueueapplication.api.response.UserHistoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FuelStationInterface {
    @GET("/api/FuelStation/getFuelStations")
    Call<List<FuelStationResponse>> getAllFuelStations();

    @GET("/api/FuelStation/getUserHistory/{id}")
    Call<List<UserHistoryResponse>> getUserHistory(@Path("id") String id);

    @GET("/api/FuelStation/get/{id}")
    Call<FuelStationDetailsResponse> getFuelStationDetails(@Path("id") String id);
}
