package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.fuelqueueapplication.api.interfaces.FuelStationInterface;

public class FuelStationDetailsRequestActivity extends AppCompatActivity {

    // Define Elements
    TextView textViewFuelStationNameDetailsRequest;
    TextView textViewStationOwnerRequest;
    TextView textViewServiceStartAtRequest;
    TextView textViewServiceEndAtRequest;
    TextView textViewFuelTypeRequest;
    TextView textViewVehicleCountRequest;
    TextView textViewUserWaitingTimeRequest;

    // API call interface
    FuelStationInterface fuelStationInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station_details_request);

        // Register elements
        textViewFuelStationNameDetailsRequest = findViewById(R.id.stationNameDetailsRequest);
        textViewStationOwnerRequest= findViewById(R.id.stationOwnerNameDetailsRequest);
        textViewServiceStartAtRequest = findViewById(R.id.startingTimeDetailsRequest);
        textViewServiceEndAtRequest = findViewById(R.id.endingTimeDetailsRequest);
        textViewFuelTypeRequest = findViewById(R.id.fuelTypeDetailsRequest);
        textViewVehicleCountRequest = findViewById(R.id.vehiclesInQueueDetailsRequest);
        textViewUserWaitingTimeRequest = findViewById(R.id.waitingTimeInTheQueueDetailsRequest);

    }
}