package com.example.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class RecyclerSearchActivity2 extends AppCompatActivity {

    RecyclerView recyclerViewQuran;
    ArrayList<SurahModel> surahModelArrayList;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent;
    ActionBarDrawerToggle toggle;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_search2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_search:
                        intent = new Intent(RecyclerSearchActivity2.this, RecyclerSearchActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.urdu_translation1:
                        intent = new Intent(RecyclerSearchActivity2.this, TranslationActivity.class);
                        intent.putExtra("Language", "urdu");
                        intent.putExtra("Version", "Fateh Muhammad Jalandhri");
                        startActivity(intent);
                        break;
                    case R.id.urdu_translation2:
                        intent = new Intent(RecyclerSearchActivity2.this, TranslationActivity.class);
                        intent.putExtra("Language", "urdu");
                        intent.putExtra("Version", "Mehmood ul Hassan");
                        startActivity(intent);
                        break;

                    case R.id.english_translation1:
                        intent = new Intent(RecyclerSearchActivity2.this, TranslationActivity.class);
                        intent.putExtra("Language", "english");
                        intent.putExtra("Version", "Dr Mohsin Khan");
                        startActivity(intent);
                        break;
                    case R.id.english_translation2:
                        intent = new Intent(RecyclerSearchActivity2.this, TranslationActivity.class);
                        intent.putExtra("Language", "english");
                        intent.putExtra("Version", "Mufti Taqi Usmani");
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });
        Intent intent = getIntent();
        String surahName = intent.getStringExtra("surahName");
        DBHelper dbHelper = new DBHelper(RecyclerSearchActivity2.this);
        ArrayList<String> surahList = dbHelper.getSurah(surahName);
        recyclerViewQuran = findViewById(R.id.recyclerViewQuran);
        adapter = new QuranRecyclerAdapter(surahList);
        layoutManager = new LinearLayoutManager(RecyclerSearchActivity2.this,LinearLayoutManager.VERTICAL,false);
        recyclerViewQuran.setLayoutManager(layoutManager);
        recyclerViewQuran.setAdapter(adapter);
    }
    public void surahOnClick(View view)
    {
        ;
    }
}