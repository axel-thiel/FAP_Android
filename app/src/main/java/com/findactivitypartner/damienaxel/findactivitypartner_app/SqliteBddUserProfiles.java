package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maax on 05/08/16.
 */
public class SqliteBddUserProfiles extends SQLiteOpenHelper {
    static final String COL_ID = "user_id";
    static final String TABLE_USER = "User_table";
    static final String LOGIN = "Login";
    static final String PASSWORD = "Password";
    static final String EMAIL = "Email";
    static final int DATABASE_VERSION = 1;

    private static final String createBDD = " CREATE TABLE " + TABLE_USER + " ( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + LOGIN + " TEXT NOT NULL, "
            + PASSWORD + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL ); ";

    public SqliteBddUserProfiles(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createBDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
