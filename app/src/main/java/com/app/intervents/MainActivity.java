package com.app.intervents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File cartella = getFilesDir();
        try {
            FileWriter fw = new FileWriter(cartella.getAbsoluteFile()+"/interventi.csv");
            fw.write("");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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