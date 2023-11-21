package com.example.spotifyclone_coders_cave.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.adapter.Search_Tiles_Adapter;
import com.example.spotifyclone_coders_cave.databinding.ActivitySearchBinding;
import com.example.spotifyclone_coders_cave.model.Search_Browse_Tiles;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {
    ActivitySearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.searchActivityBottomNavigationView.BottomNavigationView.inflateMenu(R.menu.bot_nav_menu);
        binding.searchActivityBottomNavigationView.BottomNavigationView.setSelectedItemId(R.id.menu_search);
        binding.searchActivityBottomNavigationView.BottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    finish();
                } else if (item.getItemId() == R.id.menu_search) {
                    Toast.makeText(Search_Activity.this, "Already at Search !", Toast.LENGTH_SHORT).show();
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
        binding.searchEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Search_Input_Activity.class));
            }
        });

        populateTiles();

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

    private void populateTiles() {
        ArrayList<Search_Browse_Tiles> tiles = new ArrayList<>();
        tiles.add(new Search_Browse_Tiles(R.drawable.weekend,"Weekend"));
        tiles.add(new Search_Browse_Tiles(R.drawable.taylor,"Taylor Swift"));
        tiles.add(new Search_Browse_Tiles(R.drawable.ar_rehman,"A.R. Rehman"));
        tiles.add(new Search_Browse_Tiles(R.drawable.ed,"Ed Sherin"));
        tiles.add(new Search_Browse_Tiles(R.drawable.kk,"K.K."));
        tiles.add(new Search_Browse_Tiles(R.drawable.shaan,"Shaan"));
        tiles.add(new Search_Browse_Tiles(R.drawable.shreya,"Shreya Ghoshal"));
        tiles.add(new Search_Browse_Tiles(R.drawable.sonu,"Sonu Nigam"));
        tiles.add(new Search_Browse_Tiles(R.drawable.weekend,"Weekend"));
        tiles.add(new Search_Browse_Tiles(R.drawable.taylor,"Taylor Swift"));
        tiles.add(new Search_Browse_Tiles(R.drawable.ar_rehman,"A.R. Rehman"));
        tiles.add(new Search_Browse_Tiles(R.drawable.ed,"Ed Sherin"));
        tiles.add(new Search_Browse_Tiles(R.drawable.kk,"K.K."));
        tiles.add(new Search_Browse_Tiles(R.drawable.shaan,"Shaan"));
        tiles.add(new Search_Browse_Tiles(R.drawable.shreya,"Shreya Ghoshal"));
        tiles.add(new Search_Browse_Tiles(R.drawable.sonu,"Sonu Nigam"));
        tiles.add(new Search_Browse_Tiles(R.drawable.weekend,"Weekend"));
        tiles.add(new Search_Browse_Tiles(R.drawable.taylor,"Taylor Swift"));
        tiles.add(new Search_Browse_Tiles(R.drawable.ar_rehman,"A.R. Rehman"));
        tiles.add(new Search_Browse_Tiles(R.drawable.ed,"Ed Sherin"));
        tiles.add(new Search_Browse_Tiles(R.drawable.kk,"K.K."));
        tiles.add(new Search_Browse_Tiles(R.drawable.shaan,"Shaan"));
        tiles.add(new Search_Browse_Tiles(R.drawable.shreya,"Shreya Ghoshal"));
        tiles.add(new Search_Browse_Tiles(R.drawable.sonu,"Sonu Nigam"));



        Search_Tiles_Adapter adapter = new Search_Tiles_Adapter(Search_Activity.this, tiles);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Search_Activity.this,2);
        binding.searchExploreRv.setLayoutManager(layoutManager);
        binding.searchExploreRv.setAdapter(adapter);

    }

}