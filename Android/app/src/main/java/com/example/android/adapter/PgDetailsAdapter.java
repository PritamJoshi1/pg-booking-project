package com.example.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import java.util.List;

public class PgDetailsAdapter extends RecyclerView.Adapter<PgDetailsAdapter.MyViewHolder> {
  Context context;
  List<String> pglist;

    public PgDetailsAdapter(Context context, List<String> pglist) {
        this.context = context;
        this.pglist = pglist;
    }

    @NonNull
    @Override
    public PgDetailsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pg_details_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PgDetailsAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pglist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textPgName,textPgAddress,textPgContact;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.pg_image);
            textPgName=itemView.findViewById(R.id.textPgName);
            textPgAddress=itemView.findViewById(R.id.textPgAddress);
            textPgContact=itemView.findViewById(R.id.textPgContact);
        }
    }
}
