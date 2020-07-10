package com.androidfundamentals.dietconsultant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.MyViewHolder> {

    private List<Diet> dietList;
    private  ClickListenerCallback callback;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private View view;
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            this.view = v;
            textView = v.findViewById(R.id.diet_name);
        }
    }

    public DietAdapter(List<Diet> dietList, ClickListenerCallback callback) {
        this.dietList = dietList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public DietAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(dietList.get(position).getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onDietClick(dietList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dietList.size();
    }
}