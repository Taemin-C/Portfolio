package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class NomalRoom extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nomalroom);

        Button rentroom = (Button)findViewById(R.id.rentroom);

        rentroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent renting = new Intent(getApplicationContext(),RentRoom.class);
                startActivity(renting);
            }
        });
        Button onedayroom = (Button)findViewById(R.id.onedayroom);
        onedayroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onedaying = new Intent(getApplicationContext(),OneDay.class);
                startActivity(onedaying);
            }
        });
    }
}
