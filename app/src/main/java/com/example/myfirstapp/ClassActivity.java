package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by 陽陽 on 2018/6/5.
 */

public class ClassActivity extends Activity implements Button.OnClickListener{
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    private int i = 0;

    int year = 0;
    int monthOfYear = 0;
    int dayOfMonth = 0;
    int minute = 0;
    int houre = 0;
    TextView showDate = null;
    TextView showtime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //沉浸式状态栏,背景和当前activity一样
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_class);

        initView();
        showDate(year, monthOfYear + 1, dayOfMonth);
        showTime(houre, minute);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        i = pref.getInt("count", 0);

        final EditText editTime = (EditText)findViewById(R.id.edit_time);
        Button btnGetTime = (Button)findViewById(R.id.btn_input_time);
        btnGetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                editor = pref.edit();
                editor.putString("time" + i, editTime.getText().toString());
                editor.apply();
                bundle.putString("time", pref.getString("time" + i, ""));
                intent.putExtras(bundle);
                setResult(AppCompatActivity.RESULT_OK, intent);
                //finish();
            }
        });

        final EditText editClass = (EditText)findViewById(R.id.edit_class);
        Button btnGetClass = (Button)findViewById(R.id.btn_change_class);
        btnGetClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                editor = pref.edit();
                editor.putString("class" + i, editClass.getText().toString());
                editor.apply();
                bundle.putString("class", pref.getString("class" + i, ""));
                intent.putExtras(bundle);
                setResult(AppCompatActivity.RESULT_OK, intent);
                finish();
            }
        });
    }

    private void initView() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        monthOfYear = c.get(Calendar.MONTH);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        houre = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        showDate = (TextView) findViewById(R.id.main_tv_showdate);
        showtime = (TextView) findViewById(R.id.main_tv_showtime);
    }
    private void showDate(int year, int monthOfYear, int dayOfMonth) {
        showDate.setText(year + "年" + monthOfYear + "月" + dayOfMonth
                + "日");
    }
    private void showTime(int houre, int minute) {
        if(minute <= 9){
            showtime.setText(houre + ":0" + minute);
        }else{
            showtime.setText(houre + ":" + minute);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
