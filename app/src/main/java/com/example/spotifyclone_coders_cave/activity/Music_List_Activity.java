package com.example.spotifyclone_coders_cave.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.adapter.Music_List_Rv_Adapter;
import com.example.spotifyclone_coders_cave.databinding.ActivityMusicListBinding;
import com.example.spotifyclone_coders_cave.model.Music_List_Model;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Music_List_Activity extends AppCompatActivity {
    ActivityMusicListBinding binding;
    int recImage;
    String recTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getDataFromIntent();        //getting data

        binding.songListActivityBottomNavigationView.BottomNavigationView.inflateMenu(R.menu.bot_nav_menu);
        binding.songListActivityBottomNavigationView.BottomNavigationView.setSelectedItemId(R.id.menu_home);
        binding.songListActivityBottomNavigationView.BottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();
                } else if (item.getItemId() == R.id.menu_search) {
                    Intent intent = new Intent(getApplicationContext(), Search_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();
                } else if (item.getItemId() == R.id.menu_library) {
                    Intent intent = new Intent(getApplicationContext(), Library_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();
                } else if (item.getItemId() == R.id.menu_premium) {
                    Intent intent = new Intent(getApplicationContext(), Premium_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();
                }
                return true;
            }
        });

        //populate view
        Glide.with(Music_List_Activity.this).load(recImage).into(binding.posterIv);
        binding.coverTextTv.setText(recTitleText);
        binding.playlistTimeDurationTv.setText("36:15");
        populateTilesRv();

        //on back pressed
        binding.backBtnIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });


    }

    // creating data for music tiles
    private void populateTilesRv() {
        ArrayList<Music_List_Model> tileList = new ArrayList<>();
        tileList.add(new Music_List_Model(recImage,"Song 1","02:56"));
        tileList.add(new Music_List_Model(recImage,"Song 2","05:06"));
        tileList.add(new Music_List_Model(recImage,"Song 3","02:19"));
        tileList.add(new Music_List_Model(recImage,"Song 4","03:52"));
        tileList.add(new Music_List_Model(recImage,"Song 5","05:59"));
        tileList.add(new Music_List_Model(recImage,"Song 6","02:50"));
        tileList.add(new Music_List_Model(recImage,"Song 7","06:36"));
        tileList.add(new Music_List_Model(recImage,"Song 8","04:46"));
        tileList.add(new Music_List_Model(recImage,"Song 9","07:06"));
        tileList.add(new Music_List_Model(recImage,"Song 10","05:26"));
        tileList.add(new Music_List_Model(recImage,"Song 11","01:46"));
        tileList.add(new Music_List_Model(recImage,"Song 12","08:50"));
        tileList.add(new Music_List_Model(recImage,"Song 13","05:52"));
        tileList.add(new Music_List_Model(recImage,"Song 14","04:16"));


        Music_List_Rv_Adapter adapter = new Music_List_Rv_Adapter(Music_List_Activity.this, tileList);
        binding.songsRv.setLayoutManager(new LinearLayoutManager(this));
        binding.songsRv.setAdapter(adapter);

    }

    private void getDataFromIntent() {
        recImage = getIntent().getIntExtra("cover_image",0);
        recTitleText = getIntent().getStringExtra("cover_text");
    }
}