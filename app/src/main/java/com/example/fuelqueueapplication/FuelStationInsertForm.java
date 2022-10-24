package com.example.fuelqueueapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class FuelStationInsertForm extends AppCompatActivity {

    // Define elements
    TextInputLayout textInputLayoutStartingTime;
    EditText editTextStartingTime;
    EditText editTextEndingTime;
    Button buttonUpdateStationDetails;

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
                Toast.makeText(FuelStationInsertForm.this, "TEST: Update Method!", Toast.LENGTH_SHORT).show();
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
                int newHour = picker.getHour();
                int newMinute = picker.getMinute();
                editTextStartingTime.setText(newHour + ": "+ newMinute);
            });
        } else if(selection == 1){
            picker.addOnPositiveButtonClickListener(dialog -> {
                int newHour = picker.getHour();
                int newMinute = picker.getMinute();
                editTextEndingTime.setText(newHour + "h "+ newMinute + "m ");
            });
        }

        picker.show(getSupportFragmentManager(), "TAG");
    }
}