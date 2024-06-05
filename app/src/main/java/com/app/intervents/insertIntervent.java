package com.app.intervents;

import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class insertIntervent extends AppCompatActivity {
    File cartella;
    DatePicker data = null;
    EditText nomeAzienda = null;
    TimePicker oraInizio = null;
    TimePicker oraFine = null;
    RadioGroup tipoIntervento = null;
    ArrayList<CheckBox> attivita;
    EditText other = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_intervent);
        cartella = getFilesDir();
        data = (DatePicker) findViewById(R.id.data);
        nomeAzienda = (EditText) findViewById(R.id.nomeAzienda);
        oraInizio = (TimePicker) findViewById(R.id.oraInizio);
        oraFine = (TimePicker) findViewById(R.id.oraFine);
        tipoIntervento = (RadioGroup) findViewById(R.id.tipointervento);
        attivita = new ArrayList<>();
        attivita.add((CheckBox)findViewById(R.id.chk1));
        attivita.add((CheckBox)findViewById(R.id.chk2));
        attivita.add((CheckBox)findViewById(R.id.chk3));
        attivita.add((CheckBox)findViewById(R.id.chk4));
        attivita.add((CheckBox)findViewById(R.id.chk5));
        attivita.add((CheckBox)findViewById(R.id.chk6));
        other = (EditText) findViewById(R.id.altrospecificato);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void inserisciIntervento(View v){
        try {
            FileWriter file = new FileWriter(cartella.getAbsolutePath()+"/interventi.csv", true);
            String strData = data.getDayOfMonth()+"/"+data.getMonth()+"/"+data.getYear();
            String strAzienda = nomeAzienda.getText().toString();
            String strOraInizio = oraInizio.getHour() + ":" + oraInizio.getMinute();
            String strOraFine = oraFine.getHour() + ":" + oraFine.getMinute();
            RadioButton r = (RadioButton) findViewById(tipoIntervento.getCheckedRadioButtonId());
            String strRadio = String.valueOf(r.getText());
            String strAttivita = "";
            for(CheckBox x : attivita){
                if(x.isChecked()){
                    strAttivita+= "-" + x.getText();
                }
            }
            String strOther = other.getText().toString();
            file.write(strData + "," + strAzienda + "," + strOraInizio + "," + strOraFine + "," + strRadio + "," + strAttivita + "," + strOther + "\n");
            file.close();
            Toast.makeText(this,"Intervento inserito", Toast.LENGTH_SHORT).show();
            Log.d("tag", strData + "," + strAzienda + "," + strOraInizio + "," + strOraFine + "," + strRadio + "," + strAttivita + "," + strOther);

        } catch (IOException e) {
            Toast.makeText(this,"Errore", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
/* Fatto da Rodella */