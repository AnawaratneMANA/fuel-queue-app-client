package com.example.fuelqueueapplication.api.response;

public class UserRegisterResponse {
    private String Id;
    private String Username;
    private String Email;
    private String Password;
    private String PasswordKey;
    private String Role;
    private String VehicleType;

    public UserRegisterResponse(String id, String username, String email, String password,
                                String passwordKey, String role, String vehicleType) {
        Id = id;
        Username = username;
        Email = email;
        Password = password;
        PasswordKey = passwordKey;
        Role = role;
        VehicleType = vehicleType;
    }
}
