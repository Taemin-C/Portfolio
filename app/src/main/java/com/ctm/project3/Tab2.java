package com.ctm.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Tab2 extends FragmentActivity implements OnMapReadyCallback {
    Spinner spin1,spin2;
    String[] area;
    EditText editArea;
    Button btnsearch,btnmap,searching;

    HorizontalScrollView radioscroll;
    RadioGroup DGrg;
    LinearLayout search1;
    LinearLayout search2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        spin1 = (Spinner)findViewById(R.id.spin1);
        spin2 = (Spinner)findViewById(R.id.spin2);
        radioscroll = (HorizontalScrollView)findViewById(R.id.radioscroll);
        DGrg = (RadioGroup)findViewById(R.id.DGrg);
        editArea = (EditText)findViewById(R.id.editArea);
        searching = (Button)findViewById(R.id.searching);
        btnsearch = (Button)findViewById(R.id.btnsearch);
        btnmap = (Button)findViewById(R.id.btnmap);
        search1 = (LinearLayout)findViewById(R.id.search1);
        search2 = (LinearLayout) findViewById(R.id.search2);


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search1.setVisibility(View.VISIBLE);
                search2.setVisibility(View.INVISIBLE);
            }
        });
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search1.setVisibility(View.INVISIBLE);
                search2.setVisibility(View.VISIBLE);
            }
        });
        searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),List.class);
                startActivity(intent);
            }
        });

        area = new String[] {"","서울","경기","인천","강원","제주","대전","충북","충남/세종","부산","울산","경남","대구",
        "경북","광주","전남","전주/전북"};


        DGrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            String[] subway1 = new String[] {"","설화명곡","화원","대곡","진천","월배","상인","월촌","송현","성당못","대명","안지랑","현충로","영대병원","교대","명덕","반월당",
                    "중앙로","대구","칠성시장","신천","동대구","큰고개","아양교","동촌","해안","방촌","용계","신기","반야월","각산","안심"};
            String[] subway2 = new String[] {"","문양"};
            String[] subway3 = new String[] {"","칠곡경대병원"};
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.DG1:
                        ArrayAdapter<String> DG1Adpater = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,subway1);
                        spin2.setAdapter(DG1Adpater);
                        break;
                    case R.id.DG2:
                        ArrayAdapter<String> DG2Adpater = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,subway2);
                        spin2.setAdapter(DG2Adpater);
                        break;
                    case R.id.DG3:
                        ArrayAdapter<String> DG3Adpater = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,subway3);
                        spin2.setAdapter(DG3Adpater);
                        break;
                }
            }
        });
        ArrayAdapter<String> areaAdpater = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,area);
        spin1.setAdapter(areaAdpater);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String areas = spin1.getSelectedItem().toString();


                editArea.setText(areas);
                switch (position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        radioscroll.setVisibility(View.GONE);
                        break;
                    case 11:
                    case 12:
                        radioscroll.setVisibility(View.VISIBLE);
                        break;

                    case 13:
                    case 14:
                    case 15:
                    case 16:

                    default:
                        radioscroll.setVisibility(View.GONE);
                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editArea.setText("");
                String sub = spin2.getSelectedItem().toString();
                String arae = spin1.getSelectedItem().toString();
                editArea.setText(arae + " " + sub);
                //editArea.setText(editArea.getText()+" "+sub);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        String[] motels;
        motels = new String[] {"A모텔","B모텔","C모텔","D모텔","E모텔"};
        float[] latlng;
        latlng = new float[] {0.0f,-0.005f,0.001f,-0.002f,0.002f};
        for(int i = 0; i < motels.length; i++) {

            MarkerOptions marker = new MarkerOptions();
            marker.position(new LatLng(35.863+latlng[i], 128.555+latlng[i]))
                    .title(motels[i])
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                    .alpha(0.6f);
            googleMap.addMarker(marker);

        }



        googleMap.getUiSettings().setZoomControlsEnabled(true);


        googleMap.getUiSettings().setZoomControlsEnabled(true);
       googleMap.getUiSettings().setCompassEnabled(true);
       googleMap.getUiSettings().setScrollGesturesEnabled(false);
       googleMap.getUiSettings().setAllGesturesEnabled(true);


    }
}
