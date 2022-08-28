package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahActivity extends AppCompatActivity {
    ListView surahListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        surahListView = findViewById(R.id.SurahListView);
        Intent intent = getIntent();
        String SurahName = intent.getStringExtra("SurahName");
        DBHelper dbHelper = new DBHelper(SurahActivity.this);
        ArrayList<String> surahList = dbHelper.getSurah(SurahName);
        myAdapter adapter = new myAdapter(SurahActivity.this,surahList);
        surahListView.setAdapter(adapter);
    }
}