package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class TranslatedActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated);
        intent = getIntent();
        String surahName = intent.getStringExtra("surahName");
        String language = intent.getStringExtra("language");
        DBHelper dbHelper = new DBHelper(TranslatedActivity.this);
        ArrayList<AyahModel> Ayahlist = dbHelper.getTranslatedSurah(surahName,language);

    }
}