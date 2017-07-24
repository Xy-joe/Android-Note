package com.example.joebuntu.notepaddemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by joebuntu on 7/23/17.
 */

public class DatabaseSetup extends SQLiteOpenHelper {
    public static final String Database_Name = "Notepad.db";
    public static final String Table_Name = "Notepad_table";
    public static final String serial_no = "no";
    public static final String File_Name = "file_Name";
    public static final String Header = "header";
    public static final String Body = "body";
    public static final String create_Table = "create table Notepad_table (no integer primary key not null auto_increment, header text , body text not null, file_Name text, not null)";
    SQLiteDatabase database;

    public DatabaseSetup(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_Table);
        this.database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "Drop Table IF EXISTS" + Table_Name;
        db.execSQL(query);

    }

    void addData(NoteContent data) {
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Header, data.getHeader());
        values.put(Body, data.getBody());
        values.put(File_Name, data.getFile_Name());
        database.insert(Table_Name, null, values);
        database.close();
    }

    ArrayList<NoteContent> fetchAll(NoteContent content) {
        ArrayList<NoteContent> data = new ArrayList<>();
        database = this.getReadableDatabase();
        String query = "Select * FROM " + Table_Name;
        Cursor cursor = database.rawQuery(query, null);

        while (cursor.moveToFirst()) {
            int item1 = cursor.getColumnIndex(serial_no);
            String id = cursor.getString(item1);
            String item2 = cursor.getString(1);
            String item3 = cursor.getString(2);
            String item4 = cursor.getString(3);

            content = new NoteContent(id, item2, item3, item4);
            data.add(content);
        }
        return data;
    }

    Boolean showfiles(String position, EditText body, EditText head, String filename) {
        database = this.getReadableDatabase();
        String sql = "SELECT Index FROM" + Table_Name;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getColumnName(0);
                if (id.equals(position)) {
                    body.setText(cursor.getString(3));
                    head.setText(cursor.getString(2));
                    filename = cursor.getString(4);
                }
            } while (cursor.moveToNext());
            }
            return true;
        }
    }
