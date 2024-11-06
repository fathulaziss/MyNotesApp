package com.example.mynotesapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database details as constants
    public static final String DATABASE_NAME = "dbnoteapp";
    public static final int DATABASE_VERSION = 1;

    // SQL statement to create the "note" table
    public static final String SQL_CREATE_TABLE_NOTE = "CREATE TABLE " + DatabaseContract.NoteColumns.TABLE_NAME + " (" +
            DatabaseContract.NoteColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DatabaseContract.NoteColumns.TITLE + " TEXT NOT NULL, " +
            DatabaseContract.NoteColumns.DESCRIPTION + " TEXT NOT NULL, " +
            DatabaseContract.NoteColumns.DATE + " TEXT NOT NULL)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.NoteColumns.TABLE_NAME);
        onCreate(db);
    }
}
