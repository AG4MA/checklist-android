package com.example.checklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private Button buttonZoneA, buttonZoneASubzoneOne, buttonZoneASubzoneTwo, buttonZoneASubzoneThree, buttonZoneB, buttonZoneBSubzoneOne, buttonZoneC, buttonZoneCSubzoneOne;
    private LinearLayout subzoneOnePanel, subzoneTwoPanel, subzoneThreePanel;
    private List<LinearLayout> expandibleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandibleLayout = new ArrayList<>();

        textView = findViewById(R.id.textView);

        buttonZoneA = findViewById(R.id.zone_a_button);
        buttonZoneB = findViewById(R.id.zone_b_button);
        buttonZoneC = findViewById(R.id.zone_c_button);

        buttonZoneASubzoneOne = findViewById(R.id.button_zone_a_subzone_one);
        buttonZoneASubzoneTwo = findViewById(R.id.button_zone_a_subzone_two);
        buttonZoneASubzoneThree = findViewById(R.id.button_zone_a_subzone_three);

        buttonZoneBSubzoneOne = findViewById(R.id.button_zone_b_subzone_one);
        buttonZoneCSubzoneOne = findViewById(R.id.button_zone_c_subzone_one);

        subzoneOnePanel = findViewById(R.id.subzone_a_panel);
        subzoneTwoPanel = findViewById(R.id.subzone_b_panel);
        subzoneThreePanel = findViewById(R.id.subzone_c_panel);

        expandibleLayout.add(findViewById(R.id.subzone_a_panel));
        expandibleLayout.add(findViewById(R.id.subzone_b_panel));
        expandibleLayout.add(findViewById(R.id.subzone_c_panel));

        buttonZoneA.setOnClickListener(createLayoutButtonListener(0));
        buttonZoneB.setOnClickListener(createLayoutButtonListener(1));
        buttonZoneC.setOnClickListener(createLayoutButtonListener(2));



        // Set a click listener on that View
        buttonZoneASubzoneOne.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent subzoneIntent = new Intent(MainActivity.this, SubzoneOneZoneA.class);
                startActivity(subzoneIntent);
            }
        });

        buttonZoneBSubzoneOne.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent subzoneIntent = new Intent(MainActivity.this, SubzoneOneZoneB.class);
                startActivity(subzoneIntent);
            }
        });

        buttonZoneCSubzoneOne.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent subzoneIntent = new Intent(MainActivity.this, SubzoneOneZoneC.class);
                startActivity(subzoneIntent);
            }
        });

    }


    private void activateLayout(int index){
        for(LinearLayout linearLayout: expandibleLayout){
            linearLayout.setVisibility(View.GONE);
        }
        expandibleLayout.get(index).setVisibility(View.VISIBLE);
    }

    private View.OnClickListener createLayoutButtonListener(int indexRef){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateLayout(indexRef);
            }
        };
    }






}


/*
apro l'app > cicco su una subzone > dati che rimangono salvati nell'app anche se
la chiudo savahandler, preferences, exc..., > compilo il form ( form con selezione
radiobutton non solo edittext) > salva > invia

invia report-code, ovvero oggetto chiave-valore:

chiave subzone1-id1: "stringa di risposte in formato numerico"

i report devono avere un numero limitato giornaliero, se uno prova a reinviare nello stesso giorno > opzione modifica > reinvia

check invio per evitare copie di dati:
ZONE A
report inviabile 1 volta al giorno, se richiesta invio, richiesta di modifica report precedentemente compilato, invio modifiche,
quindi, classe per inviare da db e non in modo diretto
ZONE B
cod = cod && dati != dati
oppure
cod != cod && dati!=dati
ZONE C = ZONE A (ma inviabile solo settimanalmente)

invia (volley) > back-end


 */