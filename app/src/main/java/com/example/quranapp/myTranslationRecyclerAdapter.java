package com.example.quranapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myTranslationRecyclerAdapter extends RecyclerView.Adapter<myTranslationRecyclerAdapter.MyVH> {

    ArrayList<AyahModel> ayahList = new ArrayList<AyahModel>();
    public myTranslationRecyclerAdapter(ArrayList<AyahModel> ayahList) {
        this.ayahList = ayahList;
    }

    @NonNull
    @Override
    public myTranslationRecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customize_translation, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myTranslationRecyclerAdapter.MyVH holder, int position) {
        holder.arabicText.setText(ayahList.get(position).getArabicText());
        holder.translatedText.setText(ayahList.get(position).getUrduText());
    }

    @Override
    public int getItemCount() {
        return ayahList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView arabicText,translatedText;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            arabicText = itemView.findViewById(R.id.ArabicQuranTextView);
            translatedText = itemView.findViewById(R.id.TranslationTextView);
        }
    }
}
