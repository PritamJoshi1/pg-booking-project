package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.R;
import com.example.android.entities.Credentials;
import com.example.android.retrofit.CustomerApi;
import com.example.android.utils.Constants;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail, editPassword;
    CheckBox checkBox;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);
        checkBox=findViewById(R.id.checkBox);
        textView=findViewById(R.id.textView);


        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(150); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textView.startAnimation(anim);
    }
    public void signup(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

//    public void signin(View view){
//        startActivity(new Intent(this,HomeActivity.class));
//    }

    public void signin(View view){
        Credentials credentials = validateData();
        if(credentials != null)
            signinCustomer(credentials);
    }

    public void signinCustomer(Credentials credentials)
    {
        Log.e("customer","abc"+credentials);
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(CustomerApi.class)
                .customerLogin(credentials)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.e("hii","hello"+response);
                        //JsonArray jsonArray = response.body().getAsJsonArray("data");
                        JsonObject jsonObject = response.body().getAsJsonObject("data");
                        Log.e("hii","hello"+jsonObject);
                        if(jsonObject!=null)
                        {
                            //jsonObject = jsonArray.get(0).getAsJsonObject();
                            int id = jsonObject.get("c_id").getAsInt();
                            saveData(id);
                            Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void saveData(int id) {
        SharedPreferences preferences = getSharedPreferences("pg", MODE_PRIVATE);
        preferences.edit().putInt("c_id", id).commit();
        if (checkBox.isChecked())
            preferences.edit().putBoolean("login_status", true).commit();
        Log.e("spdata","spdata================"+id);

}

    public Credentials validateData()
    {
        Credentials credentials = new Credentials();
        credentials.setEmail(editEmail.getText().toString());
        credentials.setPassword(editPassword.getText().toString());
        if(!credentials.getEmail().equals(""))
            if(!credentials.getPassword().equals(""))
                return credentials;
            else
                Toast.makeText(this, "Password cant be empty", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Email cant be empty", Toast.LENGTH_SHORT).show();
        return null;
    }

}