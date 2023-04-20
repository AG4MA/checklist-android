package com.example.checklist.apis;

import com.example.checklist.model.entities.Questions;
import com.example.checklist.model.entities.ReportCode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface QuestionApi {

    @POST("addQuestions")
    Call<Void> addQuestion(@Body Questions questions);

    @GET("question")
    Call<List<Questions>> getQuestions();



}
