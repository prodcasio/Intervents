package com.app.intervents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VisualizzaInterventi extends AppCompatActivity {

    File fileInput = new File("interventi.csv");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_interventi);

        try {
            Scanner scannerInput = new Scanner(fileInput);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}