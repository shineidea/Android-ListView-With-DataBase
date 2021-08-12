package com.example.listviewwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listviewwithdatabase.dataBase.DatliesActivity;
import com.example.listviewwithdatabase.dataBase.DbHandler;

public class MainActivity extends AppCompatActivity {

    EditText name , location , dec;
    Button button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txtName);
        location =findViewById(R.id.txtLocation);
        dec = findViewById(R.id.txtDesignation);
        button =findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString()+"/n";
                String loc = location.getText().toString();
                String deec = dec.getText().toString();

                DbHandler dbHandler = new DbHandler(MainActivity.this);
                dbHandler.insertUserDetails(username ,loc ,deec);

                intent = new Intent( MainActivity.this , DatliesActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }
}