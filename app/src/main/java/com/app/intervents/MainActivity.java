package com.app.intervents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertIntervent(View v){
        Intent intent = new Intent(this, insertIntervent.class);
        startActivity(intent);
    }

    public void viewIntervents(View v){
        Intent intent = new Intent(this, VisualizzaInterventi.class);
        startActivity(intent);
    }
}