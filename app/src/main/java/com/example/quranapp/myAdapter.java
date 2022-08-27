package com.example.quranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class myAdapter extends ArrayAdapter<String> {

    public myAdapter(@NonNull Context context, @NonNull List<String> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String verse = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.quran_font,parent,false);
        TextView QuranText = convertView.findViewById(R.id.QuranTextView);
        QuranText.setText(verse);
        return convertView;
    }
}
