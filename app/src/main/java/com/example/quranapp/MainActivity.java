package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView surahNamesView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surahNamesView = findViewById(R.id.surahNamesView);
        QDH obj = new QDH();
        String[] surahNames=obj.englishSurahNames;

        int[] ssp = obj.SSP;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,surahNames);
        surahNamesView.setAdapter(arrayAdapter);
        surahNamesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d("======", "onItemClick: "+ssp.length+" length");
                int startIndex = ssp[i];
                int endIndex;
                if(i+1>=ssp.length)
                    endIndex = 6349;
                else
                    endIndex = ssp[i+1];

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("startIndex",startIndex);
                intent.putExtra("endIndex",endIndex);
                startActivity(intent);

            }
        });

    }
}