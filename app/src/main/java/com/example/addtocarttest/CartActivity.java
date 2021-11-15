package com.example.addtocarttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    mViewModel viewModel;
    RecyclerView recyclerView;
    mAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        viewModel = new ViewModelProvider(this).get(mViewModel.class);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        viewModel.getData().observe(this, new Observer<List<DataClass>>() {
            @Override
            public void onChanged(List<DataClass> dataClasses) {
                adapter = new mAdapter(dataClasses);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}