package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }

    public void listBtnOnClick(View view) {
        Intent intent = new Intent(SelectionActivity.this,ChoiceActivity.class);
        intent.putExtra("view","listview");
        startActivity(intent);
    }

    public void recyclerBtnOnClick(View view) {
        Intent intent = new Intent(SelectionActivity.this,ChoiceActivity.class);
        intent.putExtra("view","recyclerview");
        startActivity(intent);
    }
}