package com.example.dicoding.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbnoteapp";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_NOTE = String.format(
            "CREATE TABLE %s"
                                + "(%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                " %s TEXT NOT NULL," +
                                " %s TEXT NOT NULL," +
                                " %s TEXT NOT NULL)",
                            dbConstract.TABLE_NOTE,
                            dbConstract.NoteColumns._ID,
                            dbConstract.NoteColumns.TITLE,
                            dbConstract.NoteColumns.DESCRIPTION,
                            dbConstract.NoteColumns.DATE)   ;

            public  dbHelper(Context context){
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

     @Override
     public void onCreate(SQLiteDatabase db){
                db.execSQL(SQL_CREATE_TABLE_NOTE);
     }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " + dbConstract.TABLE_NOTE);
                onCreate(db);

    }
}
