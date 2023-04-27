package com.example.android.retrofit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PgDetailPageApi {

    @GET("pgDetail/{id}")
    public Call<JsonObject> getPgDetails(@Path("id") int pgId);
}
