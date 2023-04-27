package com.example.android.retrofit;

import com.example.android.entities.BookindData;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BookingPageApi {

    @POST("confirm-booking")
    public Call<JsonObject> postBooking(@Body BookindData bookindData);
}
