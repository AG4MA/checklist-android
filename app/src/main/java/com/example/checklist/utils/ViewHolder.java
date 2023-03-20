package com.example.checklist.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checklist.R;

import org.w3c.dom.Text;


//3. Recycle view --> 2.List Adapter --> 1.ViewHolder
public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView domanda;
    private EditText risposta;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        domanda = itemView.findViewById(R.id.domanda);
        risposta = itemView.findViewById(R.id.risposta);
    }

    public void updateContent(String domanda) {
        this.domanda.setText(domanda);
    }
}
