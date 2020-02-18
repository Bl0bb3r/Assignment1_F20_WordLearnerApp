package com.example.assignment1_f20_wordlearnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private Button btnCancel;
    private Button btnOK;
    private TextView TVwordName;
    private TextView TVuserWordRating;
    private SeekBar SBuserWordRating;
    private EditText ETnotes;

    Word myWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        if (savedInstanceState != null) {
            myWord = (Word)savedInstanceState.getSerializable("words");
        }
        MatchObjectsWithComponents();
        AddEventsToComponents();
        UpdateView();
    }

    @Override
    public void onBackPressed() { finish(); }

    private void AddEventsToComponents() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,sendIntent);
                finish();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWord.setNotes(ETnotes.getText().toString());
                Intent sendIntent = new Intent();
                sendIntent.putExtra("passWord", myWord);
                setResult(Activity.RESULT_OK,sendIntent);
            }
        });

        SBuserWordRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myWord.setUserRating((double)progress/10);
                TVuserWordRating.setText((myWord.getUserRating().toString()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void UpdateView() {
        myWord = (Word)getIntent().getSerializableExtra("WordToNote");

        TVwordName.setText(myWord.getName());
        TVuserWordRating.setText(myWord.getUserRating().toString());
        ETnotes.setText(myWord.getNotes());
        SBuserWordRating.setMax(100);
        SBuserWordRating.setProgress((int)(myWord.getUserRating()*10));
    }

    private void MatchObjectsWithComponents() {
        btnCancel = findViewById(R.id.btn_Cancel_edit);
        btnOK = findViewById(R.id.btn_OK_edit);
        TVwordName = findViewById(R.id.TVWordName);
        TVuserWordRating = findViewById(R.id.TVuserWordRating);
        SBuserWordRating = findViewById(R.id.SBuserWordRating);
        ETnotes = findViewById(R.id.ETnotes);
    }
}
