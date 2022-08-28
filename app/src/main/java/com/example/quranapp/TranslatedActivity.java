package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TranslatedActivity extends AppCompatActivity {
    Intent intent;
    ListView translatedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated);
        translatedView = findViewById(R.id.TranslatedListView);
        intent = getIntent();
        String surahName = intent.getStringExtra("surahName");
        String language = intent.getStringExtra("language");
        DBHelper dbHelper = new DBHelper(TranslatedActivity.this);
        ArrayList<AyahModel> Ayahlist = dbHelper.getTranslatedSurah(surahName,language);
        myTranslationAdapter adapter = new myTranslationAdapter(TranslatedActivity.this,Ayahlist);
        translatedView.setAdapter(adapter);

    }
}