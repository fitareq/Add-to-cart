package com.example.addtocarttest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class mAdapter extends RecyclerView.Adapter<mAdapter.mHolder> {


    private List<DataClass> dataClasses;

    public mAdapter(List<DataClass> dataClasses) {
        this.dataClasses = dataClasses;
    }

    @NonNull
    @Override
    public mHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new mHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mHolder holder, int position) {

        DataClass dataClass = dataClasses.get(position);
        holder.textView.setText(dataClass.getTitle());
        holder.textView1.setText(dataClass.getDescription());
        holder.textView2.setText(dataClass.getPrice());
    }

    @Override
    public int getItemCount() {
        return dataClasses.size();
    }

    public class mHolder extends RecyclerView.ViewHolder{

        TextView textView,textView1,textView2;
        public mHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text1);
            textView1 = itemView.findViewById(R.id.text2);
            textView2 = itemView.findViewById(R.id.text3);
        }
    }
}
