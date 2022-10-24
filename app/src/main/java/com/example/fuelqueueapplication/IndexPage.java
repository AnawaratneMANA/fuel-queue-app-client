package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexPage extends AppCompatActivity {

    Button stationDetails;
    Button stationList;
    Button stationDetailsRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);

        stationDetails = findViewById(R.id.stationDetailsButtonDev);
        stationList = findViewById(R.id.stationListButtonDev);
        stationDetailsRequest = findViewById(R.id.stationDetailsRequestDev);

        stationDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FuelStationDetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        stationList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FuelStationActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        stationDetailsRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FuelStationDetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}