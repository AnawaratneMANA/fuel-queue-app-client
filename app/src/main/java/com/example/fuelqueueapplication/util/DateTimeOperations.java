package com.example.fuelqueueapplication.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Use the Test class to test the logics. TEST_CLASS: DateTimeOperationTest.java
 * **/

public class DateTimeOperations {

    // Globals
    final static String dateFormat  = "dd-MM-yyyy HH:mm:ss" ;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    Date date = new Date();

    // Get the Date in "06/11/2017 12:26:18" format.
    public String getDate(){
        return formatter.format(date);
    }

    //TODO: When String time given output separate hours and minutes
    public DateTimeModel stringTimeToHoursAndMinutes(String time){
        String dateArray[] = time.split(" ");
        DateTimeModel dateTimeModel = new DateTimeModel();
        dateTimeModel.setHours(dateArray[0]);
        dateTimeModel.setMinutes(dateArray[1]);
        return dateTimeModel;
    }
    //TODO: When String Datetime given output Date
    public DateTimeModel stringDateTimeToDateOnly(){
        DateTimeModel dateTimeModel = new DateTimeModel();
        // Implement the logic
        return dateTimeModel;
    }
    //TODO: When String Datetime given output Time
    public DateTimeModel stringDateTimeToTime(){
        DateTimeModel dateTimeModel = new DateTimeModel();
        // Implement the logic
        return dateTimeModel;
    }

}
