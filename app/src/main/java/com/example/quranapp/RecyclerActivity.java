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
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent;
    String recite;
    int[] ssp,psp;
    ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

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
                        intent = new Intent(RecyclerActivity.this, RecyclerSearchActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.urdu_translation1:
                        intent = new Intent(RecyclerActivity.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        intent.putExtra("Version","Fateh Muhammad Jalandhri");
                        startActivity(intent);
                        break;
                    case R.id.urdu_translation2:
                        intent = new Intent(RecyclerActivity.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        intent.putExtra("Version","Mehmood ul Hassan");
                        startActivity(intent);
                        break;

                    case R.id.english_translation1:
                        intent = new Intent(RecyclerActivity.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","english");
                        intent.putExtra("Version","Dr Mohsin Khan");
                        startActivity(intent);
                        break;
                    case R.id.english_translation2:
                        intent = new Intent(RecyclerActivity.this,RecyclerTranslationActivity.class);
                        intent.putExtra("Language","english");
                        intent.putExtra("Version","Mufti Taqi Usmani");
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });
        recyclerView = findViewById(R.id.recylerViewSurah);
        Intent intent = getIntent();
        recite = intent.getStringExtra("recite");
        if(recite.equals("surah"))
        {
            QDH obj = new QDH();
            String[] surahNames=obj.englishSurahNames;

            ssp = obj.SSP;
            adapter = new surahNameRecyclerAdapter(surahNames);
            layoutManager = new LinearLayoutManager(RecyclerActivity.this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        else if(recite.equals("parah"))
        {
            QDH obj = new QDH();
            String[] surahNames=obj.englishParahName;

            psp = obj.PSP;
            adapter = new surahNameRecyclerAdapter(surahNames);
            layoutManager = new LinearLayoutManager(RecyclerActivity.this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

    }
    public void surahOnClick(View view) {
        if(recite.equals("surah"))
        {
            TextView surahname = view.findViewById(R.id.surahnameview);
            String name = surahname.getText().toString();
            String[] tokens = name.split(". ");
            int index = Integer.parseInt(tokens[0]);
            int startIndex = ssp[index-1];
            int endIndex;
            if(index>=ssp.length)
                endIndex = 6349;
            else
                endIndex = ssp[index];
            Intent intent = new Intent(RecyclerActivity.this,RecyclerActivity2.class);
            intent.putExtra("startIndex",startIndex);
            intent.putExtra("endIndex",endIndex);
            startActivity(intent);
        }
        else if(recite.equals("parah"))
        {
            TextView parahname = view.findViewById(R.id.surahnameview);
            String name = parahname.getText().toString();
            String[] tokens = name.split(". ");
            int index = Integer.parseInt(tokens[0]);
            int startIndex = psp[index-1];
            int endIndex;
            if(index>=psp.length)
                endIndex = 6349;
            else
                endIndex = psp[index];
            Intent intent = new Intent(RecyclerActivity.this,RecyclerActivity2.class);
            intent.putExtra("startIndex",startIndex);
            intent.putExtra("endIndex",endIndex);
            startActivity(intent);
        }
    }
}