package com.example.assignment1_f20_wordlearnerapp;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {

    private int image;
    private String name;
    private String pronunciation;
    private Double userRating;
    private String description;
    private String notes;


    //Dummy data

    public Word() {
        this.name = "word";
        this.image = R.drawable.nophoto;
        this.pronunciation = "wuhd";
        this.userRating = 7.2;
        this.description = "you try to describe the word word";
        this.notes = "Insert Notes";
    }

    public Word(String name, int image, String pronunciation, Double userRating, String description, String notes) {
        this.name = name;
        this.image = image;
        this.pronunciation = pronunciation;
        this.userRating = userRating;
        this.description = description;
        this.notes = notes;
    }

    // Get og Set methods

    // name
    public String getName() {
        return this.name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    // image
    public int getImage() { return this.image; }

    public void setImage(int Image) {
        this.image = Image;
    }

    // pronunciation
    public String getPronunciation() {
        return this.pronunciation;
    }

    public void setPronunciation(String Name) {
        this.pronunciation = Name;
    }

    // userRating
    public Double getUserRating() {
        return this.userRating;
    }

    public void setUserRating(Double UserRating) {
        this.userRating = UserRating;
    }

    public String getDescription() { return this.description; }

    public void setDescription(String Description) { this.description = Description; }

    public String getNotes() { return this.notes; }

    public void setNotes(String Notes) { this.notes = Notes; }

    public ArrayList<Word> GetWordList(Context context) {
        ArrayList<Word> wordList = new ArrayList<>();

        // incomplete - missing dummy data insertion from CSV file.

        return wordList;
    }









}
