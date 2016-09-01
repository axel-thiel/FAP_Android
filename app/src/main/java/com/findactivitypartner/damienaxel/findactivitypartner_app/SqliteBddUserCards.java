package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maax on 01/09/16.
 */
public class SqliteBddUserCards extends SQLiteOpenHelper{
     static final String COL_ID = "card_id";
     static final String TABLE_CARDS = "Cards_table";
    static final String LOGIN = "Login";
    static final String MAIL = "Mail";
     static final String ACTIVITY = "Activity";
     static final String CITY = "City";
     static final String LEVEL = "Level";
    static final String COMMENT = "Comment";
     static final int DATABASE_VERSION = 1;

    private static final String createBddCards = " CREATE TABLE " + TABLE_CARDS + " ( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + LOGIN + " TEXT NOT NULL, "
            + MAIL + " TEXT NOT NULL, "
            + ACTIVITY + " TEXT NOT NULL, "
            + COMMENT + " TEXT NOT NULL, "
            + CITY + " TEXT NOT NULL, " + LEVEL + " TEXT NOT NULL ); ";

    public SqliteBddUserCards(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createBddCards);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
