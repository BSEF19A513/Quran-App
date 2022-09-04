package com.example.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ListView surahView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        surahView = findViewById(R.id.surahView);

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
                        intent = new Intent(MainActivity2.this, SearchActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.nav_urdu:
                        intent = new Intent(MainActivity2.this,TranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        startActivity(intent);
                        break;

                    case R.id.nav_english:
                        intent = new Intent(MainActivity2.this,TranslationActivity.class);
                        intent.putExtra("Language","english");
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

//        int j =0;
        ArrayList<String> surah = new ArrayList<String>();
        for (int i = startIndex-1; i < endIndex-1; i++) {
            surah.add(quranText[i]);
        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1,surah);
        myAdapter arrayAdapter = new myAdapter(MainActivity2.this,surah);
        surahView.setAdapter(arrayAdapter);

    }
}