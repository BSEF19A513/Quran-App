package com.example.quranapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class myTranslationAdapter extends ArrayAdapter<AyahModel> {

    public myTranslationAdapter(@NonNull Context context, @NonNull ArrayList<AyahModel> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AyahModel ayahModel = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.customize_translation,parent,false);
        TextView arabicText = convertView.findViewById(R.id.ArabicQuranTextView);
        arabicText.setText(ayahModel.getArabicText());
        TextView translatedText = convertView.findViewById(R.id.TranslationTextView);
        translatedText.setText(ayahModel.getUrduText());
        return convertView;
    }
}

