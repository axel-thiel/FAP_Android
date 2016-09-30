package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maax on 05/08/16.
 */
public class UserBDD extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;

    static final String COL_ID = "user_id";
    static final String TABLE_USER = "User_table";
    static final String LOGIN = "Login";
    static final String PASSWORD = "Password";
    static final String EMAIL = "Email";
    static final int DATABASE_VERSION = 1;

    private static final String createBDD = " CREATE TABLE " + TABLE_USER + " ( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + LOGIN + " TEXT NOT NULL, "
            + PASSWORD + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL ); ";

    public UserBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
        this.open();
    }

    @Override
    public void onCreate(SQLiteDatabase newDb) {
        sqLiteDatabase = newDb;
        sqLiteDatabase.execSQL(createBDD);

        this.insertNewUser(new User("TestUser1", "testuser1", "axel@gmail.com"));
        this.insertNewUser(new User("Axel", "axel", "axel@gmail.com"));
        this.insertNewUser(new User("Damien", "damien", "damien@gmail.com"));
        this.insertNewUser(new User("Mélanie", "mélanie", "melanie@gmail.com"));
    }

    public void open() {
        sqLiteDatabase = this.getWritableDatabase();
    }

    public void close() {
        sqLiteDatabase.close();
    }

    public Cursor getUserList() {
        if (sqLiteDatabase != null) {
            return sqLiteDatabase.rawQuery(" SELECT * FROM " + TABLE_USER, null);
        }
        return null;
    }

    public void insertNewUser(User newUser) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOGIN, newUser.getLogin());
        contentValues.put(PASSWORD, newUser.getPassword());
        contentValues.put(EMAIL, newUser.getUserMail());
        sqLiteDatabase.insert(TABLE_USER, null, contentValues);
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
