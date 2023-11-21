package com.example.spotifyclone_coders_cave.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.spotifyclone_coders_cave.R;
import com.example.spotifyclone_coders_cave.adapter.Artist_Cover_Image_And_Name_Adapter;
import com.example.spotifyclone_coders_cave.adapter.Cover_Image_And_Name_Adapter;
import com.example.spotifyclone_coders_cave.databinding.ActivityMainBinding;
import com.example.spotifyclone_coders_cave.model.Album_Cover_info;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        populateCharts();
        populatePopularRadio();
        populateHits();
        populateUniquelyYours();
        populatePopularAlbum();
        populateIndiasBest();
        populatePopularArtists();

        //about bottom navigation view
        binding.mainActivityBottomNavigationView.BottomNavigationView.inflateMenu(R.menu.bot_nav_menu);
        binding.mainActivityBottomNavigationView.BottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home){
                    Toast.makeText(MainActivity.this, "Already at Home !", Toast.LENGTH_SHORT).show();
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
        binding.headerOptionMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home_Music_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });
        binding.headerOptionPodcasts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Home_Podcasts_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });
    }

    private void populatePopularArtists() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.ar_rehman, "AR Rehman"));
        cover_infoList.add(new Album_Cover_info(R.drawable.ed, "Ed Sheeran"));
        cover_infoList.add(new Album_Cover_info(R.drawable.kk, "K.K."));
        cover_infoList.add(new Album_Cover_info(R.drawable.lata, "Lata Mangeshkar"));
        cover_infoList.add(new Album_Cover_info(R.drawable.shaan, "Shaan"));
        cover_infoList.add(new Album_Cover_info(R.drawable.shreya, "Shreya Goshal"));
        cover_infoList.add(new Album_Cover_info(R.drawable.sonu, "Sonu"));
        cover_infoList.add(new Album_Cover_info(R.drawable.taylor, "Taylor Swift"));
        cover_infoList.add(new Album_Cover_info(R.drawable.weekend, "The Weekend"));

        Artist_Cover_Image_And_Name_Adapter adapter = new Artist_Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityPopularArtistsRv.setLayoutManager(chartsManager);
        binding.mainActivityPopularArtistsRv.setAdapter(adapter);
    }

    private void populateIndiasBest() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.img36, "\"Desi Boyz\" from the movie \"Desi Boyz\" (2011)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img37, "\"Tere Naal Ishqa\" from the movie \"Bodyguard\" (2011)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img38, "\"Party All Night\" from the movie \"Race 2\" (2013)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img39, "\"High Heels\" from the movie \"Ki & Ka\" (2016)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img40, "\"Saturday Night\" from the movie \"Fever\" (2016)"));

        Cover_Image_And_Name_Adapter adapter = new Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityIndiasBestRv.setLayoutManager(chartsManager);
        binding.mainActivityIndiasBestRv.setAdapter(adapter);
    }

    private void populatePopularAlbum() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.img28, "\"Get Up (I Feel Like Being a) Sex Machine (Part 1)\" by James Brown (1970)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img29, "\"One Nation Under a Groove (Part 1)\" by Funkadelic (1978)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img30, "\"We Are Family\" by Sister Sledge (1979)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img31, "\"Boogie Oogie Oogie\" by A Taste of Honey (1978)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img32, "\"Rock Steady\" by Aretha Franklin (1979)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img33, "\"I'm Your Boogie Man\" by KC and the Sunshine Band (1976)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img34, "\"Rapper's Delight\" by The Sugarhill Gang (1979)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img35, "\"The Message\" by Grandmaster Flash and the Furious Five (1982)"));

        Cover_Image_And_Name_Adapter adapter = new Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityPopularAlbumRv.setLayoutManager(chartsManager);
        binding.mainActivityPopularAlbumRv.setAdapter(adapter);
    }

    private void populateUniquelyYours() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.img21, "\"Low Rider\" by War (1975)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img22, "\"Shining Star\" by Earth, Wind and Fire (1978)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img23, "\"Theme from 'Shaft'\" by Isaac Hayes (1970)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img24, "\"Got to Give It Up - Pt. 1\" by Marvin Gaye (1977)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img25, "\"Got to Give It Up - Pt. 1\" by Marvin Gaye (1977)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img26, "\"Cold Sweat\" by James Brown (1967)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img27, "\"I Feel Like Being a Sex Machine\" by James Brown (1968)"));

        Cover_Image_And_Name_Adapter adapter = new Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityUniquelyYoursRv.setLayoutManager(chartsManager);
        binding.mainActivityUniquelyYoursRv.setAdapter(adapter);
    }

    private void populateHits() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.img13, "She's a Bad Mama Jama (She's Built, She's Stacked), by Carl Carlton (1975)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img14, "\"Thank You (Falettinme Be Mice Elf Agin)\" by Sly and the Family Stone (1969)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img15, "\"Word Up\" by Cameo (1983)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img16, "\"Jungle Boogie\" by Kool and the Gang (1975)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img17, "\"Papa's Got a Brand New Bag\" by James Brown (1965)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img18, "\"Don't Stop 'Til You Get Enough\" by Michael Jackson (1979)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img19, "\"Higher Ground\" by Stevie Wonder (1973)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img20, "\"Superstition\" by Stevie Wonder (1972)"));

        Cover_Image_And_Name_Adapter adapter = new Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityHitsDifferentRv.setLayoutManager(chartsManager);
        binding.mainActivityHitsDifferentRv.setAdapter(adapter);
    }

    private void populatePopularRadio() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.img7, "Happy minds"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img8, "Flash Light, by Parliament (1977)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img9, "Super Freak, by Rick James (1981)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img10, "Chameleon, by Herbie Hancock (1973)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img11, "Brick House, by Commodores (1976)"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img12, "Get Down on It, by Kool and the Gang (1979)"));

        Cover_Image_And_Name_Adapter adapter = new Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityPopularRadioRv.setLayoutManager(chartsManager);
        binding.mainActivityPopularRadioRv.setAdapter(adapter);
    }

    private void populateCharts() {
        ArrayList<Album_Cover_info> cover_infoList = new ArrayList<>();
        cover_infoList.add(new Album_Cover_info(R.drawable.img1, "Party anthem"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img2, "Blur memories"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img3, "Monkey dance"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img4, "Monkey party"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img5, "Wild club"));
        cover_infoList.add(new Album_Cover_info(R.drawable.img6, "Wild party"));

        Cover_Image_And_Name_Adapter adapter = new Cover_Image_And_Name_Adapter(MainActivity.this, cover_infoList);
        RecyclerView.LayoutManager chartsManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL, false);
        binding.mainActivityChartsRv.setLayoutManager(chartsManager);
        binding.mainActivityChartsRv.setAdapter(adapter);

    }
}