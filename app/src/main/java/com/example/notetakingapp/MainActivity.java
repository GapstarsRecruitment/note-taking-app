package com.example.notetakingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import com.example.notetakingapp.models.Note;


public class MainActivity extends AppCompatActivity {

    List<Note> notes;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        notes = db.getAllNotes();
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);
    }

    public void addNote(View view) {
        EditText title = findViewById(R.id.title);
        EditText content = findViewById(R.id.content);
        Note note = new Note();
        note.setTitle(title.getText().toString());
        note.setContent(content.getText().toString());
        db.addNote(note);
        notes.add(note);
    }
}