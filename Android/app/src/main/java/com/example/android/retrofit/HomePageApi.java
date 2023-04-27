package com.example.android.retrofit;

import com.example.android.entities.ImageResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomePageApi {

//    @GET("pg")
//    public Call<List<Pg>> getPg();

//    @GET("pg")
//    public  Call<JsonObject> getPg();

//    @GET("photoID/{id}")
//    public Call<ImageResponse> getImage(@Path("id") int id);

    @GET("pgDto")
    public  Call<JsonObject> getPg();

    @GET("{locality}")
    public Call<JsonObject> getLocality(@Path("locality") String locality);


}
