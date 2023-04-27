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
import com.example.android.entities.Amenities;

import java.util.ArrayList;

public class AmenityAdapter extends RecyclerView.Adapter<AmenityAdapter.ViewHolder> {
    ArrayList<Amenities> amenities;
    Context context;

    public AmenityAdapter(ArrayList<Amenities> amenities, Context context) {
        this.amenities = amenities;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amenity_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(amenities.get(position).getAmLogo());
        holder.textView.setText(amenities.get(position).getAmName());
    }

    @Override
    public int getItemCount() {
        return amenities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
