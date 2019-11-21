package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CheckOutList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkoutlist);

        Button rpaycheck = (Button)findViewById(R.id.rpaycheck);
        Button patcheck = (Button)findViewById(R.id.paycheck);

        rpaycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paycheckgo = new Intent(getApplicationContext(),PayCheck.class);
                startActivity(paycheckgo);
            }
        });
    }
}
