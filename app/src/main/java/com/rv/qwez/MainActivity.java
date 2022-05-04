package com.rv.qwez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment = null;

    public static Button btn1;
    public static Button btn2;
    public static Button btn3;
    public static Button btn4;
    public static Button btn5;
    public static Button btn6;
    public static Button btn7;
    public static Button btn8;
    public static Button btn9;
    public static Button btn10;
    public static TextView textView;
    public static int vop1=3;
    public static int vop2=3;
    public static int vop3=3;
    public static int vop4=3;
    public static int vop5=3;
    public static int vop6=3;
    public static int vop7=3;
    public static int vop8=3;
    public static int vop9=3;
    public static int vop10=3;

    public static int numb_qw=0;

    public static boolean qw_v1=true, qw_v2=true, qw_v3=true, qw_v4=true, qw_v5=true, qw_v6=true, qw_v7=true, qw_v8=true, qw_v9=true, qw_v10=true;


    public static boolean zzz=true;
    static ArrayList<String> num_q = new ArrayList<>();
    static ArrayList<String> num_otv = new ArrayList<>();
//    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
//
//            }
//        });
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        iniz();
        num_q.add("1");
        num_q.add("2");
        num_q.add("3");
        num_q.add("4");
        num_q.add("5");
        num_q.add("6");
        num_q.add("7");
        num_q.add("8");
        num_q.add("9");
        num_q.add("10");
        Collections.shuffle(num_q);
        num_otv.add("1");
        num_otv.add("2");
        num_otv.add("3");
        num_otv.add("4");
        Collections.shuffle(num_otv);

    }

    void iniz(){
        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.num_vopr);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (zzz==true){
            fragment = new Fragment1();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fr_place,fragment);
            ft.commit();
            vop1=vop2=vop3=vop4=vop5=vop6=vop7=vop8=vop9=vop10=3;
            textView.setText("Вопрос: 1/10");
        }else {
        }
    }

    public static void addUserScore (String dd,String fd) {

        String userName = dd;

        if(!userName.equals("")) {

            Map<String, Object> user1 = new HashMap<>();
            user1.put("username", fd);
            user1.put("score", dd);

            FirebaseFirestore db = FirebaseFirestore.getInstance();

            db.collection("users")
                    .add(user1)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("WRITING SCORE ", "Failed");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("WRITING SCORE ", "Failed");
                }
            });
        } else {
        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                numb_qw=0;
                fragment = new Fragment1();
                textView.setText("Вопрос: 1/10");
                break;
            case R.id.button2:
                numb_qw=1;
                fragment = new Fragment1();
                textView.setText("Вопрос: 2/10");
                break;
            case R.id.button3:
                numb_qw=2;
                fragment = new Fragment1();
                textView.setText("Вопрос: 3/10");
                break;
            case R.id.button4:
                numb_qw=3;
                fragment = new Fragment1();
                textView.setText("Вопрос: 4/10");
                break;
            case R.id.button5:
                numb_qw=4;
                fragment = new Fragment1();
                textView.setText("Вопрос: 5/10");
                break;
            case R.id.button6:
                numb_qw=5;
                fragment = new Fragment1();
                textView.setText("Вопрос: 6/10");
                break;
            case R.id.button7:
                numb_qw=6;
                fragment = new Fragment1();
                textView.setText("Вопрос: 7/10");
                break;
            case R.id.button8:
                numb_qw=7;
                fragment = new Fragment1();
                textView.setText("Вопрос: 8/10");
                break;
            case R.id.button9:
                numb_qw=8;
                fragment = new Fragment1();
                textView.setText("Вопрос: 9/10");
                break;
            case R.id.button10:
                numb_qw=9;
                fragment = new Fragment1();
                textView.setText("Вопрос: 10/10");
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fr_place,fragment);
        ft.commit();
    }
}