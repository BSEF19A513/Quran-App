package com.example.quranapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    EditText searchText;
    ListView surahNameView;
    ArrayList<SurahModel> surahModelArrayList;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Intent intent;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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
                        intent = new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.nav_urdu:
                        intent = new Intent(SearchActivity.this,TranslationActivity.class);
                        intent.putExtra("Language","urdu");
                        startActivity(intent);
                        break;

                    case R.id.nav_english:
                        intent = new Intent(SearchActivity.this,TranslationActivity.class);
                        intent.putExtra("Language","english");
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });

        DBHelper dbHelper = new DBHelper(SearchActivity.this);
        searchText = findViewById(R.id.searchText);
        surahNameView = findViewById(R.id.surahNameView);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                   surahModelArrayList = dbHelper.getAllSurahs(searchText.getText().toString());
                   myQuranAdapter QuranAdapter = new myQuranAdapter(SearchActivity.this,surahModelArrayList);
                   surahNameView.setAdapter(QuranAdapter);
                   surahNameView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                           Intent intent = new Intent(SearchActivity.this,SurahActivity.class);
                           intent.putExtra("SurahName",surahModelArrayList.get(i).getSurahNameEnglish());
                           startActivity(intent);
                       }
                   });
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }
}