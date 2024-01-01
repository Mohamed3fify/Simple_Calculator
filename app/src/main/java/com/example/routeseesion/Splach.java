package com.example.routeseesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.routeseesion.databinding.ActivityCalculatorBinding;
import com.example.routeseesion.databinding.ActivityMainBinding;
import com.example.routeseesion.databinding.ActivitySplachBinding;

public class Splach extends AppCompatActivity  {
   
   ActivitySplachBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySplachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.calculatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Splach.this, Calculator.class);
                startActivity(intent);


            }
        });



    }


    }
