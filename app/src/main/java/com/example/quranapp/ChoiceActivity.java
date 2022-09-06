package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoiceActivity extends AppCompatActivity {
    String views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Intent intent = getIntent();
        views = intent.getStringExtra("view");

    }

    public void parahOnClick(View view) {
        Intent intent1;
        if(views.equals("listview"))
        {
            intent1 = new Intent(ChoiceActivity.this,MainActivity.class);
            intent1.putExtra("recite","parah");
            startActivity(intent1);
        }
        else if(views.equals("recyclerview"))
        {
            intent1 = new Intent(ChoiceActivity.this,RecyclerActivity.class);
            intent1.putExtra("recite","parah");
            startActivity(intent1);
        }
    }

    public void reciteSurahOnClick(View view) {
        Intent intent1;
        if(views.equals("listview"))
        {
            intent1 = new Intent(ChoiceActivity.this,MainActivity.class);
            intent1.putExtra("recite","surah");
            startActivity(intent1);
        }
        else if(views.equals("recyclerview"))
        {
            intent1 = new Intent(ChoiceActivity.this,RecyclerActivity.class);
            intent1.putExtra("recite","surah");
            startActivity(intent1);
        }
    }
}