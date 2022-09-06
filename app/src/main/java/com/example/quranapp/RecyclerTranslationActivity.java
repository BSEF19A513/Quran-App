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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class RecyclerTranslationActivity extends AppCompatActivity {
    RecyclerView translatedName;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] surahNameList;
    String language, version;
    Intent intent;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent2;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_translation);
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
                        intent = new Intent(RecyclerTranslationActivity.this, SearchActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.urdu_translation1:
                        intent = new Intent(RecyclerTranslationActivity.this,TranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        intent.putExtra("Version","Fateh Muhammad Jalandhri");
                        startActivity(intent);
                        break;
                    case R.id.urdu_translation2:
                        intent = new Intent(RecyclerTranslationActivity.this,TranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        intent.putExtra("Version","Mehmood ul Hassan");
                        startActivity(intent);
                        break;

                    case R.id.english_translation1:
                        intent = new Intent(RecyclerTranslationActivity.this,TranslationActivity.class);
                        intent.putExtra("Language","english");
                        intent.putExtra("Version","Dr Mohsin Khan");
                        startActivity(intent);
                        break;
                    case R.id.english_translation2:
                        intent = new Intent(RecyclerTranslationActivity.this,TranslationActivity.class);
                        intent.putExtra("Language","english");
                        intent.putExtra("Version","Mufti Taqi Usmani");
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });
        translatedName = findViewById(R.id.recyclerTranslatedNameView);
        intent = getIntent();
        language = intent.getStringExtra("Language");
        version = intent.getStringExtra("Version");
        DBHelper dbHelper = new DBHelper(RecyclerTranslationActivity.this);
        surahNameList = dbHelper.getTranslatedStringName(language);
        adapter = new surahNameRecyclerAdapter(surahNameList);
        layoutManager = new LinearLayoutManager(RecyclerTranslationActivity.this,LinearLayoutManager.VERTICAL,false);
        translatedName.setLayoutManager(layoutManager);
        translatedName.setAdapter(adapter);
//        translatedName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                intent = new Intent(TranslationActivity.this,TranslatedActivity.class);
//                intent.putExtra("surahName",surahNameList.get(i));
//                intent.putExtra("language",language);
//                intent.putExtra("version",version);
//                startActivity(intent);
//            }
//        });

    }
    public void surahOnClick(View view) {
        TextView surahname = view.findViewById(R.id.surahnameview);
        String name = surahname.getText().toString();
        String[] tokens = name.split(". ");
        int index = Integer.parseInt(tokens[0]);
        intent = new Intent(RecyclerTranslationActivity.this,RecyclerTranslatedActivity.class);
        intent.putExtra("surahName",surahNameList[index-1]);
        intent.putExtra("language",language);
        intent.putExtra("version",version);
        startActivity(intent);

    }

}