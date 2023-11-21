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

import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.adapter.Podcast_Main_Tiles_Adapter;
import com.example.spotifyclone_coders_cave.databinding.ActivityHomePodcastsBinding;
import com.example.spotifyclone_coders_cave.model.Home_Podcasts_Tiles_Model;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Home_Podcasts_Activity extends AppCompatActivity {
    ActivityHomePodcastsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePodcastsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //about bottom navigation view
        binding.mainActivityBottomNavigationView.BottomNavigationView.inflateMenu(R.menu.bot_nav_menu);
        binding.mainActivityBottomNavigationView.BottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home){
                    Toast.makeText(getApplicationContext(), "Already at Home !", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.menu_search) {
                    Intent intent = new Intent(getApplicationContext(), Search_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0); //0 for no animation
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

        //about header options
        binding.headerOptionAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Podcasts_Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });
        binding.headerOptionMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Podcasts_Activity.this ,Home_Music_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });

        //populating views
        populatePodcastTiles();

        //on pressing back button
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

    private void populatePodcastTiles() {
        ArrayList<Home_Podcasts_Tiles_Model> podList = new ArrayList<>();
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod1,"Grow your Channel", "Podcast with Dholu", "Listen and know how to grow your channel organically", "06:21"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod2,"Know How to Solve Problem", "#89 Podcast by Coder Caves", "Train your mind to solve some of biggest problems in life", "15:32"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod3,"Best Tips To Prank Friends", "By RJ Naved", "Enjoy your time listening podcast", "07:56"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod4,"Stay Single Forever", "Tips by ShantaBai", "Listen to know what happened with ShantaBai", "04:20"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod5,"The Daily Rant", "#66", "They are not dead, English Horror Stories", "11:32"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod6,"The Architect Story", "Do's & Dont's for Architect", "Things you should avoid as an architect", "08:51"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod7,"Podcast With Steve", "Travel world and get paid", "Learn how you can earn while traveling, this can be your life changing podcast.", "1:21:29"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod8,"The Millionaire Practice", "#147 hosted by: Rachel Rodgers FT Ash Cash", "True Spiritual Beliefs That Will Make You Millionaire", "45:06"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod9,"Is a Youtube Podcast Worth it", "#97", "Podcast with Angela Kelly Smith", "50:44"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod10,"Manage Files In Every Format", "Keep files in styles", "Learn to manage every file in your device", "07:55"));
        podList.add(new Home_Podcasts_Tiles_Model(R.drawable.pod11,"Vibe With Friends", "2 Cafe + Tea Cookies", "How not to give someone bad vibes", "04:22"));


        Podcast_Main_Tiles_Adapter adapter = new Podcast_Main_Tiles_Adapter(Home_Podcasts_Activity.this, podList);
        binding.podcastsOptionRv.setLayoutManager(new LinearLayoutManager(this));
        binding.podcastsOptionRv.setAdapter(adapter);

    }
}