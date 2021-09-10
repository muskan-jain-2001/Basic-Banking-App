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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class transfermoney extends customers {

TextView t;
EditText amount;
Button btn;
public static int i=0;
    public static int j=0;

    public String tousername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfermoney);
        t=(TextView)findViewById(R.id.textView3);
        final int min = 500;
        final int max = 1000;
        final int random = new Random().nextInt((max - min) + 1) + min;
        btn=(Button) findViewById(R.id.button1);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.users_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tousername = spinner.getSelectedItem().toString();;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        amount=(EditText)findViewById(R.id.simpleEditText);
        t.setText("Name: "+text2+"\nBalance: "+text6+"\nAccount-No: "+text7+"\nIFSC: "+text8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= amount.getText().toString();
                  i=Integer.parseInt(s);
                 j=Integer.parseInt(text5);
                if(i>j)
                {
                    Toast.makeText(transfermoney.this,"Insufficient Balance!!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(transfermoney.this);
                    alertDialogBuilder.setTitle("Confirm!");
                    alertDialogBuilder.setMessage("Are You Sure You want Continue with Transaction?");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int x) {
                            Toast.makeText(transfermoney.this,"Transaction sucessful!",Toast.LENGTH_SHORT).show();
                            status="success";
                            DB.insertData2(random,selectedItem,tousername,i,status);
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int x) {
                            Toast.makeText(transfermoney.this,"Transaction failed!",Toast.LENGTH_SHORT).show();
                            status="failed";
                            DB.insertData2(random,selectedItem,tousername,i,status);
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog=alertDialogBuilder.create();
                    alertDialog.show();

                }
            }
        });

    }
}