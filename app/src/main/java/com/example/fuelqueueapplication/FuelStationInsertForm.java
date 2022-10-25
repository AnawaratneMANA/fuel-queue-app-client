package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fuelqueueapplication.api.ApiClient;
import com.example.fuelqueueapplication.api.interfaces.FuelStationInterface;
import com.example.fuelqueueapplication.api.request.StationTimeUpdateRequest;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuelStationInsertForm extends AppCompatActivity {

    // Variables
    int newHourStarting = -99;
    int newMinuteStarting = -99;
    int newHourEnding = -99;
    int newMinuteEnding = -99;
    private static final String TAG = "FuelStationList";


    // Define elements
    TextInputLayout textInputLayoutStartingTime;
    EditText editTextStartingTime;
    EditText editTextEndingTime;
    Button buttonUpdateStationDetails;

    // API interface
    FuelStationInterface fuelStationInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_station_insert_form);

        // Register UI components
        textInputLayoutStartingTime = findViewById(R.id.FuelServiceStartTime);
        editTextStartingTime = findViewById(R.id.FuelStartTimeInputText);
        editTextEndingTime = findViewById(R.id.FuelEndTimeInputText);
        buttonUpdateStationDetails = findViewById(R.id.InsertFuelStationButton);

        buttonUpdateStationDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStartingAndEndingTime();
            }
        });

        editTextStartingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the Calender method.
                showDateTimePickerDialog(0);
            }
        });

        editTextEndingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showDateTimePickerDialog(1);
            }
        });

        // API call related
        fuelStationInterface = ApiClient.getClient().create(FuelStationInterface.class);
}

    @SuppressLint("SetTextI18n")
    private void showDateTimePickerDialog(int selection) {
        // Implement the method.
        MaterialTimePicker picker =
                new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(10)
                        .setTitleText("Select Appointment time")
                        .build();

        if (selection == 0){
            picker.addOnPositiveButtonClickListener(dialog -> {
                newHourStarting = picker.getHour();
                newMinuteStarting = picker.getMinute();
                editTextStartingTime.setText(newHourStarting + " : "+ newMinuteStarting);
            });
        } else if(selection == 1){
            picker.addOnPositiveButtonClickListener(dialog -> {
                newHourEnding = picker.getHour();
                newMinuteEnding = picker.getMinute();
                editTextEndingTime.setText(newHourEnding + " : "+ newMinuteEnding);
            });
        }

        picker.show(getSupportFragmentManager(), "TAG");
    }

    // Method to update the Starting time and ending time.
    public void updateStartingAndEndingTime(){
        if(newHourStarting != -99 | newMinuteStarting != -99 | newMinuteEnding != -99 | newHourEnding != -99){
            StationTimeUpdateRequest stationTimeUpdateRequest = new StationTimeUpdateRequest();
            stationTimeUpdateRequest.setStartingTime(newHourStarting + " " + newMinuteStarting);
            stationTimeUpdateRequest.setEndingTime(newHourEnding + " " + newMinuteEnding);
            Call<Void> response = fuelStationInterface.updateStartingTimeEndTime("634e0d91ab08525cb4547634", stationTimeUpdateRequest);
            response.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Log.i(TAG, "Updated the Start time and Ending Time");
                    Intent intent = new Intent(FuelStationInsertForm.this, FuelStationActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Log.i(TAG, "Error Occurred while updating " + t);
                }
            });

        } else {
            Toast.makeText(this, "Select the Time!", Toast.LENGTH_SHORT).show();
        }


    }
}