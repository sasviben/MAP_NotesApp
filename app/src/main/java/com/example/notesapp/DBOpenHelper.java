package com.example.notesapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    //Konstante za ime i verziju baze
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    //Konstante za identifikaciju tablice i stupaca
    public static final String TABLE_NOTES = "notes";
    public static final String NOTE_ID = "_id";
    public static final String NOTE_TEXT = "noteText";
    public static final String NOTE_CREATED = "noteCreated";

    //Upit koji kreira tablicu
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NOTES + " (" +
                    NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOTE_TEXT + " TEXT, " +
                    NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}
