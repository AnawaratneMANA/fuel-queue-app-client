package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuelqueueapplication.api.ApiClient;
import com.example.fuelqueueapplication.api.interfaces.FuelStationInterface;
import com.example.fuelqueueapplication.api.response.FuelStationDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelStationDetailActivity extends AppCompatActivity {
    String id,location;

    // Define Elements
    TextView textViewFuelStationNameDetails;
    TextView textViewStationOwner;
    TextView textViewServiceStartAt;
    TextView textViewServiceEndAt;
    TextView textViewFuelType;
    TextView textViewVehicleCount;

    // API call interface
    FuelStationInterface fuelStationInterface;

    // Get the Station ID from the Intent



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station_detail);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        location = intent.getStringExtra("locationName");
        getSupportActionBar().setTitle(location);

        // Register elements
        textViewFuelStationNameDetails = findViewById(R.id.fuelStationNameDetails);
        textViewStationOwner= findViewById(R.id.stationOwnerNameDetails);
        textViewServiceStartAt = findViewById(R.id.startTimeDetails);
        textViewServiceEndAt = findViewById(R.id.endTimeDetails);
        textViewFuelType = findViewById(R.id.fuelTypeDetails);
        textViewVehicleCount = findViewById(R.id.noOfVehiclesInQueueDetails);

        // API Call
        //TODO: Pass the ID from the the intent call
        fuelStationInterface =  ApiClient.getClient().create(FuelStationInterface.class);
        Call<FuelStationDetailsResponse> fuelStationDetails = fuelStationInterface.getFuelStationDetails(id);
        fuelStationDetails.enqueue(new Callback<FuelStationDetailsResponse>() {
            @Override
            public void onResponse(Call<FuelStationDetailsResponse> call, Response<FuelStationDetailsResponse> response) {
                if(response.isSuccessful()){
                    FuelStationDetailsResponse fuelStationDetailsResponse = response.body();

                    //Debug
                    System.out.println(fuelStationDetailsResponse.getEndingTime());
                    Toast.makeText(FuelStationDetailActivity.this, "DEBUG: " + fuelStationDetailsResponse.getEndingTime(), Toast.LENGTH_SHORT).show();

                    // Bind details to the interface elements
                    textViewFuelStationNameDetails.setText("IOC Filling Station");
                    textViewStationOwner.setText(fuelStationDetailsResponse.getStationOwner());
                    textViewServiceStartAt.setText(fuelStationDetailsResponse.getStartingTime());
                    textViewServiceEndAt.setText(fuelStationDetailsResponse.getEndingTime());
                    textViewFuelType.setText(fuelStationDetailsResponse.getFuelType());
                    textViewVehicleCount.setText(String.valueOf(fuelStationDetailsResponse.getVehicleCount()));
                }
            }

            @Override
            public void onFailure(Call<FuelStationDetailsResponse> call, Throwable t) {
                Toast.makeText(FuelStationDetailActivity.this, "ERROR: CAN'T GET THE DETAILS!", Toast.LENGTH_SHORT).show();
                System.out.println("DEBUG LOG: " + t);
            }
        });

    }
}