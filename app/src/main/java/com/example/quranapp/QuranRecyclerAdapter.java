package com.example.quranapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuranRecyclerAdapter extends RecyclerView.Adapter<QuranRecyclerAdapter.MyVH> {

    ArrayList<String> surahList;
    public QuranRecyclerAdapter(ArrayList<String> surahNameList) {
        this.surahList = surahNameList;
    }

    @Override
    public void onBindViewHolder(@NonNull QuranRecyclerAdapter.MyVH holder, int position) {
        holder.surahname.setText(surahList.get(position));
    }

    @NonNull
    @Override
    public QuranRecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quran_text_customize, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView surahname;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            surahname = itemView.findViewById(R.id.qurantextview);
        }
    }
}
