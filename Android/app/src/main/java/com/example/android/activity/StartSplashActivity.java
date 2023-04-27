package com.example.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartSplashActivity extends AppCompatActivity {
    boolean login_status;
ImageView imageView;
    ProgressBar progressBar;
    TextView textView;
    int count =0;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_splash);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textCount);
        Animation animation = new AlphaAnimation(1, 0); //to change visibility from visible to invisible
        animation.setDuration(1000); //1 second duration for each animation cycle
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE); //repeating indefinitely
        animation.setRepeatMode(Animation.REVERSE); //animation will start from end point once ended.
        imageView.startAnimation(animation); //to start animation
        login_status = getSharedPreferences("pg", MODE_PRIVATE).getBoolean("login_status", false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4200);
                    while (count < 100){
                        count++;
                        android.os.SystemClock.sleep(50);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(count);
                            }
                        });
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setVisibility(View.VISIBLE);
                        }
                    });
                    if(login_status)
                    {
                        startActivity(new Intent(StartSplashActivity.this,HomeActivity.class));

                    }else
                        startActivity(new Intent(StartSplashActivity.this,LoginActivity.class));

                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
}

    }

