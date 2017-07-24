package com.example.joebuntu.notepaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SavedFiles extends AppCompatActivity implements NoteAdapter.ClickListner{
NoteAdapter adapter;
    NoteContent content;
    RecyclerView rv;
    Toolbar toolbar;
    RecyclerView.LayoutManager lm;
    ArrayList<NoteContent> nc = new ArrayList<>();
    Intent intent;
    DatabaseSetup database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_files);

        init();
        setup();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
    private void setup(){

        rv.setLayoutManager(lm);
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter = new NoteAdapter(database.fetchAll(content), R.layout.file_content);
        rv.setAdapter(adapter);
    }
    void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ac = getSupportActionBar();
        ac.setTitle("Documents");
        ac.setHomeButtonEnabled(true);
        toolbar.setTitle("Documents");
        database = new DatabaseSetup(this);
       rv = (RecyclerView)findViewById(R.id.note_recycler);
        content = new NoteContent();
        lm = new LinearLayoutManager(this);
    }


    @Override
    public void Itemclicked(View view, int position) {

    }

}
