package com.example.checklist;

import static com.example.checklist.QuestionsTypes.numeric;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.checklist.utils.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SubzoneOne extends AppCompatActivity {
    private RecyclerView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subzone_one);
        //quale il senso?
        recycleView = findViewById(R.id.recycle_subzone_one);

        //temporanea
        List<Questions> questions = new ArrayList<>();
        questions.add(new Questions("domanda uno", 1212, numeric));
        questions.add(new Questions("domanda due", 532, numeric));
        questions.add(new Questions("domanda tre", 1252612, numeric));
        ListAdapter listAdapter = new ListAdapter(questions, this);
        //perchè si usa?
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        //qualè il senso?
        recycleView.setAdapter(listAdapter);

        //3. Recycle view --> 2.List Adapter --> 1.ViewHolder


    }
}