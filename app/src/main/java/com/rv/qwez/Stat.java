package com.rv.qwez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.math.Stats;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import static com.google.firebase.firestore.Query.Direction.DESCENDING;

public class Stat extends AppCompatActivity {

    static ArrayList<Stat_res> states = new ArrayList<Stat_res>();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        StateAdapter adapter = new StateAdapter(Stat.this,this, states);
        recyclerView.setAdapter(adapter);
        onResume();

    }

    public static void add_users(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .orderBy("score", DESCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("READING ALL", document.getId() + " => " + document.getData());


                                Stat_res sdf = new Stat_res(document.get("username").toString(), document.get("score").toString(), document.getId());
                                states.add(sdf);

                            }

                        } else {
                            Log.d("READING ALL", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
    public void ff(int pos){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(states.get(pos).getId()).delete();
        states.remove(pos);
    }

}