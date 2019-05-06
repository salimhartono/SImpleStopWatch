package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCount;
    Button btPause, btStart, btReset, btShow;

    long millliSecond, startTIme, timeBuff, updateTime = 0L ;
    int Seconds, Minutes, MilliSeconds ;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tCount);
        handler = new Handler();

        //button
        btStart = findViewById(R.id.btStart);
        btPause = findViewById(R.id.btPause);
        btReset = findViewById(R.id.btReset);
        btShow = findViewById(R.id.btShow);

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SplashAct.class));
            }
        });

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTIme = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
            }
        });

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeBuff += millliSecond;

                handler.removeCallbacks(runnable);
                btReset.setEnabled(true);

            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                millliSecond = 0L ;
                startTIme = 0L ;
                timeBuff = 0L ;
                updateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                tvCount.setText("00:00:00");
            }
        });

    }

    public Runnable runnable = new Runnable() {

        public void run() {
            millliSecond = SystemClock.uptimeMillis() - startTIme;
            updateTime = timeBuff + millliSecond;
            Seconds = (int) (updateTime / 1000);
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) (updateTime % 1000);

            tvCount.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };
}
