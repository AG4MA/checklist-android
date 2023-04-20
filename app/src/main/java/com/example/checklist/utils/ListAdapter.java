package com.example.checklist.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checklist.model.entities.Questions;
import com.example.checklist.R;

import java.util.List;

//3. Recycle view --> 2.List Adapter --> 1.ViewHolder
public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private LayoutInflater inflater;
    private List<Questions> questions;
    private Context context;

    public ListAdapter(List<Questions> questions, Context context) {
        this.questions = questions;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    //renderizza la viewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_list_items, parent, false);
        //elemento da mostrare nella lista
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Questions question = questions.get(position);
        holder.updateContent(question.getDomanda());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
