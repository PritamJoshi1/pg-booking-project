package com.example.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.R;
import com.example.android.entities.Customers;
import com.example.android.retrofit.CustomerApi;
import com.example.android.utils.Constants;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    EditText editName, editEmail, editPhone, editPassword;
    EditText editOccupation;
    EditText editConfirmPassword;
    RadioButton radioMale, radioFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editPassword = findViewById(R.id.editPassword);
        editOccupation = findViewById(R.id.editOccupation);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
    }

    public void register(View view){
        Customers customers = validateData();
        if(customers != null)
            registerCustomer(customers);
    }

    public void registerCustomer(Customers customers)
    {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(CustomerApi.class)
                .registerCustomer(customers)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public Customers validateData()
    {
        Customers customers = new Customers();
        customers.setC_name(editName.getText().toString());
        customers.setEmail(editEmail.getText().toString());
        customers.setC_password(editPassword.getText().toString());
        customers.setC_mobile(editPhone.getText().toString());
        customers.setC_occupation(editOccupation.getText().toString());
        String ConfirmPassword = editConfirmPassword.getText().toString();
        if(radioMale.isChecked()){
            customers.setC_gender(radioMale.getText().toString());
        }else if(radioFemale.isChecked()){
            customers.setC_gender(radioFemale.getText().toString());
        }
        if(!customers.getC_name().equals("")){
            if(!customers.getEmail().equals("")){
                if(!customers.getC_mobile().equals("")){
                    if(!customers.getC_password().equals("")){
                        if(!customers.getC_occupation().equals("")){
                            if(customers.getC_password().equals(ConfirmPassword)){
                                return customers;
                            }else
                                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(this, "Please Enter Occupation", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(this, "Password Cannot be empty", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this, "Mobile Number Cannot be empty", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Email Cannot be empty", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this, "Name Cannot be empty", Toast.LENGTH_SHORT).show();
        return null;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}