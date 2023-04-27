package com.example.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.R;
import com.example.android.activity.PgDetailsActivity;
import com.example.android.activity.pgDetailsActivity2;
import com.example.android.entities.Pg;
import com.example.android.utils.Constants;

import java.util.List;

public class PgListAdapter extends RecyclerView.Adapter<PgListAdapter.MyViewHolder> {
    Context context;
    List<Pg> pgList;

    public PgListAdapter(Context context, List<Pg> pgList ) {
        this.context = context;
        this.pgList=pgList;
    }

    @NonNull
    @Override
    public PgListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.pg_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PgListAdapter.MyViewHolder holder, int position) {
        Pg pg = pgList.get(position);
        String firstImage = (pg.getImage().get(0));
        //holder.pgImage.setImageResource(pg.getImage());
        holder.txtPgName.setText(pg.getName());
        holder.txtPgAddress.setText(pg.getAddress());
        holder.txtPgPhone.setText(""+pg.getPg_mobile());
        Glide.with(context)
                .load(Constants.BASE_URL+"/imgName/"+firstImage).into(holder.pgImage);
    }

    @Override
    public int getItemCount() {
        return pgList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView pgImage;
        TextView txtPgName, txtPgAddress, txtPgPhone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pgImage = itemView.findViewById(R.id.pgImage);
            txtPgName = itemView.findViewById(R.id.txtPgName);
            txtPgAddress = itemView.findViewById(R.id.txtPgAddress);
            txtPgPhone = itemView.findViewById(R.id.txtPgPhone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pgId2 = pgList.get(getAdapterPosition()).getPg_id();
            context.startActivity(new Intent(context,pgDetailsActivity2.class).putExtra("key2",pgId2));
        }
    }
}

