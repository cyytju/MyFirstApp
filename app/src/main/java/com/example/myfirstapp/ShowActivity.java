package com.example.myfirstapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShowActivity extends Activity implements Button.OnClickListener{
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        final int flag = pref.getInt("flag", 0);
        final EditText editTeacher = (EditText)findViewById(R.id.edit_teacher);
        final EditText editWeek = (EditText)findViewById(R.id.edit_week);
        final EditText editPlace = (EditText)findViewById(R.id.edit_place);
        final EditText editNumber = (EditText)findViewById(R.id.edit_number);
        final EditText editName = (EditText)findViewById(R.id.edit_name);
        editTeacher.setText(pref.getString("teacher" + flag, ""));
        editWeek.setText(pref.getString("week" + flag, ""));
        editPlace.setText(pref.getString("place" + flag, ""));
        editNumber.setText(pref.getString("number" + flag, ""));
        editName.setText(pref.getString("name" + flag, ""));
        Button btnEnsure = (Button)findViewById(R.id.btn_ensure);
        btnEnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowActivity.this, editName.getText().toString(), Toast.LENGTH_SHORT).show();
                editor = pref.edit();
                editor.putString("teacher" + flag, editTeacher.getText().toString());
                editor.putString("week" + flag, editWeek.getText().toString());
                editor.putString("place" + flag, editPlace.getText().toString());
                editor.putString("number" + flag, editNumber.getText().toString());
                editor.putString("name" + flag, editName.getText().toString());
                editor.apply();
                finish();
            }
        });

    }
    @Override
    public void onClick(View v) {

    }

}