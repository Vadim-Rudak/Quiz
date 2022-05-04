package com.rv.qwez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Collections;

public class Start_act_qwez extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_act_qwez);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        Stat.states.clear();
        Stat.add_users();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                MainActivity.numb_qw=0;
                MainActivity.qw_v1=MainActivity.qw_v2=MainActivity.qw_v3=MainActivity.qw_v4=MainActivity.qw_v5=MainActivity.qw_v6=MainActivity.qw_v7=MainActivity.qw_v8=MainActivity.qw_v9=MainActivity.qw_v10=true;
                MainActivity.num_otv.clear();
                MainActivity.num_q.clear();
                MainActivity.zzz=true;

                break;
            case R.id.btn2:
                Intent intent1 = new Intent(this,Stat.class);
                startActivity(intent1);
                break;
        }
    }
}