package com.example.mynotesapp.db;

import android.provider.BaseColumns;

public final class DatabaseContract {
    // Private constructor to prevent instantiation
    private DatabaseContract() {}

    public static final class NoteColumns implements BaseColumns {
        public static final String TABLE_NAME = "note";
        public static final String _ID = "_id";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String DATE = "date";
    }
}
