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
    public static final String STUDENT_ID = "StudentID";
    public static final String STUDENT_NAME = "StudentName";
    public static final String STUDENT_ROLL = "StudentRollNumber";
    public static final String STUDENT_ENROLL = "IsEnrolled";
    public static final String STUDENT_TABLE = "StudentTable";



    public DBHelper(@Nullable Context context) {
        super(context, "Quran.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
//        String createTableSTatement = "CREATE TABLE " + STUDENT_TABLE + "(" +
//                STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " Text, "
//                + STUDENT_ROLL + " Int, " + STUDENT_ENROLL + " BOOL) ";
        String createTableSTatement =
                "CREATE TABLE " +
                        "'tayah' ( 'AyaID' INTEGER,'SuraID' INTEGER, 'AyaNo'	INTEGER, 'ArabicText' TEXT, 'FatehMuhammadJalandhri' TEXT, 'MehmoodulHassan' TEXT, 'DrMohsinKhan' TEXT, 'MuftiTaqiUsmani' TEXT, 'RakuID' INTEGER, 'PRakuID' INTEGER, 'ParaID' INTEGER)";
        db.execSQL(createTableSTatement);
        String createTable2STatement =
                " CREATE TABLE " +
                        "'tsurah' ( 'SurahID' INTEGER, 'SurahIntro' TEXT, 'SurahNameE' TEXT, 'Nazool' TEXT, 'SurahNameU' TEXT)";
        db.execSQL(createTable2STatement);
        Log.d("======", "on DB " +
                "Create:");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tsurah");
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tayah");
        onCreate(db);
    }
    public String hello()
    {
        return "Hello";
    }

    public void  addStudent(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles

        db.close();
    }
    public ArrayList ayah()
           {
        ArrayList list = new ArrayList();
        SQLiteDatabase db =
                this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tayah" ,null);
        cursor.moveToFirst();
        Log.d("====", "column: "+cursor.getColumnCount());
        return list;
    }

    public ArrayList<SurahModel> getAllSurahs(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM tsurah WHERE SurahNameE Like '%"+name+"%'", null);
        Log.d("=====", "Name: "+name);

        ArrayList<SurahModel> surahArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                surahArrayList.add(new SurahModel(cursorCourses.getInt(0), cursorCourses.getString(1),
                        cursorCourses.getString(2),cursorCourses.getString(3),cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
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
        return surahList;
    }


}
