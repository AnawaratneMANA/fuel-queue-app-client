package com.example.fuelqueueapplication.api.interfaces;
import com.example.fuelqueueapplication.api.request.FuelQueueRemoveRequest;
import com.example.fuelqueueapplication.api.request.FuelQueueRequest;
import com.example.fuelqueueapplication.api.request.FuelRequestRequest;
import com.example.fuelqueueapplication.api.request.StationTimeUpdateRequest;
import com.example.fuelqueueapplication.api.response.FuelQueueResponse;
import com.example.fuelqueueapplication.api.response.FuelRequestResponse;
import com.example.fuelqueueapplication.api.response.FuelStationDetailsResponse;
import com.example.fuelqueueapplication.api.response.FuelStationResponse;
import com.example.fuelqueueapplication.api.response.UserHistoryResponse;
import com.example.fuelqueueapplication.api.response.UserRegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FuelStationInterface {
    @GET("/api/FuelStation/getFuelStations")
    Call<List<FuelStationResponse>> getAllFuelStations();

    @GET("/api/FuelStation/getUserHistory/{id}")
    Call<List<UserHistoryResponse>> getUserHistory(@Path("id") String id);

    @GET("/api/FuelStation/get/{id}")
    Call<FuelStationDetailsResponse> getFuelStationDetails(@Path("id") String id);

    @PUT("/api/FuelStation/updateStartEndTime/{id}")
    Call<Void> updateStartingTimeEndTime(@Path("id") String id, @Body StationTimeUpdateRequest updateTime);

    @POST("/api/FuelStation/AddFuelRequest")
    Call<FuelRequestRequest> createRequest(@Body FuelRequestRequest fuelRequestRequest);

    //TODO: Enroll to the Queue. (POST)
    //TODO: Add to Queue (POST)
    @POST("/api/FuelStation/addFuelStationQueue")
    void enrollToQueue(@Body FuelQueueRequest fuelQueueRequest);
    //TODO: Remove from the Queue. (DELETE)
    //TODO: Add to History (POST)
    @DELETE("/api/FuelStation/removeFuelQueue/{id}")
    void fuelQueueRemove(@Path("id") String id,@Body FuelQueueRemoveRequest fuelQueueRemoveRequest);
    //TODO: Get Queue list (GET)
    @GET("/api/FuelStation/getFuelQueue")
    Call<List<FuelQueueResponse>> getFuelQueue();
    //TODO: Get List of Request (GET)
    @GET("/api/FuelStation/getFuelRequests")
    Call<List<FuelRequestResponse>> getFuelRequest();
}
