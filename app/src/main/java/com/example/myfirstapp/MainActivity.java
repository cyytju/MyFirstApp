package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends Activity implements Button.OnClickListener{

    //GifImageView gifImageView = (GifImageView) findViewById(R.id.image);
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    public Button bt_class;
    public TextView tv_month;
    private int count = 0;

    int year = 0;
    int monthOfYear = 0;
    int dayOfMonth = 0;
    int minute = 0;
    int houre = 0;
    int dayOfWeek = 0;
    int week = 0;
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

        setContentView(R.layout.activity_main);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        count = pref.getInt("count", 0);
        for(int j = 0; j <= count; j++){
            String changedTime = pref.getString("time" + j, "");
            String changedClass = pref.getString("class" + j, "");
            changeClass(changedTime, changedClass);
        }
        initView();
        showDate(year, monthOfYear + 1, dayOfMonth);
        showTime(houre, minute);
    }

    //获得系统的日期和时间
    private void initView() {
        // 获得日历对象
        Calendar c = Calendar.getInstance();
        // 获取当前年份
        year = c.get(Calendar.YEAR);
        // 获取当前月份
        monthOfYear = c.get(Calendar.MONTH);
        // 获取当前月份的天数
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        //获取当前周数(得到的是自然周，和教学周(1-18)不同)
        week = c.get(Calendar.WEEK_OF_YEAR);
        //获取当前星期几
        dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        // 获取当前的小时数
        houre = c.get(Calendar.HOUR_OF_DAY);
        // 获取当前的分钟数
        minute = c.get(Calendar.MINUTE);
        //调用提示当天课程情况的方法
        showDayOfWeek(dayOfWeek);
        // 时间显示的文本对象
        showDate = (TextView) findViewById(R.id.main_tv_showdate);
        // 显示时间,周几的文本控件
        showtime = (TextView) findViewById(R.id.main_tv_showtime);
    }

    //显示周几的方法，并对该时间段有无课进行提示
    public void showDayOfWeek(int dayOfWeek){
        if(dayOfWeek == 1){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button1);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周一第一节没课");
                }else{
                    setToastLocation("周一第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button8);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周一第二节没课");
                }else{
                    setToastLocation("周一第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button15);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周一第三节没课");
                }else{
                    setToastLocation("周一第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button22);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周一第四节没课");
                }else{
                    setToastLocation("周一第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button29);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周一第五节没课");
                }else{
                    setToastLocation("周一第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }else if(dayOfWeek == 2){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button2);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周二第一节没课");
                }else{
                    setToastLocation("周二第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button9);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周二第二节没课");
                }else{
                    setToastLocation("周二第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button16);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周二第三节没课");
                }else{
                    setToastLocation("周二第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button23);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周二第四节没课");
                }else{
                    setToastLocation("周二第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button30);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周二第五节没课");
                }else{
                    setToastLocation("周二第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }else if(dayOfWeek == 3){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button3);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周三第一节没课");
                }else{
                    setToastLocation("周三第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button10);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周三第二节没课");
                }else{
                    setToastLocation("周三第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button17);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周三第三节没课");
                }else{
                    setToastLocation("周三第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button24);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周三第四节没课");
                }else{
                    setToastLocation("周三第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button31);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周三第五节没课");
                }else{
                    setToastLocation("周三第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }else if(dayOfWeek == 4){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button4);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周四第一节没课");
                }else{
                    setToastLocation("周四第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button11);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周四第二节没课");
                }else{
                    setToastLocation("周四第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button18);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周四第三节没课");
                }else{
                    setToastLocation("周四第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button25);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周四第四节没课");
                }else{
                    setToastLocation("周四第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button32);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周四第五节没课");
                }else{
                    setToastLocation("周四第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }else if(dayOfWeek == 5){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button5);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周五第一节没课");
                }else{
                    setToastLocation("周五第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button12);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周五第二节没课");
                }else{
                    setToastLocation("周五第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button19);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周五第三节没课");
                }else{
                    setToastLocation("周五第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button26);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周五第四节没课");
                }else{
                    setToastLocation("周五第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button33);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周四第五节没课");
                }else{
                    setToastLocation("周四第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }else if(dayOfWeek == 6){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button6);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周六第一节没课");
                }else{
                    setToastLocation("周六第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button13);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周六第二节没课");
                }else{
                    setToastLocation("周六第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button20);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周六第三节没课");
                }else{
                    setToastLocation("周六第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button27);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周六第四节没课");
                }else{
                    setToastLocation("周六第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button34);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周六第五节没课");
                }else{
                    setToastLocation("周六第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }else if(dayOfWeek == 0){
            if((houre == 8 && minute >= 30) || houre == 9 || (houre == 10 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button7);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周日第一节没课");
                }else{
                    setToastLocation("周日第一节课是" + bt_class.getText().toString());
                }
            }else if((houre == 10 && minute >= 25) || houre == 11 || (houre == 12 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button14);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周日第二节没课");
                }else{
                    setToastLocation("周日第二节课是" + bt_class.getText().toString());
                }
            }else if((houre == 13 && minute >= 30) || houre == 14 || (houre == 15 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button21);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周日第三节没课");
                }else{
                    setToastLocation("周日第三节课是" + bt_class.getText().toString());
                }
            }else if((houre == 15 && minute >= 25) || houre == 16 || (houre == 17 && minute <= 0)){
                bt_class = (Button)findViewById(R.id.button28);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周日第四节没课");
                }else{
                    setToastLocation("周日第四节课是" + bt_class.getText().toString());
                }
            }else if((houre == 18 && minute >= 30) || houre == 19 || (houre == 20 && minute <= 5)){
                bt_class = (Button)findViewById(R.id.button35);
                if(bt_class.getText().toString().isEmpty()){
                    setToastLocation("周日第五节没课");
                }else{
                    setToastLocation("周日第五节课是" + bt_class.getText().toString());
                }
            }else{
                setToastLocation("非上课时间");
            }
        }
    }

    //自定义显示位置的Toast
    public void setToastLocation(String str){
        Toast toast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
        //第一个参数：设置toast在屏幕中显示的位置。我现在的设置是居中靠顶
        //第二个参数：相对于第一个参数设置toast位置的横向X轴的偏移量，正数向右偏移，负数向左偏移
        //第三个参数：同的第二个参数道理一样
        //如果你设置的偏移量超过了屏幕的范围，toast将在屏幕内靠近超出的那个边界显示
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 800);
        //屏幕居中显示，X轴和Y轴偏移量都是0
        //toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    //显示日期，并设置TextView上日期的方法
    private void showDate(int year, int monthOfYear, int dayOfMonth) {
        showDate.setText(year + "年" + monthOfYear + "月" + dayOfMonth
                + "日");
        tv_month = (TextView) findViewById(R.id.month);
        String strMonth = monthOfYear + "\n月";
        tv_month.setText(strMonth);
    }

    //显示时间，第几周和星期几的方法
    private void showTime(int houre, int minute) {
        String strWeek = "";
        if(week == 1){
            strWeek = "第一周";
        }else if(week == 2){
            strWeek = "第二周";
        }else if(week == 3){
            strWeek = "第三周";
        }else if(week == 4){
            strWeek = "第四周";
        }else if(week == 5){
            strWeek = "第五周";
        }else if(week == 6){
            strWeek = "第六周";
        }else if(week == 7){
            strWeek = "第七周";
        }else if(week == 8){
            strWeek = "第八周";
        }else if(week == 9){
            strWeek = "第九周";
        }else if(week == 10){
            strWeek = "第十周";
        }else if(week == 11){
            strWeek = "第十一周";
        }else if(week == 12){
            strWeek = "第十二周 ";
        }else if(week == 13){
            strWeek = "第十三周";
        }else if(week == 14){
            strWeek = "第十四周";
        }else if(week == 15){
            strWeek = "第十五周";
        }else if(week == 16){
            strWeek = "第十六周";
        }else if(week == 17){
            strWeek = "第十七周";
        }else if(week == 18){
            strWeek = "第十八周";
        }else if(week == 19){
            strWeek = "第十九周";
        }else if(week == 20){
            strWeek = "第二十周";
        }else if(week == 21){
            strWeek = "第二十一周";
        }else if(week == 22){
            strWeek = "第二十二周 ";
        }else if(week == 23){
            strWeek = "第二十三周 ";
        }else if(week == 24){
            strWeek = "第二十四周";
        }else if(week == 25){
            strWeek = "第二十五周";
        }else if(week == 26){
            strWeek = "第二十六周";
        }else if(week == 27){
            strWeek = "第二十七周";
        }else if(week == 28){
            strWeek = "第二十八周";
        }else if(week == 29){
            strWeek = "第二十九周";
        }else if(week == 30){
            strWeek = "第三十周";
        }else if(week == 31){
            strWeek = "第三十一周";
        }else if(week == 32){
            strWeek = "第三十二周";
        }else if(week == 33){
            strWeek = "第三十三周";
        }else if(week == 34){
            strWeek = "第三十四周";
        }else if(week == 35){
            strWeek = "第三十五周";
        }else if(week == 36){
            strWeek = "第三十六周";
        }else{
            strWeek = "自然周";
        }
        if(dayOfWeek == 1){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周一");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周一");
            }
        }else if(dayOfWeek == 2){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周二");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周二");
            }
        }else if(dayOfWeek == 3){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周三");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周三");
            }
        }else if(dayOfWeek == 4){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周四");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周四");
            }
        }else if(dayOfWeek == 5){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周五");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周五");
            }
        }else if(dayOfWeek == 6){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周六");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周六");
            }
        }else if(dayOfWeek == 0){
            if(minute <= 9){
                showtime.setText(houre + ":0" + minute + " " + strWeek + " 周日");
            }else{
                showtime.setText(houre + ":" + minute + " " + strWeek + " 周日");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String strTime = bundle.getString("time");
            String strClass = bundle.getString("class");
            changeClass(strTime, strClass);
        }
    }

    public void changeClass(String strTime, String strClass){
        if(strTime.equals("周一第一节")){
            bt_class = (Button)findViewById(R.id.button1);
            bt_class.setText(strClass);
        }else if(strTime.equals("周二第一节")){
            bt_class = (Button)findViewById(R.id.button2);
            bt_class.setText(strClass);
        }else if(strTime.equals("周三第一节")){
            bt_class = (Button)findViewById(R.id.button3);
            bt_class.setText(strClass);
        }else if(strTime.equals("周四第一节")){
            bt_class = (Button)findViewById(R.id.button4);
            bt_class.setText(strClass);
        }else if(strTime.equals("周五第一节")){
            bt_class = (Button)findViewById(R.id.button5);
            bt_class.setText(strClass);
        }else if(strTime.equals("周六第一节")){
            bt_class = (Button)findViewById(R.id.button6);
            bt_class.setText(strClass);
        }else if(strTime.equals("周日第一节")){
            bt_class = (Button)findViewById(R.id.button7);
            bt_class.setText(strClass);
        }else if(strTime.equals("周一第二节")){
            bt_class = (Button)findViewById(R.id.button8);
            bt_class.setText(strClass);
        }else if(strTime.equals("周二第二节")){
            bt_class = (Button)findViewById(R.id.button9);
            bt_class.setText(strClass);
        }else if(strTime.equals("周三第二节")){
            bt_class = (Button)findViewById(R.id.button10);
            bt_class.setText(strClass);
        }else if(strTime.equals("周四第二节")){
            bt_class = (Button)findViewById(R.id.button11);
            bt_class.setText(strClass);
        }else if(strTime.equals("周五第二节")){
            bt_class = (Button)findViewById(R.id.button12);
            bt_class.setText(strClass);
        }else if(strTime.equals("周六第二节")){
            bt_class = (Button)findViewById(R.id.button13);
            bt_class.setText(strClass);
        }else if(strTime.equals("周日第二节")){
            bt_class = (Button)findViewById(R.id.button14);
            bt_class.setText(strClass);
        }else if(strTime.equals("周一第三节")){
            bt_class = (Button)findViewById(R.id.button15);
            bt_class.setText(strClass);
        }else if(strTime.equals("周二第三节")){
            bt_class = (Button)findViewById(R.id.button16);
            bt_class.setText(strClass);
        }else if(strTime.equals("周三第三节")){
            bt_class = (Button)findViewById(R.id.button17);
            bt_class.setText(strClass);
        }else if(strTime.equals("周四第三节")){
            bt_class = (Button)findViewById(R.id.button18);
            bt_class.setText(strClass);
        }else if(strTime.equals("周五第三节")){
            bt_class = (Button)findViewById(R.id.button19);
            bt_class.setText(strClass);
        }else if(strTime.equals("周六第三节")){
            bt_class = (Button)findViewById(R.id.button20);
            bt_class.setText(strClass);
        }else if(strTime.equals("周日第三节")){
            bt_class = (Button)findViewById(R.id.button21);
            bt_class.setText(strClass);
        }else if(strTime.equals("周一第四节")){
            bt_class = (Button)findViewById(R.id.button22);
            bt_class.setText(strClass);
        }else if(strTime.equals("周二第四节")){
            bt_class = (Button)findViewById(R.id.button23);
            bt_class.setText(strClass);
        }else if(strTime.equals("周三第四节")){
            bt_class = (Button)findViewById(R.id.button24);
            bt_class.setText(strClass);
        }else if(strTime.equals("周四第四节")){
            bt_class = (Button)findViewById(R.id.button25);
            bt_class.setText(strClass);
        }else if(strTime.equals("周五第四节")){
            bt_class = (Button)findViewById(R.id.button26);
            bt_class.setText(strClass);
        }else if(strTime.equals("周六第四节")){
            bt_class = (Button)findViewById(R.id.button27);
            bt_class.setText(strClass);
        }else if(strTime.equals("周日第四节")){
            bt_class = (Button)findViewById(R.id.button28);
            bt_class.setText(strClass);
        }else if(strTime.equals("周一第五节")){
            bt_class = (Button)findViewById(R.id.button29);
            bt_class.setText(strClass);
        }else if(strTime.equals("周二第五节")){
            bt_class = (Button)findViewById(R.id.button30);
            bt_class.setText(strClass);
        }else if(strTime.equals("周三第五节")){
            bt_class = (Button)findViewById(R.id.button31);
            bt_class.setText(strClass);
        }else if(strTime.equals("周四第五节")){
            bt_class = (Button)findViewById(R.id.button32);
            bt_class.setText(strClass);
        }else if(strTime.equals("周五第五节")){
            bt_class = (Button)findViewById(R.id.button33);
            bt_class.setText(strClass);
        }else if(strTime.equals("周六第五节")){
            bt_class = (Button)findViewById(R.id.button34);
            bt_class.setText(strClass);
        }else if(strTime.equals("周日第五节")){
            bt_class = (Button)findViewById(R.id.button35);
            bt_class.setText(strClass);
        }
    }

    public void click_changeButton(View v) {
        Intent intent = new Intent(MainActivity.this, ClassActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        count++;
        editor = pref.edit();
        editor.putInt("count", count);
        editor.apply();
        count = pref.getInt("count", 0);
        startActivityForResult(intent, 1);
    }

    public void show_Button1(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 1);
        editor.apply();
        if(pref.getString("teacher1", "").isEmpty() && pref.getString("week1", "").isEmpty()
          && pref.getString("place1", "").isEmpty() && pref.getString("number1", "").isEmpty()
          && pref.getString("name1", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher1", "");
            editor.putString("week1", "");
            editor.putString("place1", "");
            editor.putString("number1", "");
            editor.putString("name1", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button2(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 2);
        editor.apply();
        if(pref.getString("teacher2", "").isEmpty() && pref.getString("week2", "").isEmpty()
                && pref.getString("place2", "").isEmpty() && pref.getString("number2", "").isEmpty()
                && pref.getString("name2", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher2", "李幼萌 讲师");
            editor.putString("week2", "1-16周");
            editor.putString("place2", "45楼B304");
            editor.putString("number2", "99+");
            editor.putString("name2", "计算机组成原理");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button3(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 3);
        editor.apply();
        if(pref.getString("teacher3", "").isEmpty() && pref.getString("week3", "").isEmpty()
                && pref.getString("place3", "").isEmpty() && pref.getString("number3", "").isEmpty()
                && pref.getString("name3", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher3", "李森");
            editor.putString("week3", "1-16周");
            editor.putString("place3", "45楼B307");
            editor.putString("number3", "99+");
            editor.putString("name3", "数据库原理(双语)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button4(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 4);
        editor.apply();
        if(pref.getString("teacher4", "").isEmpty() && pref.getString("week4", "").isEmpty()
                && pref.getString("place4", "").isEmpty() && pref.getString("number4", "").isEmpty()
                && pref.getString("name4", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher4", "王征 副教授");
            editor.putString("week4", "9-16周");
            editor.putString("place4", "45楼B118");
            editor.putString("number4", "99+");
            editor.putString("name4", "汇编语言程序设计");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button5(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 5);
        editor.apply();
        if(pref.getString("teacher5", "").isEmpty() && pref.getString("week5", "").isEmpty()
                && pref.getString("place5", "").isEmpty() && pref.getString("number5", "").isEmpty()
                && pref.getString("name5", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher5", "Eliza");
            editor.putString("week5", "3-8周");
            editor.putString("place5", "未指定");
            editor.putString("number5", "99+");
            editor.putString("name5", "程序设计实践3");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button6(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 6);
        editor.apply();
        if(pref.getString("teacher6", "").isEmpty() && pref.getString("week6", "").isEmpty()
                && pref.getString("place6", "").isEmpty() && pref.getString("number6", "").isEmpty()
                && pref.getString("name6", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher6", "");
            editor.putString("week6", "");
            editor.putString("place6", "");
            editor.putString("number6", "");
            editor.putString("name6", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button7(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 7);
        editor.apply();
        if(pref.getString("teacher7", "").isEmpty() && pref.getString("week7", "").isEmpty()
                && pref.getString("place7", "").isEmpty() && pref.getString("number7", "").isEmpty()
                && pref.getString("name7", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher7", "");
            editor.putString("week7", "");
            editor.putString("place7", "");
            editor.putString("number7", "");
            editor.putString("name7", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button8(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 8);
        editor.apply();
        if(pref.getString("teacher8", "").isEmpty() && pref.getString("week8", "").isEmpty()
                && pref.getString("place8", "").isEmpty() && pref.getString("number8", "").isEmpty()
                && pref.getString("name8", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher8", "李森");
            editor.putString("week8", "1-16周");
            editor.putString("place8", "45楼B304");
            editor.putString("number8", "99+");
            editor.putString("name8", "数据库原理(双语)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button9(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 9);
        editor.apply();
        if(pref.getString("teacher9", "").isEmpty() && pref.getString("week9", "").isEmpty()
                && pref.getString("place9", "").isEmpty() && pref.getString("number9", "").isEmpty()
                && pref.getString("name9", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher9", "王征 副教授");
            editor.putString("week9", "9-16周");
            editor.putString("place9", "45楼B118");
            editor.putString("number9", "99+");
            editor.putString("name9", "汇编语言程序设计");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button10(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 10);
        editor.apply();
        if(pref.getString("teacher10", "").isEmpty() && pref.getString("week10", "").isEmpty()
                && pref.getString("place10", "").isEmpty() && pref.getString("number10", "").isEmpty()
                && pref.getString("name10", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher10", "毕重科 讲师");
            editor.putString("week10", "1-16周");
            editor.putString("place10", "45楼B118");
            editor.putString("number10", "99+");
            editor.putString("name10", "计算机网络(双语)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button11(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 11);
        editor.apply();
        if(pref.getString("teacher11", "").isEmpty() && pref.getString("week11", "").isEmpty()
                && pref.getString("place11", "").isEmpty() && pref.getString("number11", "").isEmpty()
                && pref.getString("name11", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher11", "李幼萌 讲师");
            editor.putString("week11", "1-16周");
            editor.putString("place11", "45楼B304");
            editor.putString("number11", "99+");
            editor.putString("name11", "计算机组成原理");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button12(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 12);
        editor.apply();
        if(pref.getString("teacher12", "").isEmpty() && pref.getString("week12", "").isEmpty()
                && pref.getString("place12", "").isEmpty() && pref.getString("number12", "").isEmpty()
                && pref.getString("name12", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher12", "翁仲铭 副教授");
            editor.putString("week12", "11-16周");
            editor.putString("place12", "45楼B203");
            editor.putString("number12", "99+");
            editor.putString("name12", "虚拟现实概论");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button13(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 13);
        editor.apply();
        if(pref.getString("teacher13", "").isEmpty() && pref.getString("week13", "").isEmpty()
                && pref.getString("place13", "").isEmpty() && pref.getString("number13", "").isEmpty()
                && pref.getString("name13", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher13", "");
            editor.putString("week13", "");
            editor.putString("place13", "");
            editor.putString("number13", "");
            editor.putString("name13", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button14(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 14);
        editor.apply();
        if(pref.getString("teacher14", "").isEmpty() && pref.getString("week14", "").isEmpty()
                && pref.getString("place14", "").isEmpty() && pref.getString("number14", "").isEmpty()
                && pref.getString("name14", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher14", "");
            editor.putString("week14", "");
            editor.putString("place14", "");
            editor.putString("number14", "");
            editor.putString("name14", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button15(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 15);
        editor.apply();
        if(pref.getString("teacher15", "").isEmpty() && pref.getString("week15", "").isEmpty()
                && pref.getString("place15", "").isEmpty() && pref.getString("number15", "").isEmpty()
                && pref.getString("name15", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher15", "毕重科 讲师");
            editor.putString("week15", "1-16周");
            editor.putString("place15", "45楼B310");
            editor.putString("number15", "99+");
            editor.putString("name15", "计算机网络(双语)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button16(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 16);
        editor.apply();
        if(pref.getString("teacher16", "").isEmpty() && pref.getString("week16", "").isEmpty()
                && pref.getString("place16", "").isEmpty() && pref.getString("number16", "").isEmpty()
                && pref.getString("name16", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher16", "Austin K.");
            editor.putString("week16", "1-8周");
            editor.putString("place16", "33楼114");
            editor.putString("number16", "98");
            editor.putString("name16", "专业外语(英)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button17(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 17);
        editor.apply();
        if(pref.getString("teacher17", "").isEmpty() && pref.getString("week17", "").isEmpty()
                && pref.getString("place17", "").isEmpty() && pref.getString("number17", "").isEmpty()
                && pref.getString("name17", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher17", "魏建国 教授");
            editor.putString("week17", "1-8周");
            editor.putString("place17", "46楼A309");
            editor.putString("number17", "99+");
            editor.putString("name17", "计算机新技术与产业发展");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button18(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 18);
        editor.apply();
        if(pref.getString("teacher18", "").isEmpty() && pref.getString("week18", "").isEmpty()
                && pref.getString("place18", "").isEmpty() && pref.getString("number18", "").isEmpty()
                && pref.getString("name18", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher18", "赵卫新 工程师");
            editor.putString("week18", "1-16周");
            editor.putString("place18", "未指定");
            editor.putString("number18", "99+");
            editor.putString("name18", "体育D");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button19(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 19);
        editor.apply();
        if(pref.getString("teacher19", "").isEmpty() && pref.getString("week19", "").isEmpty()
                && pref.getString("place19", "").isEmpty() && pref.getString("number19", "").isEmpty()
                && pref.getString("name19", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher19", "");
            editor.putString("week19", "");
            editor.putString("place19", "");
            editor.putString("number19", "");
            editor.putString("name19", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button20(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 20);
        editor.apply();
        if(pref.getString("teacher20", "").isEmpty() && pref.getString("week20", "").isEmpty()
                && pref.getString("place20", "").isEmpty() && pref.getString("number20", "").isEmpty()
                && pref.getString("name20", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher20", "");
            editor.putString("week20", "");
            editor.putString("place20", "");
            editor.putString("number20", "");
            editor.putString("name20", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button21(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 21);
        editor.apply();
        if(pref.getString("teacher21", "").isEmpty() && pref.getString("week21", "").isEmpty()
                && pref.getString("place21", "").isEmpty() && pref.getString("number21", "").isEmpty()
                && pref.getString("name21", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher21", "");
            editor.putString("week21", "");
            editor.putString("place21", "");
            editor.putString("number21", "");
            editor.putString("name21", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button22(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 22);
        editor.apply();
        if(pref.getString("teacher22", "").isEmpty() && pref.getString("week22", "").isEmpty()
                && pref.getString("place22", "").isEmpty() && pref.getString("number22", "").isEmpty()
                && pref.getString("name22", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher22", "郝姗 讲师");
            editor.putString("week22", "1-16周");
            editor.putString("place22", "46楼A405");
            editor.putString("number22", "99+");
            editor.putString("name22", "大学英语4");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button23(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 23);
        editor.apply();
        if(pref.getString("teacher23", "").isEmpty() && pref.getString("week23", "").isEmpty()
                && pref.getString("place23", "").isEmpty() && pref.getString("number23", "").isEmpty()
                && pref.getString("name23", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher23", "王征 副教授");
            editor.putString("week23", "1-8周");
            editor.putString("place23", "33楼104");
            editor.putString("number23", "99+");
            editor.putString("name23", "算法设计与分析(双语)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button24(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 24);
        editor.apply();
        if(pref.getString("teacher24", "").isEmpty() && pref.getString("week24", "").isEmpty()
                && pref.getString("place24", "").isEmpty() && pref.getString("number24", "").isEmpty()
                && pref.getString("name24", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher24", "翁仲铭 副教授");
            editor.putString("week24", "11-16周");
            editor.putString("place24", "45楼B203");
            editor.putString("number24", "99+");
            editor.putString("name24", "虚拟现实概论");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button25(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 25);
        editor.apply();
        if(pref.getString("teacher25", "").isEmpty() && pref.getString("week25", "").isEmpty()
                && pref.getString("place25", "").isEmpty() && pref.getString("number25", "").isEmpty()
                && pref.getString("name25", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher25", "Austin K.");
            editor.putString("week25", "1-8周");
            editor.putString("place25", "33楼114");
            editor.putString("number25", "97");
            editor.putString("name25", "专业外语(英)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button26(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 26);
        editor.apply();
        if(pref.getString("teacher26", "").isEmpty() && pref.getString("week26", "").isEmpty()
                && pref.getString("place26", "").isEmpty() && pref.getString("number26", "").isEmpty()
                && pref.getString("name26", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher26", "");
            editor.putString("week26", "");
            editor.putString("place26", "");
            editor.putString("number26", "");
            editor.putString("name26", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button27(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 27);
        editor.apply();
        if(pref.getString("teacher27", "").isEmpty() && pref.getString("week27", "").isEmpty()
                && pref.getString("place27", "").isEmpty() && pref.getString("number27", "").isEmpty()
                && pref.getString("name27", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher27", "");
            editor.putString("week27", "");
            editor.putString("place27", "");
            editor.putString("number27", "");
            editor.putString("name27", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button28(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 28);
        editor.apply();
        if(pref.getString("teacher28", "").isEmpty() && pref.getString("week28", "").isEmpty()
                && pref.getString("place28", "").isEmpty() && pref.getString("number28", "").isEmpty()
                && pref.getString("name28", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher28", "");
            editor.putString("week28", "");
            editor.putString("place28", "");
            editor.putString("number28", "");
            editor.putString("name28", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button29(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 29);
        editor.apply();
        if(pref.getString("teacher29", "").isEmpty() && pref.getString("week29", "").isEmpty()
                && pref.getString("place29", "").isEmpty() && pref.getString("number29", "").isEmpty()
                && pref.getString("name29", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher29", "章亦葵 副教授");
            editor.putString("week29", "1-16周");
            editor.putString("place29", "45楼B304");
            editor.putString("number29", "98");
            editor.putString("name29", "C#程序设计实践与.Net框架基础(双语)");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button30(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 30);
        editor.apply();
        if(pref.getString("teacher30", "").isEmpty() && pref.getString("week30", "").isEmpty()
                && pref.getString("place30", "").isEmpty() && pref.getString("number30", "").isEmpty()
                && pref.getString("name30", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher30", "盘刚 讲师");
            editor.putString("week30", "9-16周");
            editor.putString("place30", "46楼A306");
            editor.putString("number30", "99+");
            editor.putString("name30", "移动平台应用开发");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button31(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 31);
        editor.apply();
        if(pref.getString("teacher31", "").isEmpty() && pref.getString("week31", "").isEmpty()
                && pref.getString("place31", "").isEmpty() && pref.getString("number31", "").isEmpty()
                && pref.getString("name31", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher31", "");
            editor.putString("week31", "2-16(双周)");
            editor.putString("place31", "未指定");
            editor.putString("number31", "99+");
            editor.putString("name31", "物理实验B");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button32(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 32);
        editor.apply();
        if(pref.getString("teacher32", "").isEmpty() && pref.getString("week32", "").isEmpty()
                && pref.getString("place32", "").isEmpty() && pref.getString("number32", "").isEmpty()
                && pref.getString("name32", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher32", "潘刚 讲师");
            editor.putString("week32", "9-16周");
            editor.putString("place32", "46楼A306");
            editor.putString("number32", "98");
            editor.putString("name32", "移动平台应用开发");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button33(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 33);
        editor.apply();
        if(pref.getString("teacher33", "").isEmpty() && pref.getString("week33", "").isEmpty()
                && pref.getString("place33", "").isEmpty() && pref.getString("number33", "").isEmpty()
                && pref.getString("name33", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher33", "");
            editor.putString("week33", "");
            editor.putString("place33", "");
            editor.putString("number33", "");
            editor.putString("name33", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button34(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 34);
        editor.apply();
        if(pref.getString("teacher34", "").isEmpty() && pref.getString("week34", "").isEmpty()
                && pref.getString("place34", "").isEmpty() && pref.getString("number34", "").isEmpty()
                && pref.getString("name34", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher34", "");
            editor.putString("week34", "");
            editor.putString("place34", "");
            editor.putString("number34", "");
            editor.putString("name34", "");
            editor.apply();
        }
        startActivity(intent);
    }
    public void show_Button35(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowActivity.class);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        editor.putInt("flag", 35);
        editor.apply();
        if(pref.getString("teacher35", "").isEmpty() && pref.getString("week35", "").isEmpty()
                && pref.getString("place35", "").isEmpty() && pref.getString("number35", "").isEmpty()
                && pref.getString("name35", "").isEmpty()){
            editor = pref.edit();
            editor.putString("teacher35", "");
            editor.putString("week35", "");
            editor.putString("place35", "");
            editor.putString("number35", "");
            editor.putString("name35", "");
            editor.apply();
        }
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

    }
}