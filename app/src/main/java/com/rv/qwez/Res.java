package com.rv.qwez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class Res extends AppCompatActivity implements View.OnClickListener {
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10, t1,t2,t3;
    public TextView result;
    int col_p,col_e,col_n;
    Button btn;
    public static EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        col_p=col_e=col_n=0;
        init();
        setTextV();
        result();
    }

    void init(){
        textView1 =(TextView)findViewById(R.id.textView01);
        textView2 =(TextView)findViewById(R.id.textView02);
        textView3 =(TextView)findViewById(R.id.textview03);
        textView4 =(TextView)findViewById(R.id.textView04);
        textView5 =(TextView)findViewById(R.id.textView05);
        textView6 =(TextView)findViewById(R.id.textView06);
        textView7 =(TextView)findViewById(R.id.textView07);
        textView8 =(TextView)findViewById(R.id.textView08);
        textView9 =(TextView)findViewById(R.id.textView09);
        textView10 =(TextView)findViewById(R.id.textView010);
        t1 =(TextView)findViewById(R.id.res_text_correct);
        t2 =(TextView)findViewById(R.id.res_text_err);
        t3 =(TextView)findViewById(R.id.res_text_n);
        result =(TextView)findViewById(R.id.textView2);
        btn = (Button)findViewById(R.id.button13);
        btn.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editTextTextPersonName);

    }
    void text_v_vopr(TextView t,int z){
        switch (z){
            case 1:
                t.setText("✓");
                t.setTextColor(Color.parseColor("#4baf32"));
                col_p++;
                return;
            case 2:
                t.setText("X");
                t.setTextColor(Color.parseColor("#fa4b32"));
                col_e++;
                break;
            case 3:
                t.setText("O");
                t.setTextColor(Color.parseColor("#969696"));
                col_n++;
                break;
        }

    }
    void setTextV(){
        text_v_vopr(textView1,MainActivity.vop1);
        text_v_vopr(textView2,MainActivity.vop2);
        text_v_vopr(textView3,MainActivity.vop3);
        text_v_vopr(textView4,MainActivity.vop4);
        text_v_vopr(textView5,MainActivity.vop5);
        text_v_vopr(textView6,MainActivity.vop6);
        text_v_vopr(textView7,MainActivity.vop7);
        text_v_vopr(textView8,MainActivity.vop8);
        text_v_vopr(textView9,MainActivity.vop9);
        text_v_vopr(textView10,MainActivity.vop10);
        t1.setText("" + col_p);
        t2.setText("" + col_e);
        t3.setText("" + col_n);

    }
    void result(){
        result.setText("" + col_p*10);
    }

    @Override
    public void onClick(View v) {
        if (editText.getText().toString().equals("")){
        }else {
            MainActivity.addUserScore(result.getText().toString(),editText.getText().toString());
            Intent intent = new Intent(this,Start_act_qwez.class);
            startActivity(intent);
        }
    }






}