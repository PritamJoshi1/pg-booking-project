package com.example.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.bumptech.glide.Glide;
import com.example.android.R;
import com.example.android.adapter.HomeAdapter;
import com.example.android.adapter.LocalityAdapter;
import com.example.android.entities.Customers;
import com.example.android.entities.Locality;
import com.example.android.entities.Pg;
import com.example.android.retrofit.HomePageApi;
import com.example.android.utils.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView,recyclerViewPg;
    List<Pg> pgList;
    //List<Integer> locImgs;
    List<Locality> locList;


    HomeAdapter homeAdapter;
    LocalityAdapter localityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewPg = findViewById(R.id.recyclerViewPg);

        //dummyDataPg();

        getPgData();

        dummyDataLocality();
        localityAdapter = new LocalityAdapter(this,locList);
        recyclerView.setAdapter(localityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));

        //to be commented
//        homeAdapter = new HomeAdapter(this,pg);
//        recyclerViewPg.setAdapter(homeAdapter);
//        recyclerViewPg.setLayoutManager(new GridLayoutManager(this,2));
    }


    //int pg_id, String image, String pg_name, String pg_address, int pg_phone, String pg_locality
//    public void dummyDataPg(){
//        pg = new ArrayList<>();
////        pg.add(new Pg(R.drawable.pgimage,"Sam","Sangli",123,"Hinjewadi"));
////        pg.add(new Pg(R.drawable.pgimage,"Dar","Nagpur",456,"wakad"));
////        pg.add(new Pg(R.drawable.pgimage,"Var","Gondia",789,"baner"));
////        pg.add(new Pg(R.drawable.pgimage,"Pri","Kolhapur",101112,"chinchwad"));
////        pg.add(new Pg(R.drawable.pgimage,"Abd","Pune",131415,"kothrud"));
////        pg.add(new Pg(R.drawable.singlebed,"Abd","Mumbai",161718,"kharadi"));
//
//        pg.add(new Pg("REST IN","HINJEWADI", 67886669,"HINJEWADI"));
//        pg.add(new Pg("ZOLO","KHARADI",987766987,"KHARADI"));
//        pg.add(new Pg("7 HILL","CHINCHWAD",943522432,"CHINCHWAD"));
//        pg.add(new Pg("VEERA PG","BANER",978877432,"BANER"));
//        pg.add(new Pg("SHRI GANESH PG","WAKAD",998877665,"WAKAD"));
//        pg.add(new Pg("TCG","KOTHRUD",976756456,"KOTHRUD"));
//
//    }

    public void dummyDataLocality(){


        locList = new ArrayList<>();
        locList.add(new Locality(R.drawable.kharadibg,"Kharadi"));
        locList.add(new Locality(R.drawable.hadapsar,"Hadapsar"));
        locList.add(new Locality(R.drawable.karvenagar,"Karve Nagar"));
        locList.add(new Locality(R.drawable.narhe,"Narhe"));
        locList.add(new Locality(R.drawable.locbg,"Hinjewadi"));

    }

    public void getPgData(){
        pgList = new ArrayList<>();
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(HomePageApi.class)
                .getPg()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonArray jsonArray = response.body().getAsJsonArray("data");
                        //Log.e("array2","array2-------------"+jsonArray);
                        JsonObject jsonObject;
                        if(jsonArray.size() > 0){
                            for(int i=0;i<jsonArray.size();i++){
                                jsonObject = jsonArray.get(i).getAsJsonObject();
                                //Log.e("obj","obj---"+jsonObject);
                                Pg pgs = new Pg();
                                pgs.setPg_id(jsonObject.get("pg_id").getAsInt());
                                pgs.setName(jsonObject.get("name").getAsString());
                                pgs.setAddress(jsonObject.get("address").getAsString());
                                pgs.setPg_mobile(jsonObject.get("pg_mobile").getAsString());
                                JsonArray imgArray = (JsonArray) jsonObject.get("images");

                                List<String> imgList = new ArrayList<>();
                                for(int j=0;j<imgArray.size();j++){
                                    imgList.add((imgArray.get(j).getAsString()));
                                }
                                pgs.setImage(imgList);
                                Log.e("img","img------------"+imgList);
                                Log.e("pgs","pgobj"+pgs);
                                pgList.add(pgs);
                                //Log.e("pgss","pgss=============="+pgList);
                            }
                        }
                        homeAdapter = new HomeAdapter(HomeActivity.this,pgList);
                        homeAdapter.notifyDataSetChanged();
                        //Log.e("pglist","pglist---"+pgList);
                        recyclerViewPg.setAdapter(homeAdapter);
                        recyclerViewPg.setLayoutManager(new GridLayoutManager(HomeActivity.this,2));

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                })
        ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.add("Profile");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        getSharedPreferences("pg",MODE_PRIVATE).edit().putBoolean("login_status",false).commit();
        this.startActivity(new Intent(this,LoginActivity.class));
        Customers customers = new Customers();
//        int cid = customersList.get(customers.getC_id());
        if(item.getTitle().equals("Profile")){
            startActivity(new Intent(this,ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
}



}