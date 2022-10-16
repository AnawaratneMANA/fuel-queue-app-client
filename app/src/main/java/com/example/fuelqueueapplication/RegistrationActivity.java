package com.example.fuelqueueapplication;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;


public class RegistrationActivity extends AppCompatActivity {
    String email, password, username, vehicleType;
    TextInputLayout emailInputLayout, passwordInputLayout, usernameInputLayout, vehicleTypeLayout;
    TextView errorMessage;
    EditText emailInput, passwordInput, usernameInput;
    AutoCompleteTextView vehicleTypeInput;
    ArrayAdapter<String> arrayAdapter;
    String[] items = {"Car","Van", "Bus","Motorcycle", "Three Wheel", "Lorry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        emailInput = findViewById(R.id.rEmailInput);
        passwordInput = findViewById(R.id.rPasswordInput);
        usernameInput = findViewById(R.id.rUsernameInput);
        vehicleTypeInput = findViewById(R.id.rVehicleTypeInput);
        emailInputLayout = findViewById(R.id.registerEmailInputLayout);
        passwordInputLayout = findViewById(R.id.registerPasswordInputLayout);
        usernameInputLayout = findViewById(R.id.registerUsernameInputLayout);
        vehicleTypeLayout = findViewById(R.id.registerVehicleTypeInputLayout);
        errorMessage = findViewById(R.id.registerErrorMessage);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.vehicle_item_view,items);

        vehicleTypeInput.setAdapter(arrayAdapter);
        vehicleTypeInput.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vehicleType = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    public void onClick(View view) throws JSONException {
        errorMessage.setText("");
        emailInputLayout.setErrorEnabled(false);
        passwordInputLayout.setErrorEnabled(false);
        vehicleTypeLayout.setErrorEnabled(false);
        usernameInputLayout.setErrorEnabled(false);

        if (registrationValidation()) {
            singUp();
        }


    }

    private boolean registrationValidation() {
        email = emailInput.getText().toString().trim();
        password = passwordInput.getText().toString().trim();
        username = usernameInput.getText().toString().trim();
        emailInput.setText(email);
        passwordInput.setText(password);
        usernameInput.setText(username);

        if (username.isEmpty()) {
            usernameInput.setError("please fill this field");
            return false;
        } else if (email.isEmpty()) {
            emailInputLayout.setError("please fill this field");
            return false;

        } else if (password.isEmpty()) {
            passwordInputLayout.setError("please fill this field");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInputLayout.setError("Enter a valid email address");
            return false;

        } else if (password.length() > 30) {
            passwordInputLayout.setError("password is too long");
            return false;

        } else if (vehicleType.isEmpty()) {
            vehicleTypeLayout.setError("please fill this field");
            return false;

        }else {
            return true;
        }


    }

    private void singUp() {

    }
}