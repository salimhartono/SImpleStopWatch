package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.victor.loading.book.BookLoading;
import com.victor.loading.newton.NewtonCradleLoading;

public class SplashAct extends AppCompatActivity {

NewtonCradleLoading newtonCradleLoading;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 10000L);


        button = findViewById(R.id.dummy_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        newtonCradleLoading = (NewtonCradleLoading) findViewById(R.id.bookloading);
        newtonCradleLoading.start();
        newtonCradleLoading.setLoadingColor(R.color.book_loading_book);

    }
}
