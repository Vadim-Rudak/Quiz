package com.rv.qwez;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.rv.qwez.R;
import com.rv.qwez.Stat_res;

import java.util.List;


import static androidx.core.content.ContextCompat.startActivity;

public class StateAdapter  extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Stat_res> Stats;
    private Context context;
    private Activity activity;

    StateAdapter(Activity activity, Context context, List<Stat_res> Stats) {
        this.activity = activity;
        this.Stats = Stats;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        Stat_res st = Stats.get(position);
        holder.nameView.setText(st.getName());
        holder.resultView.setText(st.getResult());
        holder.main_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stat st = new Stat();
                st.ff(position);
                Intent intent = new Intent(context, Stat.class);
                activity.finish();
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Stats.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, resultView;
        LinearLayout main_item;
        ViewHolder(View view){
            super(view);

            nameView = (TextView) view.findViewById(R.id.name);
            resultView = (TextView) view.findViewById(R.id.result);
            main_item = (LinearLayout) view.findViewById(R.id.main_item);
        }

    }
}