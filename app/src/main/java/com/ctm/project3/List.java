package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class List extends AppCompatActivity {
    RelativeLayout sample;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        RadioButton rb1 = (RadioButton)findViewById(R.id.rb1);
        rb1.setChecked(true);
        sample = (RelativeLayout)findViewById(R.id.sample);

        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SampleItem.class);
                startActivity(intent);
            }
        });
    }
}
