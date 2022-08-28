package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TranslationActivity extends AppCompatActivity {
    ListView translatedName;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
        translatedName = findViewById(R.id.translatedNameView);
        intent = getIntent();
        String language = intent.getStringExtra("Language");
        DBHelper dbHelper = new DBHelper(TranslationActivity.this);
        ArrayList<String> surahNameList = dbHelper.getTranslatedName(language);
        ArrayAdapter adapter = new ArrayAdapter(TranslationActivity.this, android.R.layout.simple_list_item_1,surahNameList);
        translatedName.setAdapter(adapter);
        translatedName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(TranslationActivity.this,TranslatedActivity.class);
                intent.putExtra("surahName",surahNameList.get(i));
                intent.putExtra("language",language);
                startActivity(intent);
            }
        });

    }
}