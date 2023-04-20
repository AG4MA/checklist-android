package com.example.checklist.controllers;

import android.content.Context;
import android.widget.Toast;

import com.example.checklist.apis.QuestionApi;
import com.example.checklist.model.entities.Questions;
import com.example.checklist.utils.ListAdapter;
import com.example.checklist.utils.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsController {

    public void addQuestions(Questions questions, Context context) {
        QuestionApi questionAPi = RetrofitHelper.getRetrofitInstance().create(QuestionApi.class);
        Call<Void> addQuestionCall = questionAPi.addQuestion(questions);
        addQuestionCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                //Succesfull response
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "QuestionAdd Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getQuestions(List<Questions> questionsList, ListAdapter listAdapter, Context context) {
        QuestionApi questionApi = RetrofitHelper.getRetrofitInstance().create(QuestionApi.class);
        Call<List<Questions>> getQuestionCall = questionApi.getQuestions();
        getQuestionCall.enqueue(new Callback<List<Questions>>() {
            @Override
            public void onResponse(Call<List<Questions>> call, Response<List<Questions>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        questionsList.addAll(response.body());
                        listAdapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onFailure(Call<List<Questions>> call, Throwable t) {
                Toast.makeText(context, "QuestionAdd Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}