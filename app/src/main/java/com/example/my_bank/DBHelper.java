package com.example.my_bank;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "mybank3.db";
    public String uname;
    public DBHelper(Context context) {
        super(context, "mybank3.db", null, 1);

    }
    SQLiteDatabase db;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL="CREATE TABLE users(customerid INTEGER PRIMARY KEY,username TEXT,acc_type TEXT,email TEXT,contactno TEXT,curr_bal INTEGER,acc_no TEXT,ifsc TEXT)";
        String SQL2="CREATE TABLE transfer(tid INTEGER PRIMARY KEY,fromusername TEXT ,tousername TEXT,Amount TEXT,status TEXT)";
        Log.d("Data", "onCreate: " + SQL);
        Log.d("Data", "onCreate: " + SQL2);
        db.execSQL(SQL);
        db.execSQL(SQL2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists users");
    }

    public Boolean insertData(Integer customerid,String username,String acc_type, String email,String contactno,Integer curr_bal,String acc_no,String ifsc) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerid",customerid);
        contentValues.put("username",username);
        contentValues.put("acc_type", acc_type);
        contentValues.put("email", email);
        contentValues.put("contactno", contactno);
        contentValues.put("curr_bal",curr_bal);
        contentValues.put("acc_no",acc_no);
        contentValues.put("ifsc",ifsc);
        long result = db.insert("users", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Boolean insertData2(Integer tid,String fromusername, String tousername, Integer amount, String status) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tid", tid);
        contentValues.put("fromusername", fromusername);
        contentValues.put("tousername", tousername);
        contentValues.put("amount", amount);
        contentValues.put("status", status);
        long result = db.insert("transfer", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor retrieveData(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=?",new String[] {username});
        return cursor;

    }
    public Cursor retrieveData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM transfer",null);
        return cursor;


    }
}
