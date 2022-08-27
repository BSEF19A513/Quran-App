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

public class DBHelper extends SQLiteOpenHelper {




    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
        String createTableSTatement =
                "CREATE TABLE " +
                        "'tayah' ( 'AyaID' INTEGER,'SuraID' INTEGER, 'AyaNo'	INTEGER, 'ArabicText' TEXT, 'FatehMuhammadJalandhri' TEXT, 'MehmoodulHassan' TEXT, 'DrMohsinKhan' TEXT, 'MuftiTaqiUsmani' TEXT, 'RakuID' INTEGER, 'PRakuID' INTEGER, 'ParaID' INTEGER)";
        db.execSQL(createTableSTatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF " +
                "EXISTS " + "tayah");
        onCreate(db);
    }
    public String hello()
    {
        return "Hello";
    }

//    public void  addStudent(StudentModel STUDENTModel){
//        SQLiteDatabase db = this.getWritableDatabase();
//        //Hash map, as we did in bundles
//        ContentValues cv = new ContentValues();
//
//        cv.put(STUDENT_NAME, STUDENTModel.getName());
//        cv.put(STUDENT_ROLL, STUDENTModel.getRollNmber());
//        cv.put(STUDENT_ENROLL, STUDENTModel.isEnroll());
//        db.insert(STUDENT_TABLE, null, cv);
//        db.close();
//        //NullCoumnHack
//        //long insert =
//        //if (insert == -1) { return false; }
//        //else{return true;}
//    }

//    public ArrayList<StudentModel> getAllStudents() {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);
//
//        ArrayList<StudentModel> studentArrayList = new ArrayList<>();
//
//        // moving our cursor to first position.
//        if (cursorCourses.moveToFirst()) {
//            do {
//
//                studentArrayList.add(new StudentModel(cursorCourses.getInt(0), cursorCourses.getString(1),
//                        cursorCourses.getString(2),
//                        cursorCourses.getInt(3) == 1 ? true : false));
//            } while (cursorCourses.moveToNext());
//
//        }
//
//        cursorCourses.close();
//        return studentArrayList;
//    }
//    public void deleteStudent(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(STUDENT_TABLE,"StudentID = "+id,null);
//        db.close();
//    }
//    public void updateStudent(String name,String rollNumber,boolean isEnroll,int id){
//        int enroll=0;
//        if(isEnroll==true)
//            enroll = 1;
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("StudentName",name);
//        contentValues.put("StudentRollNumber",rollNumber);
//        contentValues.put("IsEnrolled",enroll);
//        db.update(STUDENT_TABLE,contentValues,STUDENT_ID+"="+id,null);
//        Log.d("tag=====", "updateStudent: "+name+" "+rollNumber+" "+enroll);
//        db.close();
//    }

}