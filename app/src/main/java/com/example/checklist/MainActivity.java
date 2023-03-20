package com.example.checklist;

import static com.example.checklist.QuestionsTypes.numeric;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.checklist.utils.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private Button zone1Button, subzone11Button, subzone21Button, subzone31Button, zone2Button, subzone12Button, zone3Button, subzone13Button;
    private LinearLayout subzone1Panel, subzone2Panel, subzone3Panel;
    private List<LinearLayout> expandibleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandibleLayout = new ArrayList<>();

        textView = findViewById(R.id.textView);

        zone1Button = findViewById(R.id.zone1_button);
        zone2Button = findViewById(R.id.zone2_button);
        zone3Button = findViewById(R.id.zone3_button);

        subzone11Button = findViewById(R.id.subzone1_1_button);
        subzone12Button = findViewById(R.id.subzone1_2_button);
        subzone13Button = findViewById(R.id.subzone1_3_button);

        subzone21Button = findViewById(R.id.subzone2_1_button);
        subzone31Button = findViewById(R.id.subzone3_1_button);

        subzone1Panel = findViewById(R.id.subzone_1_panel);
        subzone2Panel = findViewById(R.id.subzone_2_panel);
        subzone3Panel = findViewById(R.id.subzone_3_panel);

        expandibleLayout.add(findViewById(R.id.subzone_1_panel));
        expandibleLayout.add(findViewById(R.id.subzone_2_panel));
        expandibleLayout.add(findViewById(R.id.subzone_3_panel));

        zone1Button.setOnClickListener(createLayoutButtonListener(0));
        zone2Button.setOnClickListener(createLayoutButtonListener(1));
        zone3Button.setOnClickListener(createLayoutButtonListener(2));



        // Set a click listener on that View
        subzone11Button.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent subzoneIntent = new Intent(MainActivity.this, SubzoneOne.class);
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

