package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class FuelStationDetailActivity extends AppCompatActivity {
    String id,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station_detail);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        location = intent.getStringExtra("locationName");
        getSupportActionBar().setTitle(location);
    }
}