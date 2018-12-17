package com.example.ljh.nooooooooooooooo;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent_start = new Intent(FirstActivity.this,
                        MainActivity.class);
                startActivity(intent_start);
                finish();
            }
        }, 2000);
    }
}
