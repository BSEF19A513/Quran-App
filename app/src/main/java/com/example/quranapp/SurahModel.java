package com.example.quranapp;

public class SurahModel {
    private int surahID;
    private String surahIntro;
    private String surahNameEnglish;
    private String nazool;
    private String surahNameUrdu;

    public SurahModel(int surahID, String surahIntro, String surahNameEnglish, String nazool, String surahNameUrdu) {
        this.surahID = surahID;
        this.surahIntro = surahIntro;
        this.surahNameEnglish = surahNameEnglish;
        this.nazool = nazool;
        this.surahNameUrdu = surahNameUrdu;
    }

    public int getSurahID() {
        return surahID;
    }

    public void setSurahID(int surahID) {
        this.surahID = surahID;
    }

    public String getSurahIntro() {
        return surahIntro;
    }

    public void setSurahIntro(String surahIntro) {
        this.surahIntro = surahIntro;
    }

    public String getSurahNameEnglish() {
        return surahNameEnglish;
    }

    public void setSurahNameEnglish(String surahNameEnglish) {
        this.surahNameEnglish = surahNameEnglish;
    }

    public String getNazool() {
        return nazool;
    }

    public void setNazool(String nazool) {
        nazool = nazool;
    }

    public String getSurahNameUrdu() {
        return surahNameUrdu;
    }

    public void setSurahNameUrdu(String surahNameUrdu) {
        this.surahNameUrdu = surahNameUrdu;
    }
}

