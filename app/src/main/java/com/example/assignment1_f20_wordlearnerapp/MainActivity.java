package com.example.assignment1_f20_wordlearnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Word> wordList;
    private WordArrayAdapter wordListAdaptor;
    private ListView wordListView;
    private Word serviceWord;
    private Button BtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceWord = new Word();
        wordList = new ArrayList<>();

        wordList = serviceWord.GetWordList(getApplicationContext());

        if(savedInstanceState != null) {
            ArrayList<Word> list = new ArrayList<>();

            for(Word word: wordList) {
                list.add(((Word)savedInstanceState.getSerializable(word.getName())));
            }
            wordList = list;
        }

        wordListAdaptor = new WordArrayAdapter(this, wordList);
        MatchObjectWithComponents();
        AddEventsToComponents();
    }

    @Override
    public void onBackPressed(){
        finish();
    }

    private void MatchObjectWithComponents() {
        BtnExit = findViewById(R.id.btn_Exit_main);
        wordListView = findViewById(R.id.LVmainActivity);
    }

    private void AddEventsToComponents() {
        wordListView.setAdapter(wordListAdaptor);

        wordListView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        BtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate) {

        for(Word word: wordList) {
            outstate.putSerializable(word.getName(),word);
        }

        super.onSaveInstanceState(outstate);
    }
}
