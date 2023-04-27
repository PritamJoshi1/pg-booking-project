package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.adapter.PgDetailsAdapter;
import com.example.android.R;

import java.util.ArrayList;
import java.util.List;

public class Demo extends AppCompatActivity {
RecyclerView recyclerView;
    PgDetailsAdapter adapter;
    List<String> pglist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg_list);
        recyclerView=findViewById(R.id.recyclerView);

        pglist = new ArrayList<>();
         adapter= new PgDetailsAdapter(this,pglist);
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    public static class BookingActivity extends AppCompatActivity {
        DatePicker datePicker;
        ImageView PhotoId;
        TextView selectRoom,cccupancy,rent,textPhoto;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_booking);
            datePicker = findViewById(R.id.datePicker);
            PhotoId = findViewById(R.id.PhotoId);
            selectRoom = findViewById(R.id.selectRoom);


            textPhoto = findViewById(R.id.textPhoto);
        }

        public void selectRoom(View view){

        }
        public void submit(View view){

        }
    }
}
