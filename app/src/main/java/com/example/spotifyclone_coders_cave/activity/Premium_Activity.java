package com.example.spotifyclone_coders_cave.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.databinding.ActivityPremiumBinding;
import com.google.android.material.navigation.NavigationBarView;

public class Premium_Activity extends AppCompatActivity {
    ActivityPremiumBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPremiumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.premiumActivityBottomNavigationView.BottomNavigationView.inflateMenu(R.menu.bot_nav_menu);
        binding.premiumActivityBottomNavigationView.BottomNavigationView.setSelectedItemId(R.id.menu_premium);
        binding.premiumActivityBottomNavigationView.BottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
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
                    Toast.makeText(Premium_Activity.this, "Already at Library !", Toast.LENGTH_SHORT).show();
                }
                return true;
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
}