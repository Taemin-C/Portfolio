package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Tab1 extends AppCompatActivity {

    ViewPager event;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button nsbtn = (Button)findViewById(R.id.nsbtn);
        Button detailbtn = (Button)findViewById(R.id.detailbtn);
        Button nearbtn= (Button)findViewById(R.id.nearbtn);
        EditText editns = (EditText)findViewById(R.id.editns);
        LinearLayout tab1 = (LinearLayout)findViewById(R.id.tab1);
        Snackbar snackbar = Snackbar.make(tab1,"예약된 숙소가 있습니다",Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("확인하기", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Reserved = new Intent(getApplicationContext(),Reserved.class);
                        startActivity(Reserved);
                    }
                }).show();
        editns.setText("A");

        nsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nsintent = new Intent(getApplicationContext(),NameSearch.class);
                startActivity(nsintent);
            }
        });
        detailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailintent = new Intent(getApplicationContext(), Detail.class);
                startActivity(detailintent);
            }
        });
        nearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nearintent = new Intent(getApplicationContext(),Near.class);
                startActivity(nearintent);
            }
        });

        event = (ViewPager)findViewById(R.id.event);
        MainPager eventadapter = new MainPager(getSupportFragmentManager());
        Event1 event1 = new Event1();
        eventadapter.addItem(event1);
        event.setAdapter(eventadapter);





    }
}
class MainPager extends FragmentStatePagerAdapter {
    ArrayList<Fragment> items = new ArrayList<Fragment>();
    public MainPager(FragmentManager fm){super(fm); }



    public void addItem(Fragment item) {
        items.add(item);
    }
    public float getPageWidth(int postion){
        return 1;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}