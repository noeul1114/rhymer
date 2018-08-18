package com.biggerThanGreater.willy.rhymer;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class loadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        Handler handler = new Handler();


        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(loadActivity.this,mainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(run, 2200);

    }



}
