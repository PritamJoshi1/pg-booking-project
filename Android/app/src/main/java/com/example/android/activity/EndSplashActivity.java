package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class EndSplashActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_splash);
        imageView = findViewById(R.id.endImage);
        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1000);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        imageView.startAnimation(animation);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4200);
                    startActivity(new Intent(EndSplashActivity.this,HomeActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        getSupportActionBar().hide();

    }
}