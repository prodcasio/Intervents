package com.app.intervents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

public class insertIntervent extends AppCompatActivity {
    File file;
    DatePicker data = null;
    EditText nomeAzienda = null;
    TimePicker oraInizio = null;
    TimePicker oraFine = null;
    RadioButton tipoIntervento = null;
    CheckBox attivita = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_intervent);
        File file =
        data = (DatePicker) findViewById(R.id.data);
        nomeAzienda = (EditText) findViewById(R.id.nomeAzienda);
        oraInizio = (TimePicker) findViewById(R.id.oraInizio);
        oraFine = (TimePicker) findViewById(R.id.oraFine);
        tipoIntervento = (RadioButton) findViewById(R.id.tipoIntervento);
        attivita = (CheckBox) findViewById(R.id.attivita);
    }
    public void inserisciAttivita(){

    }
}