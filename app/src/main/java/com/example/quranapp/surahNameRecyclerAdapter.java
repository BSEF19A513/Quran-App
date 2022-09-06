package com.example.quranapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class surahNameRecyclerAdapter extends RecyclerView.Adapter<surahNameRecyclerAdapter.MyVH> {

    String[] surahNameList;
    public surahNameRecyclerAdapter(String[] surahName) {
        this.surahNameList = surahName;
    }

    @NonNull
    @Override
    public surahNameRecyclerAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surah_name_customize, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull surahNameRecyclerAdapter.MyVH holder, int position) {
        holder.surahname.setText(position+1+". "+surahNameList[position]);
    }

    @Override
    public int getItemCount() {
        return surahNameList.length;
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView surahname;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            surahname = itemView.findViewById(R.id.surahnameview);
        }
    }
}
