package com.example.android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.android.R;

import java.util.List;

public class PgPhotosAdapter extends PagerAdapter {

    List<Integer> imgList;

    public PgPhotosAdapter(List<Integer> imageList)
    {
        this.imgList=imageList;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.img_layout,container,false);
        ImageView image=view.findViewById(R.id.imageView);

        image.setImageResource((imgList.get(position)));
        container.addView(view);


//        ImageView view = new ImageView(container.getContext());
//        Glide.with(container.getContext())
//                .load(imgList.get(position))
//                .into(view);
//        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
