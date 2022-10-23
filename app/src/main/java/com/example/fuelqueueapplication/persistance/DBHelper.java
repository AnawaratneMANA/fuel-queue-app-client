package com.example.fuelqueueapplication.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table user (id integer primary key autoincrement, username text, email text, password text, vehicleType text, role text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists user");
        onCreate(DB);

    }

    public boolean saveUser(String username, String email, String password, String vehicleType, String role){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        cv.put("vehicleType",vehicleType);
        cv.put("role",role);

        long result = db.insert("User",null,cv);
        return result == -1;
    }
}
