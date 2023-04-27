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

import com.bumptech.glide.Glide;
import com.example.android.R;
import com.example.android.activity.HomeActivity;
import com.example.android.activity.PgDetailsActivity;
import com.example.android.entities.Pg;
import com.example.android.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
   Context context;
   List<Pg> pgList;

    public HomeAdapter(Context context, List<Pg> pgList ) {
        this.context = context;

        this.pgList=pgList;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pg pg = pgList.get(position);
        String firstImage = (pg.getImage().get(0));
        Log.e("image","image-----------"+firstImage);
        holder.textName.setText(pg.getName());
        holder.textAddress.setText(pg.getAddress());
        holder.textPhone.setText(""+pg.getPg_mobile());
//        holder.imageView.setImageResource(pg.getImage());
        Glide.with(context)
                .load(Constants.BASE_URL+"/imgName/"+firstImage).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return pgList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textName,textAddress,textPhone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_img);
            textName = itemView.findViewById(R.id.textName);
            textAddress = itemView.findViewById(R.id.textAddress);
            textPhone = itemView.findViewById(R.id.textPhone);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            List<String>  imgList = new ArrayList<>();
//            Pg pg = new Pg();
//            pg.getImage()
//            imgList = pg.getImage();
//            imgList.add(pg.getImage().get(1));
            //Log.e("imgList","imgList----------"+imgList);
            Log.e("home", "onClick: ");
            int pgId = pgList.get(getAdapterPosition()).getPg_id();
        context.startActivity(new Intent(context, PgDetailsActivity.class).putExtra("pgId",pgId));
//        Intent intent = new Intent(context,PgDetailsActivity.class);
//        intent.putExtra("pgId",pgId);
// `       intent.putStringArrayListExtra("imgList", (ArrayList<String>) imgList);
//        context.startActivity(intent);
        }
    }

}
