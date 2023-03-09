package com.example.foodwaste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "WASTE_MANAGEMENT.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE1_NAME ="Login_table";
    final static String T1COL_1 = "Id";
    final static String T1COL_2 = "LoginName";
    final static String T1COL_3 = "Password";

    // Table for customer registration table
    final static String TABLE2_NAME ="Customer_Registration_table";
    final static String T2COL_1 = "Id";
    final static String T2COL_2 = "UserName";
    final static String T2COL_3 = "Password";
    final static String T2COL_4 = "FullName";
    final static String T2COL_5 = "DOB";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryLogin = "CREATE TABLE " + TABLE1_NAME + "(" + T1COL_1 +
                " INTEGER PRIMARY KEY, " + T1COL_2 + " TEXT, " + T1COL_3 + " TEXT)" ;
        sqLiteDatabase.execSQL(queryLogin);
        String queryCustRegis=  "CREATE TABLE " + TABLE2_NAME + "(" + T2COL_1 +
                " INTEGER PRIMARY KEY, " + T2COL_2 + " TEXT, " + T2COL_3 + " TEXT, "+T2COL_4+" TEXT, "+T2COL_5+" DATE)" ;
        sqLiteDatabase.execSQL(queryCustRegis);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int olderVersion, int newerVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String loginName,String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_2,loginName);
        values.put(T1COL_3,password);


        long l = sqLiteDatabase.insert(TABLE1_NAME,null,values);
        if(l > 0)
            return true;
        else
            return false;
    }

    public Cursor viewData(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE1_NAME;
        Cursor cursor = database.rawQuery(query,null);
        //String query = "SELECT * FROM " + TABLE1_NAME + " WHERE Id = ?";
        //Cursor cursor = database.rawQuery(query,new String[]{"2"});
        return cursor;
    }

    public boolean deleteRec(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int d = sqLiteDatabase.delete(TABLE1_NAME,"Id=?",
                new String[]{Integer.toString(id)});
        if(d>0)
            return true;
        else
            return false;
    }

//    public boolean updateRec(int id,String c){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(T1COL_4,c);
//        int u = sqLiteDatabase.update(TABLE1_NAME,contentValues,"id=?",
//                new String[]{Integer.toString(id)});
//        if(u>0)
//            return true;
//        else
//            return false;
//    }
}











