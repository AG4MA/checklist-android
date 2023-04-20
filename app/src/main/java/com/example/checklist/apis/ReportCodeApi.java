package com.example.checklist.apis;

import com.example.checklist.model.entities.ReportCode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReportCodeApi {

    @POST("api/v1/report-code")
    Call<Void> sendReportCode(@Body ReportCode reportCode);
}