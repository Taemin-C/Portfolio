package com.ctm.project3;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tab_host = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, Tab1.class);
        spec = tab_host.newTabSpec("tab1");
        spec.setIndicator("홈");
        spec.setContent(intent);
        tab_host.addTab(spec);

        intent = new Intent().setClass(this, Tab2.class);
        spec = tab_host.newTabSpec("tab2");
        spec.setIndicator("지역");
        spec.setContent(intent);
        tab_host.addTab(spec);

        intent = new Intent().setClass(this, Tab3.class);
        spec = tab_host.newTabSpec("tab3");
        spec.setIndicator("MY");
        spec.setContent(intent);
        tab_host.addTab(spec);
    }
}
