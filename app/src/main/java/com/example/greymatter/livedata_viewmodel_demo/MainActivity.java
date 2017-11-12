package com.example.greymatter.livedata_viewmodel_demo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CounterViewModel userViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        count = findViewById(R.id.count);
        userViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                count.setText(s);
            }
        });
    }
}
