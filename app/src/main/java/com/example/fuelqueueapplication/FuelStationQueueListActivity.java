package com.example.fuelqueueapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.example.fuelqueueapplication.api.ApiClient;
import com.example.fuelqueueapplication.api.interfaces.FuelStationInterface;
import com.example.fuelqueueapplication.api.response.FuelStationResponse;
import com.example.fuelqueueapplication.api.response.QueueResponse;
import com.example.fuelqueueapplication.recyclerViewAdapters.FuelQueueListViewAdapter;
import com.example.fuelqueueapplication.recyclerViewAdapters.FuelStationOwnersListViewAdapter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelStationQueueListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FuelStationInterface fuelStationInterface;
    FuelQueueListViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station_queue_list);
        recyclerView = findViewById(R.id.FuelStationOwnerQueueListRecycleView);

        fuelStationInterface =  ApiClient.getClient().create(FuelStationInterface.class);
        Call<List<QueueResponse>> listCall = fuelStationInterface.getQueueList();

        listCall.enqueue(new Callback<List<QueueResponse>>() {
            @Override
            public void onResponse(Call<List<QueueResponse>> call, Response<List<QueueResponse>> response) {
                if (response.isSuccessful()) {
                    List<QueueResponse> stationResponseList = response.body();
                    recyclerViewAdapter = new FuelQueueListViewAdapter(FuelStationQueueListActivity.this, stationResponseList);
                    recyclerView.setAdapter(recyclerViewAdapter);
                }else {
                    Toast.makeText(FuelStationQueueListActivity.this, "CAN'T_GET_THE_FUEL_STATIONS", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<QueueResponse>> call, Throwable t) {
                Toast.makeText(FuelStationQueueListActivity.this, "INTERNAL_SERVER_ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}