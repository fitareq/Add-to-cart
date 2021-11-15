package com.example.addtocarttest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1, editText2;
    Button button, button1;
    mViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText  = findViewById(R.id.title);
        editText1  = findViewById(R.id.description);
        editText2 = findViewById(R.id.price);
        button = findViewById(R.id.addToCart);
        button1 = findViewById(R.id.goToCart);



        viewModel = new ViewModelProvider(this).get(mViewModel.class);


        button.setOnClickListener(v -> {
            String title = editText.getText().toString();
            String description = editText.getText().toString();
            String price = editText.getText().toString();
            DataClass dataClass = new DataClass(title, description, price);
            viewModel.setData(dataClass);
        });
        button1.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), CartActivity.class));
        });
    }
}