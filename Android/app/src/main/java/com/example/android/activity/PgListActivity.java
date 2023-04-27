package com.example.android.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.R;

import com.example.android.adapter.PgListAdapter;
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

public class PgListActivity extends AppCompatActivity {
RecyclerView recyclerView;
PgListAdapter pgListAdapter;
List<Pg> pg;
String locality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_list);
        recyclerView= findViewById(R.id.PgRecyclerView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //dummyDataPg();
//        pgListAdapter = new PgListAdapter(this,pg);
//        recyclerView.setAdapter(pgListAdapter);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        locality = getIntent().getStringExtra("localityName");
        getLocalityData(locality);

    }
//    public void dummyDataPg(){
//        pg = new ArrayList<>();
//        pg.add(new Pg(R.drawable.pg,"Sam","Pune",123,"Hinjewadi"));
//        pg.add(new Pg(R.drawable.images,"Dar","Pune",123,"Hinjewadi"));
//        pg.add(new Pg(R.drawable.pg,"Var","Pune",123,"Hinjewadi"));
//        pg.add(new Pg(R.drawable.pg,"Pri","Pune",123,"Hinjewadi"));
//        pg.add(new Pg(R.drawable.pg,"Abd","Pune",123,"Hinjewadi"));
//        pg.add(new Pg(R.drawable.pg,"Abd","Pune",123,"Hinjewadi"));

//    }


    public void getLocalityData(String locality)
    {
        pg = new ArrayList<>();
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
                .create(HomePageApi.class)
                .getLocality(locality)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonArray array = response.body().getAsJsonArray("data");
                        //Log.e("locArray","locArray-------------"+array);
                        JsonObject object;
                        if(array.size() > 0){
                            for(int i=0;i<array.size();i++){
                                object = array.get(i).getAsJsonObject();
                                Pg pgs = new Pg();
                                pgs.setPg_id(object.get("pg_id").getAsInt());
                                pgs.setName(object.get("name").getAsString());
                                pgs.setAddress(object.get("address").getAsString());
                                pgs.setPg_mobile(object.get("pg_mobile").getAsString());
                                //Log.e("locs","locobj================="+pgs);
                                JsonArray a = (JsonArray) object.get("images");
                                List<String> b = new ArrayList<>();
                                for(int j=0;j<a.size();j++){
                                    b.add((a.get(j).getAsString()));
                                }
                                pgs.setImage(b);
                                pg.add(pgs);
                                //Log.e("locpgs","locpgs-------------"+pgs);
                            }

                        }
                        pgListAdapter = new PgListAdapter(PgListActivity.this,pg);
                        pgListAdapter.notifyDataSetChanged();
                        //Log.e("locs","locs============"+pg);
                        recyclerView.setAdapter(pgListAdapter);
                        recyclerView.setLayoutManager(new GridLayoutManager(PgListActivity.this,1));


                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}