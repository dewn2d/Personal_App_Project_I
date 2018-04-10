package com.example.dwayne.project_i;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.io.Serializable;

public class CardDbHelper extends SQLiteOpenHelper implements Serializable {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "JCardReader.db";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CardContract.cardEntry.WORD + " (" +
                    CardContract.cardEntry._ID + " INTEGER PRIMARY KEY," +
                    CardContract.cardEntry.SUB_WORD + " TEXT," +
                    CardContract.cardEntry.POS + " TEXT," +
                    CardContract.cardEntry.TRANS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CardContract.cardEntry.WORD;

    public CardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
