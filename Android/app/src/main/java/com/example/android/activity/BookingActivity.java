package com.example.android.activity;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.entities.BookindData;
import com.example.android.retrofit.BookingPageApi;
import com.example.android.utils.Constants;
import com.google.gson.JsonObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookingActivity extends AppCompatActivity {
CalendarView datePicker;
ImageView PhotoId;
TextView selectRoom,textPhoto,selectDate;
RadioButton singleBed,doubleBed,tripleBed,fourBed;
private final int PHOTO_REQ_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        datePicker=findViewById(R.id.datePicker);
        PhotoId=findViewById(R.id.PhotoId);
        selectRoom=findViewById(R.id.selectRoom);
        selectDate=findViewById(R.id.selectDate);
        textPhoto=findViewById(R.id.textPhoto);
        singleBed=findViewById(R.id.singleBed);
        doubleBed=findViewById(R.id.doubleBed);
        tripleBed=findViewById(R.id.tripleBed);
        fourBed=findViewById(R.id.fourBed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    public void submit(View view){
    startActivity(new Intent(this,EndSplashActivity.class));
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        finish();
        return super.onOptionsItemSelected(item);
    }




    public void uploadId(View view ){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,PHOTO_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==PHOTO_REQ_CODE){
                PhotoId.setImageURI(data.getData());

                Uri imageUri = data.getData();
//                Bitmap bitmap = null;
//                try {
//                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//                byte[] imageBytes = outputStream.toByteArray();
//                FormDataBodyPart imagePart = new FormDataBodyPart("image", new ByteArrayInputStream(imageBytes), MediaType.APPLICATION_OCTET_STREAM_TYPE);
//                formDataMultiPart.bodyPart(imagePart);


            }
        }
    }

    public void bookpg(View view){

        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(BookingPageApi.class)
                .postBooking(new BookindData())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
    }

}