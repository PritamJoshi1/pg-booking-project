package com.example.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;
import com.example.android.activity.PgDetailsActivity;
import com.example.android.activity.PgListActivity;
import com.example.android.entities.Locality;
import com.example.android.entities.Pg;

import java.util.List;

public class LocalityAdapter extends RecyclerView.Adapter<LocalityAdapter.MyViewHolder> {

    Context context;
    List<Locality> locList;
    List<Pg> pgListforImg;

    public LocalityAdapter(Context context,List<Locality> locList ) {
        this.context = context;
        this.locList = locList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.locality_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.locImg.setImageResource(locList.get(position));
        holder.locImg.setImageResource(locList.get(position).getLocalityImgs());
        holder.textView.setText(locList.get(position).getLocalities());
    }

    @Override
    public int getItemCount() {
        return locList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView locImg;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             locImg = itemView.findViewById(R.id.locImg);
            textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e("hii", "onClick: " );
            String locality = locList.get(getAdapterPosition()).getLocalities();
            //context.startActivity(new Intent(context, PgListActivity.class).putExtra("pgData",locImg.));
            //context.startActivity(new Intent(context, PgListActivity.class));//.putExtra("key",locImgs.get(getAdapterPosition())));
            context.startActivity(new Intent(context, PgListActivity.class).putExtra("localityName",locality));
        }
    }
}
