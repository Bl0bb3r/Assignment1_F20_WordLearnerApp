package com.example.assignment1_f20_wordlearnerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class WordArrayAdapter extends ArrayAdapter {

    Context myContext;
    List<Word> wordList = new ArrayList<>();


    public WordArrayAdapter(Context context, ArrayList<Word> words) {
        super(context,0,words);
        myContext = context;
        wordList = words;
    }

    @NonNull
    @Override
    public View getView(int current, @NonNull View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(myContext).inflate(R.layout.word_layout,parent,false);
        }



        return listItem;
    }


}
