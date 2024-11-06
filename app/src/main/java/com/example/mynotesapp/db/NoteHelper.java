package com.example.mynotesapp.db;

import static com.example.mynotesapp.db.DatabaseContract.NoteColumns.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class NoteHelper {
    private static final String DATABASE_TABLE = TABLE_NAME;
    private static DatabaseHelper dataBaseHelper;
    private static NoteHelper INSTANCE;

    private static SQLiteDatabase database;

    public NoteHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static synchronized NoteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new NoteHelper(context);
        }
        return INSTANCE;
    }

    // Open the database
    public void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }

    // Close the database
    public void close() {
        dataBaseHelper.close();
        if (database != null && database.isOpen()) {
            database.close();
        }
    }

    // Query all records
    public Cursor queryAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.NoteColumns._ID + " ASC",
                null
        );
    }

    // Query a record by ID
    public Cursor queryById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.NoteColumns._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }

    // Insert a new record
    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    // Update a record by ID
    public int update(String id, ContentValues values) {
        return database.update(
                DATABASE_TABLE,
                values,
                DatabaseContract.NoteColumns._ID + " = ?",
                new String[]{id}
        );
    }

    // Delete a record by ID
    public int deleteById(String id) {
        return database.delete(
                DATABASE_TABLE,
                DatabaseContract.NoteColumns._ID + " = ?",
                new String[]{id}
        );
    }
}
