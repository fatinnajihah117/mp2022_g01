package com.example.tranquiltrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    static int progress;
    ProgressBar progressBar;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progress=0;
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus<10){
                    progressStatus = doSomeWork();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }

            private int doSomeWork(){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return ++progress;
            }


        }).start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,SplashScreen2.class);
                startActivity(intent);
                finish();
            }
        },3000);



    }
}