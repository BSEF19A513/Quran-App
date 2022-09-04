package com.example.quranapp;


import static android.os.Build.ID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "Quran.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement =
                "CREATE TABLE " +
                        "'tayah' ( 'AyaID' INTEGER,'SuraID' INTEGER, 'AyaNo'	INTEGER, 'ArabicText' TEXT, 'FatehMuhammadJalandhri' TEXT, 'MehmoodulHassan' TEXT, 'DrMohsinKhan' TEXT, 'MuftiTaqiUsmani' TEXT, 'RakuID' INTEGER, 'PRakuID' INTEGER, 'ParaID' INTEGER)";
        db.execSQL(createTableSTatement);
        String createTable2STatement =
                " CREATE TABLE " +
                        "'tsurah' ( 'SurahID' INTEGER, 'SurahIntro' TEXT, 'SurahNameE' TEXT, 'Nazool' TEXT, 'SurahNameU' TEXT)";
        db.execSQL(createTable2STatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tsurah");
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tayah");
        onCreate(db);
    }

    public void  addStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.close();
    }
    public ArrayList ayah()
           {
        ArrayList list = new ArrayList();
        SQLiteDatabase db =
                this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah" ,null);
        cursor.moveToFirst();
        return list;
    }

    public ArrayList<SurahModel> getAllSurahs(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM tsurah WHERE SurahNameE Like '%"+name+"%'", null);

        ArrayList<SurahModel> surahArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                surahArrayList.add(new SurahModel(cursorCourses.getInt(0), cursorCourses.getString(1),
                        cursorCourses.getString(2),cursorCourses.getString(3),cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());

        }

        db.close();
        return surahArrayList;
    }
    public ArrayList<String> getSurah(String SurahName){
        ArrayList<String> surahList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SurahID FROM tsurah WHERE SurahNameE = '"+SurahName+"'",null);
        cursor.moveToFirst();
        int SurahID = cursor.getInt(0);
        cursor =
                db.rawQuery("SELECT ArabicText FROM tayah ta JOIN tsurah ts WHERE ta.SuraID = ts.SurahID AND ts.SurahID = "+SurahID+" ORDER By ta.AyaID",
                null);
        if (cursor.moveToFirst()) {
            do {
                surahList.add(cursor.getString(0));
            } while (cursor.moveToNext());

        }
        db.close();
        return surahList;
    }
    public ArrayList<String> getTranslatedName(String language){
        ArrayList<String> translatedNameList = new ArrayList<>();
        String surahName;
        if(language.equals("urdu"))
        {
            surahName = "SurahNameU";
        }
        else
            surahName = "SurahNameE";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+surahName+" FROM tsurah",null);
        if (cursor.moveToFirst()) {
            do {
                translatedNameList.add(cursor.getString(0));
            } while (cursor.moveToNext());

        }
        return translatedNameList;
    }
    public ArrayList<AyahModel> getTranslatedSurah(String surahName,String language,String version){
        ArrayList<AyahModel> surahList = new ArrayList<>();
        String surahname,translation;
        if(language.equals("urdu")&&version.equals("Fateh Muhammad Jalandhri"))
        {
            surahname = "SurahNameU";
            translation = "FatehMuhammadJalandhri";
        }
        else if(language.equals("urdu")&&version.equals("Mehmood ul Hassan"))
        {
            surahname = "SurahNameU";
            translation = "MehmoodulHassan";
        }
        else if(language.equals("english")&&version.equals("Dr Mohsin Khan"))
        {
            surahname = "SurahNameE";
            translation = "DrMohsinKhan";
        }
        else
        {
            surahname = "SurahNameE";
            translation = "MuftiTaqiUsmani";
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SurahID FROM tsurah WHERE "+surahname+" = '"+surahName+"'",null);
        cursor.moveToFirst();
        int SurahID = cursor.getInt(0);
        cursor =
                db.rawQuery("SELECT ArabicText,"+translation+" FROM tayah ta JOIN tsurah ts WHERE ta.SuraID = ts.SurahID AND ts.SurahID" +
                                " = "+SurahID+" ORDER By ta.AyaID",
                        null);
        if (cursor.moveToFirst())
        {
            do
            {
                surahList.add(new AyahModel(cursor.getString(0), cursor.getString(1)));
            }
            while (cursor.moveToNext());

        }
        return surahList;
    }


}
