package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maax on 01/09/16.
 */
public class CardBDD extends SQLiteOpenHelper {
    static final String COL_ID = "card_id";
    static final String TABLE_CARDS = "Cards_table";
    static final String LOGIN = "Login";
    static final String MAIL = "Mail";
    static final String ACTIVITY = "Activity";
    static final String CITY = "City";
    static final String LEVEL = "Level";
    static final String COMMENT = "Comment";
    static final int DATABASE_VERSION = 1;
    private static SQLiteDatabase sqLiteDatabase;

    private static final String createBddCards = " CREATE TABLE " + TABLE_CARDS + " ( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + LOGIN + " TEXT NOT NULL, "
            + MAIL + " TEXT NOT NULL, "
            + ACTIVITY + " TEXT NOT NULL, "
            + COMMENT + " TEXT NOT NULL, "
            + CITY + " TEXT NOT NULL, " + LEVEL + " TEXT NOT NULL ); ";

    public CardBDD(Context context, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Cards_table", factory, DATABASE_VERSION);
        this.open();
    }

    @Override
    public void onCreate(SQLiteDatabase newDb) {
        sqLiteDatabase = newDb;
        sqLiteDatabase.execSQL(createBddCards);

        this.insertNewCard(new Card("test", "test", "TestUser1", "Pro", "test1@gmil.com", ""));
        this.insertNewCard(new Card("test", "test", "TestUser2", "Pro", "test2@gmil.com", ""));

        this.insertNewCard(new Card("Footing", "Lyon", "Damien", "Pro", "damien@gmil.com", "j'aime courir"));
        this.insertNewCard(new Card("Footing", "Bordeau", "Damien", "Niveau faible", "damien@gmil.com", "pas de commentaire"));
        this.insertNewCard(new Card("Foot", "Lyon", "Damien", "Niveau moyen", "damien@gmil.com", "dispo que le WE"));
        this.insertNewCard(new Card("Footing", "Toulouse", "Damien", "novice", "damien@gmil.com", "n'aime pas courir en ville"));

        this.insertNewCard(new Card("Footing", "Lyon", "Axel", "Niveau expert", "axel@gmail.com", "doucement mais surement"));
        this.insertNewCard(new Card("Footing", "Troyes", "Axel", "bon", "axel@gmail.com", "au centre ville"));
        this.insertNewCard(new Card("Foot", "Lyon", "Axel", "débutant", "axel@gmail.com", "dispo la semaine"));
        this.insertNewCard(new Card("Judo", "Toulouse", "Axel", "ceinture bleue", "axel@gmail.com", "pas de commentaire"));

        this.insertNewCard(new Card("Footing", "Lyon", "Mélanie", "correct", "melanie@gmail.com", "rien à dire"));
        this.insertNewCard(new Card("Footing", "Dijon", "Mélanie", "bon", "melanie@gmail.com", "la semaine"));
        this.insertNewCard(new Card("Foot", "Lyon", "Mélanie", "expert", "melanie@gmail.com", "en petit groupe"));
        this.insertNewCard(new Card("Judo", "Toulouse", "Mélanie", "novice", "melanie@gmail.com", "en club"));
    }

    public void open() {
        sqLiteDatabase = this.getWritableDatabase();
    }

    public void close() {
        sqLiteDatabase.close();
    }

    public void insertNewCard(Card newCard) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CardBDD.LOGIN, newCard.getLogin());
        contentValues.put(CardBDD.MAIL, newCard.getMail());
        contentValues.put(CardBDD.ACTIVITY, newCard.getActivity());
        contentValues.put(CardBDD.CITY, newCard.getCity());
        contentValues.put(CardBDD.LEVEL, newCard.getLevel());
        contentValues.put(CardBDD.COMMENT, newCard.getComment());

        sqLiteDatabase.insert(CardBDD.TABLE_CARDS, null, contentValues);
    }

    public void deleteCard(String idCard) {
        sqLiteDatabase.execSQL("DELETE FROM Cards_table WHERE card_id = " + idCard);
    }

    public Cursor getCardList() {
        if (sqLiteDatabase != null) {
            return sqLiteDatabase.rawQuery(" SELECT * FROM " + CardBDD.TABLE_CARDS, null);
        }
        return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
