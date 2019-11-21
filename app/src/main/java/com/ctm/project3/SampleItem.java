package com.ctm.project3;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SampleItem extends AppCompatActivity implements OnMapReadyCallback {
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    boolean flag = false;

    TextView rentprice, onedayprice, rentbase, rent, oneday, onedaybase;


    TextView intxt, outtxt;
    LinearLayout checkin, checkout;

    int a, b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sampleitem);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.tmap);
        mapFragment.getMapAsync(this);

        final LinearLayout review = (LinearLayout)findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reviewgo = new Intent(getApplicationContext(),Review.class);
                startActivity(reviewgo);
            }
        });
        Button call = (Button) findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        intxt = (TextView) findViewById(R.id.intxt);
        outtxt = (TextView) findViewById(R.id.outtxt);
        rentprice = (TextView) findViewById(R.id.rentprice);
        onedayprice = (TextView) findViewById(R.id.onedayprice);
        rentbase = (TextView) findViewById(R.id.rentbase);
        rent = (TextView) findViewById(R.id.rent);
        onedaybase = (TextView) findViewById(R.id.onedaybase);
        oneday = (TextView) findViewById(R.id.oneday);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE", Locale.KOREAN);
        Date date = new Date(year, month, day - 1);
        Date date2 = new Date(year, month, day);
        String dayOfWeek2 = simpleDateFormat.format(date2);
        String dayOfWeek = simpleDateFormat.format(date);
        intxt.setText((month + 1) + "월 " + day + "일(" + dayOfWeek + ")");
        outtxt.setText((month + 1) + "월 " + (day + 1) + "일(" + dayOfWeek2 + ")");
        a = day;
        b = day;

        Button Qbtn = (Button) findViewById(R.id.Qbtn);
        Qbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Qintent = new Intent(getApplicationContext(), Question.class);
                startActivity(Qintent);
            }
        });
        checkin = (LinearLayout) findViewById(R.id.checkin);
        checkout = (LinearLayout) findViewById(R.id.checkout);

        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog indialog = new DatePickerDialog(SampleItem.this, indateListener, year, month, day);
                indialog.show();
            }
        });
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog outdialog = new DatePickerDialog(SampleItem.this, outdateListener, year, month, day);
                outdialog.show();
            }
        });
        RelativeLayout nomal = (RelativeLayout) findViewById(R.id.nomal);
        nomal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nomal = new Intent(getApplicationContext(), NomalRoom.class);
                startActivity(nomal);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(35.863, 128.555))
                .title("A모텔")
                .snippet("A Motel");
        googleMap.addMarker(marker).showInfoWindow();

        googleMap.getUiSettings().setZoomControlsEnabled(true);


    }

    DatePickerDialog.OnDateSetListener indateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE", Locale.KOREAN);
            Date date = new Date(selectedYear, selectedMonth, selectedDay - 1);
            Date date2 = new Date(selectedYear, selectedMonth, selectedDay);
            String dayOfWeek = simpleDateFormat.format(date);
            String dayOfWeek2 = simpleDateFormat.format(date2);
            intxt.setText((selectedMonth + 1) + "월 " + selectedDay + "일(" + dayOfWeek + ")");
            outtxt.setText((selectedMonth + 1) + "월 " + (selectedDay + 1) + "일(" + dayOfWeek2 + ")");
            a = selectedDay;
            if (dayOfWeek.equals("금")) {
                rentprice.setText("25000");
                onedayprice.setText("60000");

            } else if (dayOfWeek.equals("토")) {
                rentprice.setText("30000");
                onedayprice.setText("70000");
            } else {
                rentprice.setText("20000");
                onedayprice.setText("50000");
            }
        }

    };
    DatePickerDialog.OnDateSetListener outdateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            b = selectedDay;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE", Locale.KOREAN);
            Date date = new Date(selectedYear, selectedMonth, selectedDay - 1);
            String dayOfWeek = simpleDateFormat.format(date);
            outtxt.setText((selectedMonth + 1) + "월 " + selectedDay + "일(" + dayOfWeek + ")");

            if (b - a == 2 && flag == false) {
                flag = true;
                int stay = Integer.parseInt(onedayprice.getText().toString());
                int stayprice = stay + 70000;
                if (dayOfWeek.equals("일")) {
                    stayprice = stay + 80000;
                }
                rent.setText("");
                rentprice.setText("");
                rentbase.setText("연박");
                onedayprice.setText(stayprice + "");
            } else if (b - a == 3 && flag == false) {
                flag = true;
                int stay = Integer.parseInt(onedayprice.getText().toString());
                int stayprice = stay + 140000;
                if (dayOfWeek.equals("일")) {
                    stayprice = stay + 155000;
                }
                rent.setText("");
                rentprice.setText("");
                rentbase.setText("연박");
                onedayprice.setText(stayprice + "");
            } else if (b - a >= 4) {
                rent.setText("4박 이상은 해당 숙소에");
                rentprice.setText("");
                rentbase.setText("");
                onedayprice.setText("");
                oneday.setText("직접 문의하시기 바랍니다.");
                onedaybase.setText("");
            } else {
                flag = false;
                rent.setText("대실");
                rentbase.setText("원");
                oneday.setText("숙박");
                onedaybase.setText("원");
                if (dayOfWeek.equals("토")) {
                    rentprice.setText("25000");
                    onedayprice.setText("60000");

                } else if (dayOfWeek.equals("일")) {
                    rentprice.setText("30000");
                    onedayprice.setText("70000");
                } else {
                    rentprice.setText("20000");
                    onedayprice.setText("50000");
                }
            }
        }
    };

    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("숙소 전화 연결");
        builder.setMessage("해당 숙소로 전화합니다");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "전화연결", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
            }

        });
        builder.show();
    }
}

