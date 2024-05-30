package com.app.intervents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VisualizzaInterventi extends AppCompatActivity {

    File fileInput = new File("/data/data/com.app.intervents/cache/interventi.csv");
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        test = (TextView) findViewById(R.id.test);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_interventi);

        try {
            Scanner scannerInput = new Scanner(fileInput);
            while(scannerInput.hasNextLine()){
                test.setText(scannerInput.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}