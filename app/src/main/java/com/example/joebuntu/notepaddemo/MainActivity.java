package com.example.joebuntu.notepaddemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity  {
EditText file,usernameInput;
    AlertDialog.Builder dialog;
    String[] name, document;
    NoteContent nc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        file = (EditText)findViewById(R.id.file);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showname();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_open) {

            Intent myIntent = new Intent(MainActivity.this, SavedFiles.class);
            myIntent.putExtra("",)
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void saveActiion(String document ){
        try {
            FileOutputStream fileOutputStream = openFileOutput(name,MODE_PRIVATE);
            fileOutputStream.write(document.getBytes());
            Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showname(){
        dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        //this is what I did to added the layout to the alert dialog
        View layout=inflater.inflate(R.layout.save_layout,null);
        dialog.setCancelable(true);
        dialog.setView(layout);
        dialog.setTitle("Save as");
        usernameInput=(EditText)layout.findViewById(R.id.filename);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                name = usernameInput.getText().toString();
                if (name.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Please enter a valid filename!", Toast.LENGTH_SHORT).show();
                }
                document = name+".txt";
                saveActiion(document);
                file.setText("");
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog builder = dialog.create();
        builder.show();

    }


      void savemessage(){

      }
}
