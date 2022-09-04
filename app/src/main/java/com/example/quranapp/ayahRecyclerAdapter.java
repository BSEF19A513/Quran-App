package com.example.quranapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ayahRecyclerAdapter extends RecyclerView.Adapter<ayahRecyclerAdapter.MyVH> {

    ArrayList<SurahModel> surahNameList;
    public ayahRecyclerAdapter(ArrayList<SurahModel> surahNameList) {
        this.surahNameList = surahNameList;
    }

    @Override
    public void onBindViewHolder(@NonNull ayahRecyclerAdapter.MyVH holder, int position) {
        holder.surahname.setText(position+1+". "+surahNameList.get(position).getSurahNameEnglish());
    }

    @NonNull
    @Override
    public ayahRecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surah_name_recycle, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public int getItemCount() {
        return surahNameList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView surahname;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            surahname = itemView.findViewById(R.id.surahNamesTextView);
        }
    }
}
