package com.example.fuelqueueapplication.api.interfaces;

import com.example.fuelqueueapplication.api.request.UserRegisterRequest;
import com.example.fuelqueueapplication.api.response.UserRegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {
    @POST("/api/User/registration")
    Call<UserRegisterResponse> userRegister(@Body UserRegisterRequest registerRequest);

    @POST("/api/User/login")
    Call<UserRegisterResponse> userLogin(@Body UserRegisterRequest loginRequest);

}
