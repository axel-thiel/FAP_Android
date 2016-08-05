package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by maax on 05/08/16.
 */
public class UserBDD {
    private MyBaseSqlite myBaseSqlite;
    private static final String COL_ID = "user_id";
    private static final String TABLE_USER = "User_table";
    private static final String LOGIN = "Login";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";
    private SQLiteDatabase sqLiteDatabase;

    public UserBDD(Context context) {
        myBaseSqlite = new MyBaseSqlite(context, "user_table",null,1);
        this.open();
    }

    public void open(){
        sqLiteDatabase = myBaseSqlite.getWritableDatabase();
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public Cursor getUserList(){
        if (sqLiteDatabase == null) {

        }
        return sqLiteDatabase.rawQuery(" SELECT * FROM "+TABLE_USER, null);
    }

    public void insertNewUser(User newUser){
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOGIN, newUser.getLogin());
        contentValues.put(PASSWORD, newUser.getPassword());
        contentValues.put(EMAIL, newUser.getUserMail());
        sqLiteDatabase.insert(TABLE_USER,null,contentValues);
    }

    public MyBaseSqlite getMyBaseSqlite() {
        return myBaseSqlite;
    }

    public void setMyBaseSqlite(MyBaseSqlite myBaseSqlite) {
        this.myBaseSqlite = myBaseSqlite;
    }

    public static String getColId() {
        return COL_ID;
    }

    public static String getTableUser() {
        return TABLE_USER;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
}
