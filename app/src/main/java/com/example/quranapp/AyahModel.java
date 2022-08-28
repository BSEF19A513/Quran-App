package com.example.quranapp;

public class AyahModel {
    private int SurahID;
    private int AyahID;
    private int AyahNo;
    private String ArabicText;
    private String UrduText;
    private String EnglishText;
    private int RakuID;
    private int PRakuID;
    private int ParaID;

    public AyahModel(int ayahID, int surahID, int ayahNo, String arabicText, String urduText, String englishText, int rakuID, int PRakuID, int paraID) {
        AyahID = ayahID;
        SurahID = surahID;
        AyahNo = ayahNo;
        ArabicText = arabicText;
        UrduText = urduText;
        EnglishText = englishText;
        RakuID = rakuID;
        this.PRakuID = PRakuID;
        ParaID = paraID;
    }

    public int getAyahID() {
        return AyahID;
    }

    public void setAyahID(int ayahID) {
        AyahID = ayahID;
    }

    public int getSurahID() {
        return SurahID;
    }

    public void setSurahID(int surahID) {
        SurahID = surahID;
    }

    public int getAyahNo() {
        return AyahNo;
    }

    public void setAyahNo(int ayahNo) {
        AyahNo = ayahNo;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public void setArabicText(String arabicText) {
        ArabicText = arabicText;
    }

    public String getUrduText() {
        return UrduText;
    }

    public void setUrduText(String urduText) {
        UrduText = urduText;
    }

    public String getEnglishText() {
        return EnglishText;
    }

    public void setEnglishText(String englishText) {
        EnglishText = englishText;
    }

    public int getRakuID() {
        return RakuID;
    }

    public void setRakuID(int rakuID) {
        RakuID = rakuID;
    }

    public int getPRakuID() {
        return PRakuID;
    }

    public void setPRakuID(int PRakuID) {
        this.PRakuID = PRakuID;
    }

    public int getParaID() {
        return ParaID;
    }

    public void setParaID(int paraID) {
        ParaID = paraID;
    }
}
