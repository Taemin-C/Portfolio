package com.ctm.project3;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RentRoom extends AppCompatActivity {
    int times;
    int outtimes;
    ArrayAdapter<String> adapter;
    int i = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rentroom);

        final EditText point = (EditText) findViewById(R.id.point);
        Button downbtn = (Button) findViewById(R.id.downbtn);
        Button upbtn = (Button) findViewById(R.id.upbtn);
        final TextView finalprice = (TextView) findViewById(R.id.finalprice);
        final TextView rentprice = (TextView) findViewById(R.id.rentprice);
        final TextView coupon = (TextView) findViewById(R.id.coupontxt);

        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CharSequence[] items = {"-10000", "-5000", "쿠폰취소"};
                AlertDialog.Builder builder = new AlertDialog.Builder(RentRoom.this);

                builder.setTitle("색상을 선택하세요")
                        .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int index) {
                                Toast.makeText(getApplicationContext(), items[index], Toast.LENGTH_SHORT).show();

                                switch (index) {
                                    case 0:
                                        coupon.setText("-10000 쿠폰 적용");
                                        rentprice.setText("10000");
                                        rentprice.setTextColor(Color.RED);
                                        finalprice.setText(rentprice.getText().toString());
                                        finalprice.setTextColor(Color.RED);
                                        if (point.getText().toString().length() > 0) {
                                            int rp = Integer.parseInt(rentprice.getText().toString());
                                            int up = Integer.parseInt(point.getText().toString());
                                            if (rp-up<=0) {rentprice.setText("0");}
                                            else rentprice.setText((rp - up) + "");
                                            finalprice.setText(rentprice.getText().toString());
                                        }
                                        break;
                                    case 1:
                                        coupon.setText("-5000 쿠폰 적용");
                                        rentprice.setText("15000");
                                        rentprice.setTextColor(Color.RED);
                                        finalprice.setText(rentprice.getText().toString());
                                        finalprice.setTextColor(Color.RED);
                                        if (point.getText().toString().length() > 0) {

                                            int rp = Integer.parseInt(rentprice.getText().toString());
                                            int up = Integer.parseInt(point.getText().toString());
                                            if (rp-up<=0) {rentprice.setText("0");}
                                            else rentprice.setText((rp - up) + "");
                                            finalprice.setText(rentprice.getText().toString());
                                        }
                                        break;
                                    case 2:
                                        coupon.setText("사용 가능 쿠폰 2개");
                                        rentprice.setText("20000");
                                        rentprice.setTextColor(Color.GRAY);
                                        finalprice.setText(rentprice.getText().toString());
                                        finalprice.setTextColor(Color.GRAY);
                                        if (point.getText().toString().length() > 0) {
                                            int rp = Integer.parseInt(rentprice.getText().toString());
                                            int up = Integer.parseInt(point.getText().toString());
                                            if (rp-up<=0) {rentprice.setText("0");}
                                            else rentprice.setText((rp - up) + "");
                                            finalprice.setText(rentprice.getText().toString());
                                            rentprice.setTextColor(Color.RED);
                                            finalprice.setTextColor(Color.RED);
                                        }
                                        break;
                                }
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int rp;
                if (coupon.getText().toString().equals("사용 가능 쿠폰 2개")){rp=20000;}
                else if (coupon.getText().toString().equals("-10000 쿠폰 적용")){rp=10000;}
                else {rp=15000;}
                if (point.getText().toString().length() > 0) {
                    int up = Integer.parseInt(point.getText().toString());
                    if (s == point.getEditableText()) {
                        if (rp-up<=0) {rentprice.setText("0");}
                        else
                        rentprice.setText((rp - up) + "");
                        finalprice.setText(rentprice.getText().toString());
                        rentprice.setTextColor(Color.RED);
                        finalprice.setTextColor(Color.RED);
                        return;
                    }
                } else if (point.getText().toString().length() == 0 && coupon.getText().toString().equals("사용 가능 쿠폰 2개")) {
                    rentprice.setTextColor(Color.GRAY);
                    rentprice.setText("20000");
                    finalprice.setTextColor(Color.GRAY);
                    finalprice.setText(rentprice.getText().toString());
                    return;
                } else if (point.getText().toString().length() == 0 && coupon.getText().toString().equals("-10000 쿠폰 적용")) {

                    rentprice.setText("10000");
                    finalprice.setText(rentprice.getText().toString());
                    return;
                } else if (point.getText().toString().length() == 0 && coupon.getText().toString().equals("-5000 쿠폰 적용")) {

                    rentprice.setText("15000");
                    finalprice.setText(rentprice.getText().toString());
                    return;
                }
            }

        };
        point.addTextChangedListener(textWatcher);

        final TextView intime = (TextView) findViewById(R.id.intime);
        final TextView outtime = (TextView) findViewById(R.id.outtime);
        final TextView timepick = (TextView) findViewById(R.id.timepick);

        times = 9;

        downbtn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                if (times > 9) {
                    --times;
                    outtimes = times + 4;
                    timepick.setText(times + "");
                    intime.setText(times + "");
                    if (outtimes < 22) {
                        outtime.setText(outtimes + "");
                    } else if (outtimes >= 22) {
                        outtime.setText("22");
                    }
                } else {
                    return;
                }


            }
        });
        upbtn.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                ++times;
                outtimes = times + 4;
                if (times < 22) {
                    timepick.setText(times + "");
                    intime.setText(times + "");

                    if (outtimes < 22) {
                        outtime.setText(outtimes + "");
                    } else if (outtimes >= 22) {
                        outtime.setText("22");
                    }
                } else {
                    return;
                }
            }
        });

    }

}
