package com.example.dicoding.db;

import android.provider.BaseColumns;

public class dbConstract {
    static String TABLE_NOTE = "note";

    static final class NoteColumns implements BaseColumns{
        //Note title
        static String TITLE = "title";
        //Note Description
        static String DESCRIPTION = "description";
        //note date
        static String DATE = "date";
    }
}
