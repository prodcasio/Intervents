package com.app.intervents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
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
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tv = (TextView) findViewById(R.id.container);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_interventi);

        File cartella = getFilesDir();
        try {
            /*
            FileReader fr = new FileReader(cartella.getAbsolutePath() + "/interventi.csv");
            BufferedReader br = new BufferedReader(fr);
            */
            File file = new File(cartella.getAbsolutePath() + "/interventi.csv");
            Scanner scanner = new Scanner(file);
            String stringa = "";
            while(scanner.hasNext()){
                stringa += scanner.nextLine().replace(",", " ");
                stringa += "\n\n";
            }
            tv.setText(stringa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}