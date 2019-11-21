package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar Loading;
    private Timer timer;
    private  int i = 30;
    private TextView loadingtitle;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Loading = (ProgressBar)findViewById(R.id.Loading);
        Loading.setProgress(0);

        loadingtitle = (TextView)findViewById(R.id.splash_title);


        final long peroid = 100;
        timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i<100){
                    Loading.setProgress(i);
                    i=i+5;}

                else { timer.cancel();
                    /*  try{*/
                    /* Thread.sleep(2000);*/
                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();

               /*     }catch (InterruptedException e){
                        e.printStackTrace();
                    }*/

                    finish();}

            }

        },0,peroid);



    }

}
