package com.example.foodwaste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "WASTE_MANAGEMENT.db";
    final static int DATABASE_VERSION = 22;

    // Table for registration table
    final static String TABLE1_NAME ="Registration_table";
    final static String T1COL_1 = "UserName";
    final static String T1COL_2 = "Password";
    final static String T1COL_3 = "FullName";
    final static String T1COL_4 = "DOB";
    final static String T1COL_5 = "RestaurantName";
    final static String T1COL_6 = "Location";
    final static String T1COL_7 = "PhoneNumber";

    // Table for Profile
    final static String TABLE2_NAME = "Profile_table";
    final static String T2COL_1 = "Username";
    final static String T2COL_2 = "Hobbies";
    final static String T2COL_3 = "FavouriteFood";
    final static String T2COL_4 = "StudentOption";
    final static String T2COL_5 = "Organization";
    final static String T2COL_6 = "StudentID";


    // Table for Login table
    final static String TABLE3_NAME ="Login_table";
    final static String T3COL_1 = "UserName";
    final static String T3COL_2 = "Password";
    final static String T3COL_3 = "Type";

    // Table for Restaurant
    final static String TABLE4_NAME ="Restaurant_table";
    final static String T4COL_1 = "UserName";
    final static String T4COL_2 = "RestaurantName";
    final static String T4COL_3 = "RestaurantLocation";



    // Table for Menu
    final static String TABLE5_NAME ="Menu_table";
    final static String T5COL_1 = "Id";
    final static String T5COL_2 = "UserName";
    final static String T5COL_3 = "Item";
    final static String T5COL_4 = "Price";
    final static String T5COL_5 = "Qty";







    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query=  "CREATE TABLE " + TABLE1_NAME + "("  + T1COL_1 + " TEXT PRIMARY KEY, " + T1COL_2 + " TEXT, "+T1COL_3+" TEXT, "+T1COL_4+" DATE, "
                       +T1COL_5+" TEXT, "+T1COL_6+" TEXT, "+T1COL_7+" TEXT)";
        sqLiteDatabase.execSQL(query);
                query="CREATE TABLE " + TABLE2_NAME + "(" +  T2COL_1 + " TEXT PRIMARY KEY, " + T2COL_2 + " TEXT, "+T2COL_3+" TEXT, "+T2COL_4+" DATE, "
                        +T2COL_5+" TEXT, "+T2COL_6+" TEXT)" ;
                sqLiteDatabase.execSQL(query);

            query = "CREATE TABLE "+ TABLE3_NAME + "("+  T3COL_1+" TEXT PRIMARY KEY, "+T3COL_2+" TEXT, "+ T3COL_3 + " TEXT)";
            sqLiteDatabase.execSQL(query);



        query = "CREATE TABLE "+ TABLE4_NAME + "("+ T4COL_1 +" TEXT PRIMARY KEY, "+ T4COL_2+" TEXT, "+T4COL_3+" TEXT) ";
        sqLiteDatabase.execSQL(query);

        query = "CREATE TABLE "+ TABLE5_NAME + "("+ T5COL_1 +" INTEGER PRIMARY KEY, "+ T5COL_2+" TEXT, "+T5COL_3+" TEXT, "+T5COL_4+" INTEGER, "+T5COL_5 +" INTEGER)";
        sqLiteDatabase.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int olderVersion, int newerVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE5_NAME);
        onCreate(sqLiteDatabase);
    }



    public boolean addDataCustomerReg(String username,String password,String fullName,String DOB,String PhoneNumber){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_1,username);
        values.put(T1COL_2,password);
        values.put(T1COL_3,fullName);
        values.put(T1COL_4,DOB);
        values.put(T1COL_7,PhoneNumber);

        long l = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addLogin(String username,String password,String type){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        System.out.println(T3COL_1+":"+username);
        System.out.println(T3COL_2+":"+password);
        System.out.println(T3COL_3+":"+type);


        values.put(T3COL_1,username);
        values.put(T3COL_2,password);
        values.put(T3COL_3,type);
        long l = sqLiteDatabase.insert(TABLE3_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addDataManagerReg(String username,String password,String fullName,String restaurantName,String location,String phoneNumber){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_1,username);
        values.put(T1COL_2,password);
        values.put(T1COL_3,fullName);
        values.put(T1COL_5,restaurantName);
        values.put(T1COL_6,location);
        values.put(T1COL_7,phoneNumber);

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

    public Cursor getRegistrationInfo(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE1_NAME;
        Cursor cursor = database.rawQuery(query,null);
        return cursor;
    }


    public Cursor getRestaurantInfo(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE4_NAME;
        Cursor cursor = database.rawQuery(query,null);
        return cursor;
    }

    public Cursor getLoggedUserInfo(String[] UserName)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE1_NAME + " WHERE UserName = ?";
        Cursor cursor = database.rawQuery(query,UserName);
        return cursor;
    }
    public boolean addRestaurantInfo(String UserName,String RestaurantName,String RestaurantLocation) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        System.out.println("Username: "+UserName);
        System.out.println("Restaurant Name: "+RestaurantName);
        System.out.println("Restaurant Location"+RestaurantLocation);
        values.put(T4COL_1,UserName);
        values.put(T4COL_2,RestaurantName);
        values.put(T4COL_3,RestaurantLocation);
        long l = sqLiteDatabase.insert(TABLE4_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public boolean addRestaurantMenuInfo(String UserName,String Item,String Price, String Qty) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T5COL_2,UserName);
        values.put(T5COL_3,Item);
        values.put(T5COL_4,Price);
        values.put(T5COL_5,Qty);
        long l = sqLiteDatabase.insert(TABLE5_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }


    public boolean updatePassword(String id,String c){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T3COL_2,c);
        int u = sqLiteDatabase.update(TABLE3_NAME,contentValues,"UserName=?",
                new String[]{id});
        if(u>0)
            return true;
        else
        {
          System.out.println("No update happened");
            return false;

        }
                }



}











