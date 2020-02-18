package com.example.assignment1_f20_wordlearnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private Button btnCancel;
    private Button btnEdit;
    private ImageView wordImage;
    private TextView wordName;
    private TextView wordPronunciation;
    private TextView userWordRating;
    private TextView wordDescription;
    private TextView Notes;
    private Word myWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if(savedInstanceState != null) {
            myWord = (Word)savedInstanceState.getSerializable("wordSave");
        }
        MatchObjectsWithComponents();
        AddEventsToComponents();
        UpdateView();
    }

    public void onBackPressed() { finish();}

    private void AddEventsToComponents() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                // insert intent to activity_edit
            }
        });
    }

    private void UpdateView() {
        myWord = (Word)getIntent().getSerializableExtra("wordInput");

        wordImage.setImageResource(myWord.getImage());
        wordName.setText(myWord.getName());
        wordPronunciation.setText(myWord.getPronunciation());
        userWordRating.setText(myWord.getUserRating().toString());
        wordDescription.setText(myWord.getDescription());
        Notes.setText(myWord.getNotes());
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("wordSave",myWord);
        super.onSaveInstanceState(bundle);
    }

    private void MatchObjectsWithComponents() {
        btnCancel = findViewById(R.id.btn_Cancel_details);
        btnEdit = findViewById(R.id.btn_Edit_details);
        wordImage = findViewById(R.id.IVWordImage);
        wordName = findViewById(R.id.TVWordName);
        wordPronunciation = findViewById(R.id.TVWordPronunciation);
        userWordRating = findViewById(R.id.TVuserWordRating);
        wordDescription = findViewById(R.id.TVWordDescription);
        Notes = findViewById(R.id.TVWordNotes);
    }

}
