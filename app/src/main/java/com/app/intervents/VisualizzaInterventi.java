package com.app.intervents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VisualizzaInterventi extends AppCompatActivity {

    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        test = (TextView) findViewById(R.id.test);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_interventi);

        File cartella = getFilesDir();
        try {
            FileReader fr = new FileReader(cartella.getAbsolutePath() + "/interventi.csv");
            BufferedReader br = new BufferedReader(fr);
            Log.d("Miotag", br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}