package com.example.checklist.controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.checklist.apis.QuestionApi;
import com.example.checklist.apis.ReportCodeApi;
import com.example.checklist.model.entities.Questions;
import com.example.checklist.model.entities.ReportCode;
import com.example.checklist.utils.ListAdapter;
import com.example.checklist.utils.RetrofitHelper;

import java.sql.SQLOutput;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportCodeController {

    public void sendReportCode(ReportCode reportCode, Context context) {
        ReportCodeApi reportCodeApi = RetrofitHelper.getRetrofitInstance().create(ReportCodeApi.class);
        Call<Void> sendReportCodeCall = reportCodeApi.sendReportCode(reportCode);
        sendReportCodeCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                System.out.println("Success");

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();

                Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
                System.out.println("Failure");
            }
        });
    }
}
