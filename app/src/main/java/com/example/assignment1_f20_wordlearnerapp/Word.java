package com.example.assignment1_f20_wordlearnerapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {

    private String name;
    private String pronunciation;
    private String description;
    private Double userRating;
    private String notes;
    private int image;
    private int ID;


    //Dummy data

    public Word() {
        this.name = "word";
        this.pronunciation = "wuhd";
        this.description = "you try to describe the word word";
        this.userRating = 7.2;
        this.notes = "Insert Notes";
        this.image = R.drawable.nophoto;
        this.ID = 1337;

    }

    public Word(int ID, String name, String pronunciation, String description, Double userRating, String notes, int image) {
        this.name = name;
        this.pronunciation = pronunciation;
        this.description = description;
        this.userRating = userRating;
        this.notes = notes;
        this.image = image;
        this.ID = ID;

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

    // description
    public String getDescription() { return this.description; }

    public void setDescription(String Description) { this.description = Description; }

    // userRating
    public Double getUserRating() {
        return this.userRating;
    }

    public void setUserRating(Double UserRating) {
        this.userRating = UserRating;
    }

    // notes
    public String getNotes() { return this.notes; }

    public void setNotes(String Notes) { this.notes = Notes; }

    // ID
    public Integer getID() {
        return ID;
    }

    public void setID(Integer id) {
        ID = id;
    }

    public ArrayList<Word> GetWordList(Context context) {
        ArrayList<Word> wordList = new ArrayList<>();
        try {
            InputStreamReader animalWordsFile = new InputStreamReader(context.getAssets().open("animals.csv"));
            BufferedReader bufferedReader = new BufferedReader(animalWordsFile);
            String line;
            String notes = " ";
            int id = 0;
            boolean rowLabel = true;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if(rowLabel) {
                    rowLabel = false;
                    continue;
                }

                Word newWord = new Word(id, data[0], data[1], data[2], 0.0, notes, (ImgMapper(data[0])));
                wordList.add(newWord);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return wordList;
    }

    private int ImgMapper(String name) {
        switch(name) {
            case "Lion":
                return (R.drawable.lion);
            case "Leopard":
                return (R.drawable.leopard);
            case "Cheetah":
                return (R.drawable.cheetah);
            case "Elephant":
                return (R.drawable.elephant);
            case "Giraffe":
                return (R.drawable.giraffe);
            case "Kudu":
                return (R.drawable.kudo);
            case "Gnu":
                return (R.drawable.gnu);
            case "Oryx":
                return (R.drawable.oryx);
            case "Camel":
                return (R.drawable.camel);
            case "Shark":
                return (R.drawable.shark);
            case "Crocodile":
                return (R.drawable.crocodile);
            case "Snake":
                return (R.drawable.snake);
            case "Buffalo":
                return (R.drawable.buffalo);
            case "Ostrich":
                return (R.drawable.ostrich);
            default:
                return (R.drawable.nophoto);
        }
    }







}
