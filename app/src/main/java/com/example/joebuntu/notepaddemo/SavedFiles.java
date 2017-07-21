package com.example.joebuntu.notepaddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class SavedFiles extends AppCompatActivity implements View.OnClickListener{
NoteAdapter adapter;
    NoteContent content;
    RecyclerView rv;
    Toolbar toolbar;
    RecyclerView.LayoutManager lm;
    ArrayList<NoteContent> nc = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_files);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        setup();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void setup(){
        rv.setLayoutManager(lm);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setOnClickListener(this);
    }
    void init(){
        intent = getIntent();
        toolbar.setTitle("Documents");
       rv = (RecyclerView)findViewById(R.id.note_recycler);
        lm = new LinearLayoutManager(this);
        adapter = new NoteAdapter(nc, getApplicationContext());
          rv.setAdapter(adapter);
            prepareNotes();
    }

    @Override
    public void onClick(View v) {

    }
    private void prepareNotes() {
        File directory;
        directory = getFilesDir();
        File[] files = directory.listFiles();
        String number;
        for (int f = 1;  f > files.length; f++) {
            number = Integer.toString(f);
            content = new NoteContent(number, Open(theFile));
            nc.add(content);
        }
    }

    void opo(){
    try {
        String bb;

        FileInputStream fileInputStream = openFileInput(intent.getStringExtra("filename"));
        InputStreamReader inputStreamReader  = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        while ((bb = bufferedReader.readLine()) != null){
        stringBuffer.append(bb+"\n");

            for (int f = 1; f > nc.size(); f++)
       //     content = new NoteContent(f, )
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public String Open(String fileName) {
            String content = "";
            try {
                InputStream in = openFileInput(fileName);
                if (in != null) {
                    InputStreamReader tmp = new InputStreamReader(in);
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    }
                    in.close();

                    content = buf.toString();
                }
            } catch (java.io.FileNotFoundException e) {
            } catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }



        return content;
    }
}
