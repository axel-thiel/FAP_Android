package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by maax on 01/09/16.
 */
public class CardBDD {
    private SqliteBddUserCards myBaseSqliteCards;
    private SQLiteDatabase sqLiteDatabase;

    public CardBDD(Context context) {
        myBaseSqliteCards = new SqliteBddUserCards(context, "Cards_table", null, 1);
        this.open();
    }

    public void open() {
        sqLiteDatabase = myBaseSqliteCards.getWritableDatabase();
    }

    public void close() {
        sqLiteDatabase.close();
    }

    public Cursor getCardList() {
        if (sqLiteDatabase != null) {
            return sqLiteDatabase.rawQuery(" SELECT * FROM " + SqliteBddUserCards.TABLE_CARDS, null);
        }
        return null;
    }

    public void insertNewCard(Card newCard) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SqliteBddUserCards.LOGIN, newCard.getLogin());
        contentValues.put(SqliteBddUserCards.MAIL, newCard.getMail());
        contentValues.put(SqliteBddUserCards.ACTIVITY, newCard.getActivity());
        contentValues.put(SqliteBddUserCards.CITY, newCard.getCity());
        contentValues.put(SqliteBddUserCards.LEVEL, newCard.getLevel());
        contentValues.put(SqliteBddUserCards.COMMENT, newCard.getComment());

        sqLiteDatabase.insert(SqliteBddUserCards.TABLE_CARDS,null,contentValues);


    }
}
