package com.example.my_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Alltransactions extends customers {
    DBHelper DB;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alltransactions);
        DB = new DBHelper(Alltransactions.this);
        text = (TextView) findViewById(R.id.textbox);
        Cursor cursor = DB.retrieveData2();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
        } else {
            cursor.moveToLast();
            text1 = cursor.getString(0);
            text2 = cursor.getString(1);
            text3 = cursor.getString(2);
            text4= cursor.getString(3);
            text5 = cursor.getString(4);
            text.append("\n"+"PaymentId: "+text1 +"\n"+text2+ "--->" + text3 + "\nAmount: " + text4 + "\nStatus: " + text5+"\n");

            while (cursor.moveToPrevious()) {
                text1 = cursor.getString(0);
                text2 = cursor.getString(1);
                text3 = cursor.getString(2);
                text4 = cursor.getString(3);
                text5 = cursor.getString(4);
                text.append("\n"+"PaymentId: "+text1 +"\n"+text2+ "--->" + text3 + "\nAmount: " + text4 + "\nStatus: " + text5+"\n");
            }
        }

    }
}