package com.example.listviewwithdatabase.dataBase;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewwithdatabase.MainActivity;
import com.example.listviewwithdatabase.R;
import com.example.listviewwithdatabase.dataBase.DbHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tutlane on 05-01-2018.
 */

public class DatliesActivity extends AppCompatActivity
{
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datailes);
        DbHandler db = new DbHandler(this);
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv = (ListView) findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(DatliesActivity.this, userList, R.layout.listrow,new String[]{"name","designation","location"}, new int[]{R.id.name, R.id.designation, R.id.location});
        lv.setAdapter(adapter);
        Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DatliesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}