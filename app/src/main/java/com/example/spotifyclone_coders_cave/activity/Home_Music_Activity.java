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
import com.example.spotifyclone_coders_cave.adapter.Music_Main_Tiles_Adapter;
import com.example.spotifyclone_coders_cave.databinding.ActivityHomeMusicBinding;
import com.example.spotifyclone_coders_cave.model.Home_Music_Tiles_Model;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Home_Music_Activity extends AppCompatActivity {
    ActivityHomeMusicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeMusicBinding.inflate(getLayoutInflater());
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
                Intent intent = new Intent(Home_Music_Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });
        binding.headerOptionPodcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Music_Activity.this, Home_Podcasts_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });

        //populate View
        populateActivityView();

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

    private void populateActivityView() {
        ArrayList<Home_Music_Tiles_Model> tiles_list = new ArrayList<>();
        tiles_list.add(new Home_Music_Tiles_Model("popluar single","Lata Mangeshkar","o saathi re","new song of lata","1998",R.drawable.img18,R.drawable.lata));
        tiles_list.add(new Home_Music_Tiles_Model("Bollywood Central","A R Rehman","Slumdog Millionaire","new song","2006",R.drawable.img33,R.drawable.ar_rehman));
        tiles_list.add(new Home_Music_Tiles_Model("Hollywood Popular","ED Sheeran","Girl like you","best hits","2018",R.drawable.img38,R.drawable.ed));
        tiles_list.add(new Home_Music_Tiles_Model("Old Melodies","K.K.","Bheege Hoath Tere","old classical song","2001",R.drawable.img34,R.drawable.kk));
        tiles_list.add(new Home_Music_Tiles_Model("Best of Shaan","Shaan","Kabhi Kabhi","Evergreen hits","2009",R.drawable.img13,R.drawable.shaan));
        tiles_list.add(new Home_Music_Tiles_Model("Melodies","Shreya Ghoshal","Raat akeli hai","from superhit movie","2002",R.drawable.img35,R.drawable.shreya));
        tiles_list.add(new Home_Music_Tiles_Model("King of Music","Sonu Nigam","Sonyio","Hit of year 1999","1999",R.drawable.img1,R.drawable.sonu));
        tiles_list.add(new Home_Music_Tiles_Model("Hollywood's Most Listened","Taylor Swift","Blank Space","Most played song of the year","2017",R.drawable.img26,R.drawable.taylor));
        tiles_list.add(new Home_Music_Tiles_Model("Bedroom Hits","Weekend","Call out my name","Relaxing music","2020",R.drawable.img15,R.drawable.weekend));

        Music_Main_Tiles_Adapter adapter = new Music_Main_Tiles_Adapter(Home_Music_Activity.this, tiles_list);
        binding.musicOptionRv.setLayoutManager(new LinearLayoutManager(this));
        binding.musicOptionRv.setAdapter(adapter);

    }
}
