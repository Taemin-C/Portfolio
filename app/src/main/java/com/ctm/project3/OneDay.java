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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OneDay extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oneday);
        final TextView finalprice = (TextView) findViewById(R.id.finalprice);
        final TextView onedayprice = (TextView) findViewById(R.id.onedayprice);
        final TextView coupon = (TextView) findViewById(R.id.coupontxt);
        final EditText point = (EditText) findViewById(R.id.point);
        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CharSequence[] items = {"-10000", "-5000", "쿠폰취소"};
                AlertDialog.Builder builder = new AlertDialog.Builder(OneDay.this);

                builder.setTitle("색상을 선택하세요")
                        .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int index) {
                                Toast.makeText(getApplicationContext(), items[index], Toast.LENGTH_SHORT).show();

                                switch (index) {
                                    case 0:
                                        
                                        coupon.setText("-10000 쿠폰 적용");
                                        onedayprice.setText("40000");
                                        onedayprice.setTextColor(Color.RED);
                                        finalprice.setText(onedayprice.getText().toString());
                                        finalprice.setTextColor(Color.RED);
                                        if (point.getText().toString().length() > 0) {
                                            int rp = Integer.parseInt(onedayprice.getText().toString());
                                            int up = Integer.parseInt(point.getText().toString());
                                            if (rp - up <= 0) {
                                                onedayprice.setText("0");
                                            } else onedayprice.setText((rp - up) + "");
                                            finalprice.setText(onedayprice.getText().toString());
                                        }
                                        break;
                                    case 1:
                                        coupon.setText("-5000 쿠폰 적용");
                                        onedayprice.setText("45000");
                                        onedayprice.setTextColor(Color.RED);
                                        finalprice.setText(onedayprice.getText().toString());
                                        finalprice.setTextColor(Color.RED);
                                        if (point.getText().toString().length() > 0) {

                                            int rp = Integer.parseInt(onedayprice.getText().toString());
                                            int up = Integer.parseInt(point.getText().toString());
                                            if (rp - up <= 0) {
                                                onedayprice.setText("0");
                                            } else onedayprice.setText((rp - up) + "");
                                            finalprice.setText(onedayprice.getText().toString());
                                        }
                                        break;
                                    case 2:
                                        coupon.setText("사용 가능 쿠폰 2개");
                                        onedayprice.setText("50000");
                                        onedayprice.setTextColor(Color.GRAY);
                                        finalprice.setText(onedayprice.getText().toString());
                                        finalprice.setTextColor(Color.GRAY);
                                        if (point.getText().toString().length() > 0) {
                                            int rp = Integer.parseInt(onedayprice.getText().toString());
                                            int up = Integer.parseInt(point.getText().toString());
                                            if (rp - up <= 0) {
                                                onedayprice.setText("0");
                                            } else onedayprice.setText((rp - up) + "");
                                            finalprice.setText(onedayprice.getText().toString());
                                            onedayprice.setTextColor(Color.RED);
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
                        if (rp-up<=0) {onedayprice.setText("0");}
                        else
                            onedayprice.setText((rp - up) + "");
                        finalprice.setText(onedayprice.getText().toString());
                        onedayprice.setTextColor(Color.RED);
                        finalprice.setTextColor(Color.RED);
                        return;
                    }
                } else if (point.getText().toString().length() == 0 && coupon.getText().toString().equals("사용 가능 쿠폰 2개")) {
                    onedayprice.setTextColor(Color.GRAY);
                    onedayprice.setText("50000");
                    finalprice.setTextColor(Color.GRAY);
                    finalprice.setText(onedayprice.getText().toString());
                    return;
                } else if (point.getText().toString().length() == 0 && coupon.getText().toString().equals("-10000 쿠폰 적용")) {

                    onedayprice.setText("40000");
                    finalprice.setText(onedayprice.getText().toString());
                    return;
                } else if (point.getText().toString().length() == 0 && coupon.getText().toString().equals("-5000 쿠폰 적용")) {

                    onedayprice.setText("45000");
                    finalprice.setText(onedayprice.getText().toString());
                    return;
                }
            }

        };
        point.addTextChangedListener(textWatcher);
    }
    
}
