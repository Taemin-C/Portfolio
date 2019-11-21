package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Tab3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        LinearLayout Rule = (LinearLayout)findViewById(R.id.Rule);
        LinearLayout reservedgo = (LinearLayout)findViewById(R.id.reservedgo);
        LinearLayout checkoutlist = (LinearLayout)findViewById(R.id.checkoutlist);

        Rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rules = new Intent(getApplicationContext(),Rule.class);
                startActivity(rules);
            }
        });
        reservedgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reserved = new Intent(getApplicationContext(),Reserved.class);
                startActivity(reserved);
            }
        });
        checkoutlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent checklist = new Intent(getApplicationContext(),CheckOutList.class);
                startActivity(checklist);
            }
        });
    }
}
