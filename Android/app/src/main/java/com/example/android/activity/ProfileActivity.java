package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;
import com.example.android.retrofit.CustomerApi;
import com.example.android.utils.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    TextView textName,textEmail,textAddress,textMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textAddress = findViewById(R.id.textAddress);
        textMobile = findViewById(R.id.textMobile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getUserData();
    }

    private void getUserData() {
        int id = getSharedPreferences("pg", Context.MODE_PRIVATE)
                .getInt("c_id",0);

        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(CustomerApi.class)
                .getCustomer(id)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonObject object = response.body().getAsJsonObject("data");
                        if(object!=null){
                            textName.setText("Name: "+object.get("c_name").getAsString());
                            textEmail.setText("Email: "+object.get("email").getAsString());
                            textAddress.setText("Address: "+object.get("c_address").getAsString());
                            textMobile.setText("Mobile: "+object.get("c_mobile").getAsString());
                        }
                    }
                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
         });
}


}