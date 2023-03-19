package com.example.foodwaste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "WASTE_MANAGEMENT.db";
    final static int DATABASE_VERSION = 9;

    // Table for registration table
    final static String TABLE1_NAME ="Registration_table";
    final static String T1COL_1 = "Id";
    final static String T1COL_2 = "UserName";
    final static String T1COL_3 = "Password";
    final static String T1COL_4 = "FullName";
    final static String T1COL_5 = "DOB";
    final static String T1COL_6 = "RestaurantName";
    final static String T1COL_7 = "Location";
    final static String T1COL_8 = "PhoneNumber";

    // Table for Profile
    final static String TABLE2_NAME = "Profile_table";
    final static String T2COL_1 = "ID";
    final static String T2COL_2 = "Username";
    final static String T2COL_3 = "Hobbies";
    final static String T2COL_4 = "FavouriteFood";
    final static String T2COL_5 = "StudentOption";
    final static String T2COL_6 = "Organization";
    final static String T2COL_7 = "StudentID";


    // Table for Login table
    final static String TABLE3_NAME ="Login_table";
    final static String T3COL_1 = "Id";
    final static String T3COL_2 = "UserName";
    final static String T3COL_3 = "Password";
    final static String T3COL_4 = "Type";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query=  "CREATE TABLE " + TABLE1_NAME + "(" + T1COL_1 +
                " INTEGER, " + T1COL_2 + " TEXT PRIMARY KEY, " + T1COL_3 + " TEXT, "+T1COL_4+" TEXT, "+T1COL_5+" DATE, "
                       +T1COL_6+" TEXT, "+T1COL_7+" TEXT, "+T1COL_8+" TEXT)" ;
        sqLiteDatabase.execSQL(query);
                query="CREATE TABLE " + TABLE2_NAME + "(" + T2COL_1 +
                        " INTEGER, " + T2COL_2 + " TEXT PRIMARY KEY, " + T2COL_3 + " TEXT, "+T2COL_4+" TEXT, "+T2COL_5+" DATE, "
                        +T2COL_6+" TEXT, "+T2COL_7+" TEXT)" ;
                sqLiteDatabase.execSQL(query);

            query = "CREATE TABLE "+ TABLE3_NAME + "("+ T3COL_1 +" INTEGER, "+ T3COL_2+" TEXT PRIMARY KEY, "+T3COL_3+" TEXT, "+ T3COL_4 + " TEXT)";
            sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int olderVersion, int newerVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
        onCreate(sqLiteDatabase);
    }



    public boolean addDataCustomerReg(String username,String password,String fullName,String DOB,String PhoneNumber){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_2,username);
        values.put(T1COL_3,password);
        values.put(T1COL_4,fullName);
        values.put(T1COL_5,DOB);
        values.put(T1COL_8,PhoneNumber);

        long l = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addLogin(String username,String password,String type){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T3COL_2,username);
        values.put(T3COL_3,password);
        values.put(T3COL_4,type);
        long l = sqLiteDatabase.insert(TABLE3_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addDataManagerReg(String username,String password,String fullName,String restaurantName,String location,String phoneNumber){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_2,username);
        values.put(T1COL_3,password);
        values.put(T1COL_4,fullName);
        values.put(T1COL_6,restaurantName);
        values.put(T1COL_7,location);
        values.put(T1COL_8,phoneNumber);

        long l = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }


    public Cursor checkLogin(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE3_NAME;
        Cursor cursor = database.rawQuery(query,null);
        return cursor;
    }


    public boolean updatePassword(int id,String c){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T3COL_3,c);
        int u = sqLiteDatabase.update(TABLE3_NAME,contentValues,"UserName=?",
                new String[]{Integer.toString(id)});
        if(u>0)
            return true;
        else
            return false;
    }



}











