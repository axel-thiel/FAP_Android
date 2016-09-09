package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by maax on 05/08/16.
 */
public class UserBDD {
    private SqliteBddUserProfiles myBaseSqlite;
    private SQLiteDatabase sqLiteDatabase;

    public UserBDD(Context context) {
        myBaseSqlite = new SqliteBddUserProfiles(context, "user_table",null,1);
        this.open();
    }

    public void open(){
        sqLiteDatabase = myBaseSqlite.getWritableDatabase();
    }

    public void close(){
        sqLiteDatabase.close();
    }

    public Cursor getUserList(){
        if (sqLiteDatabase != null) {
            return sqLiteDatabase.rawQuery(" SELECT * FROM "+SqliteBddUserProfiles.TABLE_USER, null);
        }
       return null;
    }

    public void insertNewUser(User newUser){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqliteBddUserProfiles.LOGIN, newUser.getLogin());
        contentValues.put(SqliteBddUserProfiles.PASSWORD, newUser.getPassword());
        contentValues.put(SqliteBddUserProfiles.EMAIL, newUser.getUserMail());
        sqLiteDatabase.insert(SqliteBddUserProfiles.TABLE_USER,null,contentValues);
    }

    public SqliteBddUserProfiles getMyBaseSqlite() {
        return myBaseSqlite;
    }

    public void setMyBaseSqlite(SqliteBddUserProfiles myBaseSqlite) {
        this.myBaseSqlite = myBaseSqlite;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
}
