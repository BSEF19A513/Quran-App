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

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class RecyclerActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);

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
                        intent = new Intent(RecyclerActivity2.this, RecyclerSearchActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.urdu_translation1:
                        intent = new Intent(RecyclerActivity2.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        intent.putExtra("Version","Fateh Muhammad Jalandhri");
                        startActivity(intent);
                        break;
                    case R.id.urdu_translation2:
                        intent = new Intent(RecyclerActivity2.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        intent.putExtra("Version","Mehmood ul Hassan");
                        startActivity(intent);
                        break;

                    case R.id.english_translation1:
                        intent = new Intent(RecyclerActivity2.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","english");
                        intent.putExtra("Version","Dr Mohsin Khan");
                        startActivity(intent);
                        break;
                    case R.id.english_translation2:
                        intent = new Intent(RecyclerActivity2.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","english");
                        intent.putExtra("Version","Mufti Taqi Usmani");
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });

        QuranArabicText quranObj = new QuranArabicText();
        String[] quranText=quranObj.QuranArabicText;
        Intent intent = getIntent();
        int startIndex = intent.getIntExtra("startIndex",0);
        int endIndex = intent.getIntExtra("endIndex",0);

        ArrayList<String> surah = new ArrayList<String>();
        for (int i = startIndex-1; i < endIndex-1; i++) {
            surah.add(quranText[i]);
        }

        recyclerView = findViewById(R.id.recyclerViewAyah);
        adapter = new QuranRecyclerAdapter(surah);
        layoutManager = new LinearLayoutManager(RecyclerActivity2.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}