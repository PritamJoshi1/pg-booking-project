package com.example.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.android.R;
import com.example.android.adapter.AmenityAdapter;
import com.example.android.adapter.PgPhotosAdapter;
import com.example.android.entities.Amenities;
import com.example.android.entities.Pg;
import com.example.android.retrofit.PgDetailPageApi;
import com.example.android.utils.Constants;
import com.google.gson.JsonObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class pgDetailsActivity2 extends AppCompatActivity {
    TextView pgName,pgDescription,pgAddress;

    ViewPager viewPager;
    RecyclerView recyclerView;

    ArrayList<Amenities> amenities;
    AmenityAdapter amenityAdapter;

    List<Pg> pg;
    int pgId;
    int pgId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgdetails);

        pgName = findViewById(R.id.pgName);
        pgDescription = findViewById(R.id.pgDescription);
        pgAddress = findViewById(R.id.pgAddress);

        viewPager = findViewById(R.id.viewPager);
        recyclerView = findViewById(R.id.recyclerView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Intent intent = getIntent();
//
//        Pg pg = (Pg) intent.getSerializableExtra("key");
//        //String s = intent.getStringExtra("key");
//
//
//        //locality -> list of pg -> pg detail
//        intent.getSerializableExtra("key2");
//        pgId = getIntent().getIntExtra("pgId",0);
//        Log.e("pgid","pgid====="+pg);
        pgId2 = getIntent().getIntExtra("key2",0);

        getPgDetailsData();
        //getPgListDetailsData();



        //String s = intent.getStringExtra("key");
//        Intent intent1 = getIntent();
//        intent1.getIntExtra("key2",0);


        Integer [] amLogo = {R.drawable.wifi,R.drawable.tv,R.drawable.ac,
                R.drawable.water_heater,R.drawable.cupboard,
                R.drawable.lift,R.drawable.security,R.drawable.house_keeping,
                R.drawable.drinking_water,R.drawable.cctv,R.drawable.food,R.drawable.refridgerator,
                R.drawable.parking,R.drawable.washing_machine};

        String [] amName = {"WiFi","Television","AC","Hot Water","CupBoard","Lift",
                "Security","House Keeping","Drinking Water","CCTV","Food",
                "Refrigerator","Parking","Washing Machine"};

        amenities = new ArrayList<>();
        for(int i=0;i<amLogo.length;i++)
        {
            Amenities amn = new Amenities(amLogo[i],amName[i]);
            amenities.add(amn);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(pgDetailsActivity2.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        amenityAdapter = new AmenityAdapter(amenities, pgDetailsActivity2.this);
        recyclerView.setAdapter(amenityAdapter);

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.pgone);
        imageList.add(R.drawable.pgfour);
        imageList.add(R.drawable.pgtwo);
        imageList.add(R.drawable.pgfive);



        PgPhotosAdapter myAdapter = new PgPhotosAdapter(imageList);


        viewPager.setAdapter(myAdapter);

    }

    public void getPgDetailsData(){
        pg = new ArrayList<>();
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(PgDetailPageApi.class)
                .getPgDetails(pgId2)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        //JsonArray array = response.body().getAsJsonArray("data");
                        //Log.e("errData","errData---------------------"+array);
                        JsonObject object = response.body().getAsJsonObject("data");
                        //if(array.size() > 0){
                        //for(int i=0;i<array.size();i++){
                        //object = array.get(i).getAsJsonObject();
                        Log.e("errdata","qwer------------"+object);
                        Pg pgs = new Pg();
//                        pgs.setPg_id(object.get("pg_id").getAsInt());
                        pgs.setName(object.get("name").getAsString());
                        pgs.setPg_description(object.get("pg_description").getAsString());
                        pgs.setAddress(object.get("address").getAsString());

                        pg.add(pgs);

                        pgName.setText(object.get("name").getAsString());
                        pgDescription.setText(object.get("pg_description").getAsString());
                        pgAddress.setText(object.get("address").getAsString());

                        //}
                    }
                    //api is written and have to look for how the perticular data could be set on respected place



                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });


    }

//    public void getPgListDetailsData(){
//        pg = new ArrayList<>();
//        new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(Constants.BASE_URL)
//                .build()
//                .create(PgDetailPageApi.class)
//                .getPgDetails(pgId2)
//                .enqueue(new Callback<JsonObject>() {
//                    @Override
//                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                        //JsonArray array = response.body().getAsJsonArray("data");
//                        //Log.e("errData","errData---------------------"+array);
//                        JsonObject object = response.body().getAsJsonObject("data");
//                        //if(array.size() > 0){
//                        //for(int i=0;i<array.size();i++){
//                        //object = array.get(i).getAsJsonObject();
//                        Log.e("errdata","qwer------------"+object);
//                        Pg pgs = new Pg();
//
//                        pgs.setPg_id(object.get("pg_id").getAsInt());
//                        pgs.setName(object.get("name").getAsString());
//                        pgs.setPg_description(object.get("pg_description").getAsString());
//                        pgs.setAddress(object.get("address").getAsString());
//
//                        pg.add(pgs);
//
//                        pgName.setText(object.get("name").getAsString());
//                        pgDescription.setText(object.get("pg_description").getAsString());
//                        pgAddress.setText(object.get("address").getAsString());
//
//                        //}
//                    }
//                    //api is written and have to look for how the perticular data could be set on respected place
//
//
//
//                    @Override
//                    public void onFailure(Call<JsonObject> call, Throwable t) {
//
//                    }
//                });
//    }

    public void confirmBooking(View view){
        startActivity(new Intent(this, BookingActivity.class) );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    }
