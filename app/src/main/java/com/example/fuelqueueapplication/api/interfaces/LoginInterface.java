package com.example.fuelqueueapplication.api.interfaces;

import com.example.fuelqueueapplication.api.request.UserRegisterRequest;
import com.example.fuelqueueapplication.api.response.UserRegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {
    @POST("/v1.0/app/authentication/sign-in")
    Call<UserRegisterResponse> userRegister(@Body UserRegisterRequest registerRequest);

    @POST("/v1.0/app/authentication/sign-in")
    Call<UserRegisterResponse> userLogin(@Body UserRegisterRequest loginRequest);

}
