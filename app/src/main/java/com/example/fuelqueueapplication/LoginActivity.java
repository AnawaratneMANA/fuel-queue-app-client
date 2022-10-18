package com.example.fuelqueueapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fuelqueueapplication.api.interfaces.LoginInterface;
import com.example.fuelqueueapplication.api.request.UserRegisterRequest;
import com.example.fuelqueueapplication.api.response.UserRegisterResponse;
import com.example.fuelqueueapplication.persistance.DBHelper;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    String password, username;
    TextInputLayout passwordInputLayout, usernameInputLayout;
    TextView errorMessage;
    EditText passwordInput, usernameInput;
    LoginInterface loginInterface;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        passwordInputLayout = findViewById(R.id.loginPasswordInputLayout);
        usernameInputLayout = findViewById(R.id.loginUsernameInputLayout);
        passwordInput = findViewById(R.id.lPasswordInput);
        usernameInput = findViewById(R.id.lUsernameInput);
        errorMessage = findViewById(R.id.loginErrorMessage);

    }

    public void onClick(View view) {
        usernameInputLayout.setErrorEnabled(false);
        errorMessage.setText("");
        passwordInputLayout.setErrorEnabled(false);

        if (loginValidation()) {
            singIn();
        }
    }



    private boolean loginValidation() {
        password = passwordInput.getText().toString().trim();
        username = usernameInput.getText().toString().trim();
        passwordInput.setText(password);
        usernameInput.setText(username);

        if (username.isEmpty()) {
            usernameInput.setError("please fill this field");
            return false;
        } else if (password.isEmpty()) {
            passwordInputLayout.setError("please fill this field");
            return false;

        } else if (password.length() > 30) {
            passwordInputLayout.setError("password is too long");
            return false;

        } else {
            return true;
        }
    }

    private void singIn() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(username,"",password,"","");
        Call<UserRegisterResponse> call = loginInterface.userRegister(userRegisterRequest);
        call.enqueue(new Callback<UserRegisterResponse>() {
            @Override
            public void onResponse(Call<UserRegisterResponse> call, Response<UserRegisterResponse> response) {
                if(response.isSuccessful()){


                }else {
                    passwordInputLayout.setError(" ");
                    usernameInput.setError(" ");
                    errorMessage.setText("please check the details again");
                }
            }

            @Override
            public void onFailure(Call<UserRegisterResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "INTERNAL_SERVER_ERROR(CAN'T_REACH_SEVER)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}