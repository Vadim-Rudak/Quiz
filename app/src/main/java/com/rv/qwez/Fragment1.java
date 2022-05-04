package com.rv.qwez;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1.Target;

import static java.lang.Integer.parseInt;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView textView;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;


    private int chek_but=0;

    ImageView imageView;
    String otv,imgURL,ms_frend="";
    Boolean image, next_qw=false,have_btn1=true,have_btn2=true,have_btn3=true,have_btn4=true;
    public Fragment1() {
        // Required empty public constructor
        String a="";
        switch (parseInt(MainActivity.num_q.get(MainActivity.numb_qw))){
            case 1:
                a="qwest";
                break;
            case 2:
                a="qwest2";
                break;
            case 3:
                a="qwest3";
                break;
            case 4:
                a="qwest4";
                break;
            case 5:
                a="qwest5";
                break;
            case 6:
                a="qwest6";
                break;
            case 7:
                a="qwest7";
                break;
            case 8:
                a="qwest8";
                break;
            case 9:
                a="qwest9";
                break;
            case 10:
                a="qwest10";
                break;
        }


            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection(a)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {


                                    try {
                                        button1.setText(document.getString("otv" + MainActivity.num_otv.get(0)));
                                        button2.setText(document.getString("otv" + MainActivity.num_otv.get(1)));
                                        button3.setText(document.getString("otv" + MainActivity.num_otv.get(2)));
                                        button4.setText(document.getString("otv" + MainActivity.num_otv.get(3)));
                                        textView.setText(document.getString("vopros"));
                                        otv = document.getString("correct_otv");
                                        image = document.getBoolean("bool_image");
                                        imgURL = (document.getString("image"));

                                        Glide.with(getContext())
                                                .load(imgURL)
                                                .into(imageView);
                                    }catch (Exception exception){
                                    }
                                }
                            } else {
                            }
                        }
                    });

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void stat_qw(int stat_otv){
        switch (MainActivity.numb_qw){
            case 0:
                MainActivity.vop1=stat_otv;
                MainActivity.qw_v1=false;
                break;
            case 1:
                MainActivity.vop2=stat_otv;
                MainActivity.qw_v2=false;
                break;
            case 2:
                MainActivity.vop3=stat_otv;
                MainActivity.qw_v3=false;
                break;
            case 3:
                MainActivity.vop4=stat_otv;
                MainActivity.qw_v4=false;
                break;
            case 4:
                MainActivity.vop5=stat_otv;
                MainActivity.qw_v5=false;
                break;
            case 5:
                MainActivity.vop6=stat_otv;
                MainActivity.qw_v6=false;
                break;
            case 6:
                MainActivity.vop7=stat_otv;
                MainActivity.qw_v7=false;
                break;
            case 7:
                MainActivity.vop8=stat_otv;
                MainActivity.qw_v8=false;
                break;
            case 8:
                MainActivity.vop9=stat_otv;
                MainActivity.qw_v9=false;
                break;
            case 9:
                MainActivity.vop10=stat_otv;
                break;
        }
    }

    public void toolbar_btn(int b,String text_but){
        switch (b){
            case 0:
                MainActivity.btn1.setText(text_but);
                MainActivity.btn1.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn1.setClickable(false);
                break;
            case 1:
                MainActivity.btn2.setText(text_but);
                MainActivity.btn2.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn2.setClickable(false);
                break;
            case 2:
                MainActivity.btn3.setText(text_but);
                MainActivity.btn3.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn3.setClickable(false);
                break;
            case 3:
                MainActivity.btn4.setText(text_but);
                MainActivity.btn4.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn4.setClickable(false);
                break;
            case 4:
                MainActivity.btn5.setText(text_but);
                MainActivity.btn5.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn5.setClickable(false);
                break;
            case 5:
                MainActivity.btn6.setText(text_but);
                MainActivity.btn6.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn6.setClickable(false);
                break;
            case 6:
                MainActivity.btn7.setText(text_but);
                MainActivity.btn7.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn7.setClickable(false);
                break;
            case 7:
                MainActivity.btn8.setText(text_but);
                MainActivity.btn8.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn8.setClickable(false);
                break;
            case 8:
                MainActivity.btn9.setText(text_but);
                MainActivity.btn9.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn9.setClickable(false);
                break;
            case 9:
                MainActivity.btn10.setText(text_but);
                MainActivity.btn10.setTextColor(Color.parseColor("#FFFFFFFF"));
                MainActivity.btn10.setClickable(false);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_1, container, false);

        button1 = (Button) v.findViewById(R.id.button11);
        button1.setOnClickListener(this);
        button2 = (Button) v.findViewById(R.id.button12);
        button2.setOnClickListener(this);
        button3 = (Button) v.findViewById(R.id.button14);
        button3.setOnClickListener(this);
        button4 = (Button) v.findViewById(R.id.button15);
        button4.setOnClickListener(this);
        textView = (TextView) v.findViewById(R.id.textView38);
        button5 = (Button) v.findViewById(R.id.button16);
        button5.setOnClickListener(this);
        button6 = (Button) v.findViewById(R.id.button17);
        button6.setOnClickListener(this);
        button7 = (Button) v.findViewById(R.id.button18);
        button7.setOnClickListener(this);
        button8 = (Button) v.findViewById(R.id.button19);
        button8.setOnClickListener(this);
        imageView = (ImageView) v.findViewById(R.id.imageView);

        if (MainActivity.numb_qw==9){
            button6.setText("Завершить тест");
            if(MainActivity.btn10.getText().equals("✓")||MainActivity.btn10.getText().equals("X")){
                textView.setVisibility(v.GONE);
                button5.setVisibility(v.GONE);
                button7.setVisibility(v.GONE);
                button8.setVisibility(v.GONE);
                button1.setVisibility(v.GONE);
                button2.setVisibility(v.GONE);
                button3.setVisibility(v.GONE);
                button4.setVisibility(v.GONE);
                imageView.setVisibility(v.GONE);
                MainActivity.textView.setVisibility(v.GONE);
                button6.setBackgroundResource(R.drawable.bg_but);
                button6.setTextColor(Color.parseColor("#FFFFFFFF"));
            }
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                if (chek_but==0){
                    button1.setBackgroundColor(Color.parseColor("#969696"));
                    button1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=1;
                }else if (chek_but==2){
                    button2.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button2.setTextColor(Color.parseColor("#FF000000"));
                    button1.setBackgroundColor(Color.parseColor("#969696"));
                    button1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=1;
                }else if (chek_but==3){
                    button3.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button3.setTextColor(Color.parseColor("#FF000000"));
                    button1.setBackgroundColor(Color.parseColor("#969696"));
                    button1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=1;
                }else if (chek_but==4){
                    button4.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button4.setTextColor(Color.parseColor("#FF000000"));
                    button1.setBackgroundColor(Color.parseColor("#969696"));
                    button1.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=1;
                }
                break;
            case R.id.button12:
                if (chek_but==0){
                    button2.setBackgroundColor(Color.parseColor("#969696"));
                    button2.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=2;
                }else if (chek_but==1){
                    button1.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button1.setTextColor(Color.parseColor("#FF000000"));
                    button2.setBackgroundColor(Color.parseColor("#969696"));
                    button2.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=2;
                }else if (chek_but==3){
                    button3.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button3.setTextColor(Color.parseColor("#FF000000"));
                    button2.setBackgroundColor(Color.parseColor("#969696"));
                    button2.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=2;
                }else if (chek_but==4){
                    button4.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button4.setTextColor(Color.parseColor("#FF000000"));
                    button2.setBackgroundColor(Color.parseColor("#969696"));
                    button2.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=2;
                }
                break;
            case R.id.button14:
                if (chek_but==0){
                    button3.setBackgroundColor(Color.parseColor("#969696"));
                    button3.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=3;
                }else if (chek_but==2){
                    button2.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button2.setTextColor(Color.parseColor("#FF000000"));
                    button3.setBackgroundColor(Color.parseColor("#969696"));
                    button3.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=3;
                }else if (chek_but==1){
                    button1.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button1.setTextColor(Color.parseColor("#FF000000"));
                    button3.setBackgroundColor(Color.parseColor("#969696"));
                    button3.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=3;
                }else if (chek_but==4){
                    button4.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button4.setTextColor(Color.parseColor("#FF000000"));
                    button3.setBackgroundColor(Color.parseColor("#969696"));
                    button3.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=3;
                }
                break;
            case R.id.button15:
                if (chek_but==0){
                    button4.setBackgroundColor(Color.parseColor("#969696"));
                    button4.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=4;
                }else if (chek_but==2){
                    button2.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button2.setTextColor(Color.parseColor("#FF000000"));
                    button4.setBackgroundColor(Color.parseColor("#969696"));
                    button4.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=4;
                }else if (chek_but==3){
                    button3.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button3.setTextColor(Color.parseColor("#FF000000"));
                    button4.setBackgroundColor(Color.parseColor("#969696"));
                    button4.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=4;
                }else if (chek_but==1){
                    button1.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                    button1.setTextColor(Color.parseColor("#FF000000"));
                    button4.setBackgroundColor(Color.parseColor("#969696"));
                    button4.setTextColor(Color.parseColor("#FFFFFFFF"));
                    chek_but=4;
                }
                break;
            case R.id.button16:
                if (next_qw==false){
                    switch (chek_but){
                        case 1:
                            if (button1.getText().equals(otv)){
                                button1.setBackgroundColor(Color.parseColor("#4baf32"));
                                stat_qw(1);
                                toolbar_btn(MainActivity.numb_qw,"✓");
                            }else {
                                button1.setBackgroundColor(Color.parseColor("#fa4b32"));
                                //MainActivity.vop1=2;
                                stat_qw(2);
                                toolbar_btn(MainActivity.numb_qw,"X");
                            }
                            button7.setVisibility(v.GONE);
                            button8.setVisibility(v.GONE);
                            button2.setClickable(false);
                            button3.setClickable(false);
                            button4.setClickable(false);
                            button6.setVisibility(v.GONE);
                            if (MainActivity.numb_qw!=9){
                                button5.setText("Cледующий вопрос");
                            }else {
                                button5.setText("Завершить тест");
                            }
                            next_qw=true;
                            break;
                        case 2:
                            if (button2.getText().equals(otv)){
                                button2.setBackgroundColor(Color.parseColor("#4baf32"));
                                stat_qw(1);
                                toolbar_btn(MainActivity.numb_qw,"✓");
                            }else {
                                button2.setBackgroundColor(Color.parseColor("#fa4b32"));
                                stat_qw(2);
                                toolbar_btn(MainActivity.numb_qw,"X");
                            }
                            button7.setVisibility(v.GONE);
                            button8.setVisibility(v.GONE);
                            button1.setClickable(false);
                            button3.setClickable(false);
                            button4.setClickable(false);
                            button6.setVisibility(v.GONE);
                            if (MainActivity.numb_qw!=9){
                                button5.setText("Cледующий вопрос");
                            }else {
                                button5.setText("Завершить тест");
                            }
                            next_qw=true;
                            break;
                        case 3:
                            if (button3.getText().equals(otv)){
                                button3.setBackgroundColor(Color.parseColor("#4baf32"));
                                stat_qw(1);
                                toolbar_btn(MainActivity.numb_qw,"✓");
                            }else {
                                button3.setBackgroundColor(Color.parseColor("#fa4b32"));
                                stat_qw(2);
                                toolbar_btn(MainActivity.numb_qw,"X");
                            }
                            button7.setVisibility(v.GONE);
                            button8.setVisibility(v.GONE);
                            button2.setClickable(false);
                            button1.setClickable(false);
                            button4.setClickable(false);
                            button6.setVisibility(v.GONE);
                            if (MainActivity.numb_qw!=9){
                                button5.setText("Cледующий вопрос");
                            }else {
                                button5.setText("Завершить тест");
                            }
                            next_qw=true;
                            break;
                        case 4:
                            if (button4.getText().equals(otv)){
                                button4.setBackgroundColor(Color.parseColor("#4baf32"));
                                stat_qw(1);
                                toolbar_btn(MainActivity.numb_qw,"✓");
                            }else {
                                button4.setBackgroundColor(Color.parseColor("#fa4b32"));
                                stat_qw(2);
                                toolbar_btn(MainActivity.numb_qw,"X");
                            }
                            button7.setVisibility(v.GONE);
                            button8.setVisibility(v.GONE);
                            button2.setClickable(false);
                            button3.setClickable(false);
                            button1.setClickable(false);
                            button6.setVisibility(v.GONE);
                            if (MainActivity.numb_qw!=9){
                                button5.setText("Cледующий вопрос");
                            }else {
                                button5.setText("Завершить тест");
                            }
                            next_qw=true;
                            break;
                    }
                }else {
                    if (MainActivity.numb_qw!=9) {
                        if (MainActivity.qw_v2 == true && MainActivity.numb_qw < 1) {
                            MainActivity.numb_qw = 1;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 2/10");
                        } else if (MainActivity.qw_v3 == true && MainActivity.numb_qw < 2) {
                            MainActivity.numb_qw = 2;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 3/10");
                        } else if (MainActivity.qw_v4 == true && MainActivity.numb_qw < 3) {
                            MainActivity.numb_qw = 3;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 4/10");
                        } else if (MainActivity.qw_v5 == true && MainActivity.numb_qw < 4) {
                            MainActivity.numb_qw = 4;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 5/10");
                        } else if (MainActivity.qw_v6 == true && MainActivity.numb_qw < 5) {
                            MainActivity.numb_qw = 5;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 6/10");
                        } else if (MainActivity.qw_v7 == true && MainActivity.numb_qw < 6) {
                            MainActivity.numb_qw = 6;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 7/10");
                        } else if (MainActivity.qw_v8 == true && MainActivity.numb_qw < 7) {
                            MainActivity.numb_qw = 7;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 8/10");
                        } else if (MainActivity.qw_v9 == true && MainActivity.numb_qw < 8) {
                            MainActivity.numb_qw = 8;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 9/10");
                        } else if (MainActivity.qw_v10 == true && MainActivity.numb_qw < 9) {
                            MainActivity.numb_qw = 9;
                            getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                            MainActivity.textView.setText("Вопрос: 10/10");
                        }
                    }else {
                        getActivity().finish();
                        Intent intent = new Intent(getActivity(),Res.class);
                        startActivity(intent);
                        MainActivity.num_otv.clear();
                    }
                }

                break;
            case R.id.button17:
                if (MainActivity.numb_qw!=9) {
                    MainActivity.qw_v1 = false;
                    if (MainActivity.qw_v2 == true && MainActivity.numb_qw < 1) {
                        MainActivity.qw_v2 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 1;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 2/10");
                    } else if (MainActivity.qw_v3 == true && MainActivity.numb_qw < 2) {
                        MainActivity.qw_v3 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 2;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 3/10");
                    } else if (MainActivity.qw_v4 == true && MainActivity.numb_qw < 3) {
                        MainActivity.qw_v4 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 3;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 4/10");
                    } else if (MainActivity.qw_v5 == true && MainActivity.numb_qw < 4) {
                        MainActivity.qw_v5 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 4;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 5/10");
                    } else if (MainActivity.qw_v6 == true && MainActivity.numb_qw < 5) {
                        MainActivity.qw_v6 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 5;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 6/10");
                    } else if (MainActivity.qw_v7 == true && MainActivity.numb_qw < 6) {
                        MainActivity.qw_v7 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 6;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 7/10");
                    } else if (MainActivity.qw_v8 == true && MainActivity.numb_qw < 7) {
                        MainActivity.qw_v8 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 7;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 8/10");
                    } else if (MainActivity.qw_v9 == true && MainActivity.numb_qw < 8) {
                        MainActivity.qw_v9 = false;
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 8;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 9/10");
                    } else if (MainActivity.qw_v10 == true && MainActivity.numb_qw < 9) {
                        toolbar_btn(MainActivity.numb_qw, "O");
                        MainActivity.numb_qw = 9;
                        getFragmentManager().beginTransaction().replace(R.id.fr_place, new Fragment1()).commit();
                        MainActivity.textView.setText("Вопрос: 10/10");
                    }
                }else {
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(),Res.class);
                    startActivity(intent);
                    MainActivity.num_otv.clear();
                }
                break;
            case R.id.button18:
                int t=0;
                if (t!=2) {
                    if (button1.getText().equals(otv)) {
                    } else {
                        button1.setVisibility(v.GONE);
                        have_btn1=false;
                        t++;
                    }
                }
                if (t!=2) {
                    if (button2.getText().equals(otv)) {
                    } else {
                        button2.setVisibility(v.GONE);
                        have_btn2=false;
                        t++;

                    }
                }
                if (t!=2) {
                    if (button3.getText().equals(otv)) {
                    } else {
                        button3.setVisibility(v.GONE);
                        have_btn3=false;
                        t++;
                    }
                }
                if (t!=2) {
                    if (button4.getText().equals(otv)) {
                    } else {
                        button1.setVisibility(v.GONE);
                        have_btn4=false;
                        t++;
                    }
                }
                button7.setVisibility(v.GONE);
                break;
            case R.id.button19:
                MainActivity.zzz=false;
                ms_frend="";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                if (have_btn1==true){
                    ms_frend=ms_frend + " 1)" + button1.getText();
                }
                if (have_btn2==true){
                    ms_frend=ms_frend + " 2)" + button2.getText();
                }
                if (have_btn3==true){
                    ms_frend=ms_frend + " 3)" + button3.getText();
                }
                if (have_btn4==true){
                    ms_frend=ms_frend + " 4)" + button4.getText();
                }

                sendIntent.putExtra(Intent.EXTRA_TEXT, "Помоги с вопросом:"+ textView.getText()+";"+"Ответы:"+ms_frend);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"Поделиться"));
                button8.setVisibility(v.GONE);
                break;
        }
    }
}