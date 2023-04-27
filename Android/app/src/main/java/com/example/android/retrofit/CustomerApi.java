package com.example.android.retrofit;

import com.example.android.entities.Credentials;
import com.example.android.entities.Customers;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CustomerApi {
    @POST("customerlogin")
    public  Call<JsonObject> customerLogin(@Body Credentials credentials);

    @POST("customerRegister")
    public Call<JsonObject> registerCustomer(@Body Customers customers );

    @GET("customer/{id}")
    public Call<JsonObject> getCustomer(@Path("id")int c_id);
}
