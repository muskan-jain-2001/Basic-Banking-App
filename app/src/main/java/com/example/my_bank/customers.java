package com.example.my_bank;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class customers extends AppCompatActivity {
    DBHelper DB;
    ListView l;
    AlertDialog.Builder alertDialogBuilder;
    public static String selectedItem;
    public static String status;
    public static String text1,text2,text3,text4,text5,text6,text7,text8;

    String users[]
            = { "Muskan", "Mahima",
            "Anushka", "Arpit",
            "Apar", "Abhishek",
            "Roopal", "Riya",
            "Anmol","Priya"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);
        DB = new DBHelper(customers.this);
        l = findViewById(R.id.list);
        alertDialogBuilder=new AlertDialog.Builder(this);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,users);
        l.setAdapter(arr);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);
                Cursor cursor=DB.retrieveData(selectedItem);
                if(cursor.moveToLast()) {
                    text1 = cursor.getString(0);
                    text2 = cursor.getString(1);
                    text3 = cursor.getString(2);
                    text4 = cursor.getString(3);
                    text5 = cursor.getString(4);
                    text6 = cursor.getString(5);
                    text7 = cursor.getString(6);
                    text8 = cursor.getString(7);

                }
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(customers.this);
                alertDialogBuilder.setTitle("Details");
                alertDialogBuilder.setMessage("CustomerID: "+text1+"\nName: "+text2+"\nAcc_Tye: "+text3+"\nEmail: "+text4+"\nPhNo: "+text5+"\nBalance: "+text6+"\nAccNo: "+text7+"\nIFSC: "+text8);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialogBuilder.setNegativeButton("Transfer Money", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getApplicationContext(),transfermoney.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();

            }

        });


    }
}
