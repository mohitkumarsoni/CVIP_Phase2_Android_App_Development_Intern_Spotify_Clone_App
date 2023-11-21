package com.example.spotifyclone_coders_cave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.databinding.ActivitySearchInputBinding;

public class Search_Input_Activity extends AppCompatActivity {
    ActivitySearchInputBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backBtnIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
                finish();
            }
        });
    }
}