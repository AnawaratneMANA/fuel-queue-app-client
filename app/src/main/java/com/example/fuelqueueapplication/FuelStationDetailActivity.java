package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FuelStationDetailActivity extends AppCompatActivity {
    String id,location;

    // Define Elements
    TextView textViewFuelStationNameDetails;
    TextView textViewStationOwner;
    TextView textViewServiceStartAt;
    TextView textViewServiceEndAt;
    TextView textViewFuelType;
    TextView textViewVehicleCount;


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

    }
}