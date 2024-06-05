package com.app.intervents;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class VisualizzaInterventi extends AppCompatActivity {

    DatePicker dataChosen;
    LinearLayout container;
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_interventi);
        container = (LinearLayout) findViewById(R.id.container);
        dataChosen =  (DatePicker)findViewById(R.id.dataIntervento);
        LocalDate today = LocalDate.now();

        DatePicker.OnDateChangedListener odcl = new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int u, int i1, int i2) {
                File cartella = getFilesDir();
                container.removeAllViews();
                try {
                    File file = new File(cartella.getAbsolutePath() + "/interventi.csv");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = br.readLine()) != null){
                        TextView tv = new TextView(context);
                        tv.setBackgroundResource(R.drawable.border);
                        tv.setGravity(Gravity.CENTER);
                        String stringaFinale = "";
                        String[] date = line.split(",")[0].split("/");
                        String dataString = date[0] + "/" + (Integer.parseInt(date[1])+1) + "/" + date[2];
                        Log.d("Ciao", dataString);
                        String dataChosenString = dataChosen.getDayOfMonth() + "/" + (dataChosen.getMonth()+1) + "/" + dataChosen.getYear();
                        Log.d("Ciao", dataChosenString);
                        if(checkDate(dataString, dataChosenString)) {
                            Log.d("Ciao", line);
                            String[] arrayStringa = line.split(",");
                            stringaFinale += "Data: " + arrayStringa[0] + "\t\t";
                            stringaFinale += "Azienda: " + arrayStringa[1] + "\n";
                            stringaFinale += "Ora inizio: " + arrayStringa[2] + "\t\t";
                            stringaFinale += "Ora fine: " + arrayStringa[3] + "\n";
                            stringaFinale += "Tipo: " + arrayStringa[4] + "\n";
                            stringaFinale += "Attività: ";

                            String[] arrayAttivita = arrayStringa[5].split("-");
                            for (int i=1; i<arrayAttivita.length; i++) {
                                stringaFinale += "\n - " + arrayAttivita[i];
                            }
                            tv.setText(stringaFinale);
                            container.addView(tv);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        dataChosen.init(today.getYear(), today.getMonthValue()-1, today.getDayOfMonth(), odcl);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkDate(String date, String dateChosen){
        if(date.equals(dateChosen)){
            return true;
        }
        return false;
    }
}
/* Fatto da Antonacci */