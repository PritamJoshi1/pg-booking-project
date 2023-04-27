//package com.example.android.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager.widget.ViewPager;
//
//import android.os.Bundle;
//
//import com.example.android.R;
//import com.example.android.adapter.PgPhotosAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Activity extends AppCompatActivity {
//    ViewPager viewPager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_demo);
//        viewPager = findViewById(R.id.viewPager);
//
//        List<Integer> imageList = new ArrayList<>();
//        imageList.add(R.drawable.download);
//        imageList.add(R.drawable.demo_two);
//        imageList.add(R.drawable.demo_three);
//
//
//        PgPhotosAdapter myAdapter = new PgPhotosAdapter(imageList);
//
//        viewPager.setAdapter(myAdapter);
//    }
//    }
