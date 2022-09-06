package com.example.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTranslatedActivity extends AppCompatActivity {
    Intent intent;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView translatedView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent2;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_translated);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_search:
                        intent2 = new Intent(RecyclerTranslatedActivity.this, RecyclerSearchActivity.class);
                        startActivity(intent2);
                        break;


                    case R.id.urdu_translation1:
                        intent2 = new Intent(RecyclerTranslatedActivity.this,RecyclerTranslationActivity.class);
                        intent2.putExtra("Language","urdu");
                        intent2.putExtra("Version","Fateh Muhammad Jalandhri");
                        startActivity(intent2);
                        break;
                    case R.id.urdu_translation2:
                        intent2 = new Intent(RecyclerTranslatedActivity.this,RecyclerTranslationActivity.class);
                        intent2.putExtra("Language","urdu");
                        intent2.putExtra("Version","Mehmood ul Hassan");
                        startActivity(intent2);
                        break;

                    case R.id.english_translation1:
                        intent2 = new Intent(RecyclerTranslatedActivity.this,RecyclerTranslationActivity.class);
                        intent2.putExtra("Language","english");
                        intent2.putExtra("Version","Dr Mohsin Khan");
                        startActivity(intent2);
                        break;
                    case R.id.english_translation2:
                        intent2 = new Intent(RecyclerTranslatedActivity.this,RecyclerTranslationActivity.class);
                        intent2.putExtra("Language","english");
                        intent2.putExtra("Version","Mufti Taqi Usmani");
                        startActivity(intent2);
                        break;

                }

                return true;
            }
        });
        translatedView = findViewById(R.id.TranslatedRecyclerView);
        intent = getIntent();
        String surahName = intent.getStringExtra("surahName");
        String language = intent.getStringExtra("language");
        String version = intent.getStringExtra("version");
        DBHelper dbHelper = new DBHelper(RecyclerTranslatedActivity.this);
        ArrayList<AyahModel> Ayahlist = dbHelper.getTranslatedSurah(surahName,language,version);
        adapter = new myTranslationRecyclerAdapter(Ayahlist);
        layoutManager = new LinearLayoutManager(RecyclerTranslatedActivity.this,LinearLayoutManager.VERTICAL,false);
        translatedView.setLayoutManager(layoutManager);
        translatedView.setAdapter(adapter);

    }
}