package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fuelqueueapplication.api.ApiClient;
import com.example.fuelqueueapplication.api.interfaces.FuelStationInterface;
import com.example.fuelqueueapplication.api.response.FuelStationResponse;
import com.example.fuelqueueapplication.recyclerViewAdapters.FuelStationListRecyclerViewAdapter;
import com.example.fuelqueueapplication.recyclerViewAdapters.FuelStationOwnersListViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelStationListOwnerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //TODO: Will be used to navigate to Queue list, and Request list.
    FloatingActionButton floatingActionButton;
    FuelStationOwnersListViewAdapter recyclerViewAdapter;
    FuelStationInterface fuelStationInterface;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station_list_owner);
        getSupportActionBar().setTitle("All Fuel Stations (Owner)");
        recyclerView = findViewById(R.id.FuelStationOwnerListRecycleView);
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");

        fuelStationInterface =  ApiClient.getClient().create(FuelStationInterface.class);
        Call<List<FuelStationResponse>> listCall = fuelStationInterface.getAllFuelStations();

        listCall.enqueue(new Callback<List<FuelStationResponse>>() {
            @Override
            public void onResponse(Call<List<FuelStationResponse>> call, Response<List<FuelStationResponse>> response) {
                if (response.isSuccessful()) {
                    List<FuelStationResponse> stationResponseList = response.body();
                    recyclerViewAdapter = new FuelStationOwnersListViewAdapter(FuelStationListOwnerActivity.this, stationResponseList);
                    recyclerView.setAdapter(recyclerViewAdapter);
                }else {
                    Toast.makeText(FuelStationListOwnerActivity.this, "CAN'T_GET_THE_FUEL_STATIONS", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FuelStationResponse>> call, Throwable t) {
                Toast.makeText(FuelStationListOwnerActivity.this, "INTERNAL_SERVER_ERROR", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.feul_station_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.locationSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                recyclerViewAdapter.getFilter().filter(text);
                return false;
            }
        });
        return true;
    }
}