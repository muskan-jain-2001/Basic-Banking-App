package com.example.my_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    DBHelper DB;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = new DBHelper(MainActivity.this);
        btn1=(Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.insertData(101,"Muskan","Savings","muskanjain4185@gmail.com", String.valueOf(676002165),1000,"XXXXXXX0088","BARB907");
                DB.insertData(102,"Mahima","Savings","mahima200@gmail.com", String.valueOf(521645405),7000,"XXXXXXX8971","CANB575");
                DB.insertData(103,"Anushka","Current","aj2001@gmail.com", String.valueOf(956231645),5000,"XXXXXXX5444","PUNB7632");
                DB.insertData(104,"Arpit","Savings","arpit1998@gmail.com", String.valueOf(89693545),1600,"XXXXXXX0510","BABRB856");
                DB.insertData(105,"Apar","Demat","apar987@gmail.com", String.valueOf(985998269),8000,"XXXXXXX9710","AXIS842");
                DB.insertData(106,"Abhishek","Fixed Deposit","abhisheksharma@gmail.com", String.valueOf(974782151),1000,"XXXXXXX5452","BARB964");
                DB.insertData(107,"Roopal","Savings","roopalk52@gmail.com", String.valueOf(816279871),6000,"XXXXXXX7810","BARB907");
                DB.insertData(108,"Riya","Current","riya52420@gmail.com", String.valueOf(984052521),8000,"XXXXXXX3100","AXIS422");
                DB.insertData(109,"Anmol","Savings","anmolss10@gmail.com", String.valueOf(883416534),5000,"XXXXXXX5710","SBIN9732");
                DB.insertData(110,"Priya","Savings","pkumari0@gmail.com", String.valueOf(868442034),3000,"XXXXXXX7941","SBIN2000");
                Intent intent=new Intent(getApplicationContext(),customers.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Alltransactions.class);
                startActivity(intent);
            }
        });
    }
}