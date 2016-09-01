package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userLogin;
    String userLoginString;
    UserBDD userBDD;
    CardBDD cardBDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseUserCard.createFullList();
        userLogin = (EditText) findViewById(R.id.edit_text_login);
        userBDD = new UserBDD(this);
        cardBDD = new CardBDD(this);

    }


    public void onHomeUser(View view) {
        userLoginString = userLogin.getText().toString();

        Intent intent = new Intent(this, userHomeActivity.class);
        intent.putExtra("userLoginString", userLoginString);
        startActivity(intent);
    }

    public void onCreateNewUser(View view) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }


    public void onBDDAccess(View view) {
        Cursor cursor = userBDD.getUserList();
        
        if (cursor != null && cursor.moveToFirst()) {
            do{
                Log.d(" UserBdd / Login =",
                        cursor.getString( cursor.getColumnIndex("Login"))+
                                ", Password =" +cursor.getString( cursor.getColumnIndex("Password"))+
                                ", Email =" +cursor.getString( cursor.getColumnIndex("Email")) +""
                        );
            }while (cursor.moveToNext());
            cursor.close();
        }
    }

    public void onBDDCardsAccess(View view) {
        Cursor cursor = cardBDD.getCardList();

        if (cursor != null && cursor.moveToFirst()) {
            do{
                Log.d(" CardBdd / Login =",
                        cursor.getString( cursor.getColumnIndex("Login"))
                                +", Mail =" +cursor.getString( cursor.getColumnIndex("Mail"))
                                +", Activity =" +cursor.getString( cursor.getColumnIndex("Activity"))
                                +", City =" +cursor.getString( cursor.getColumnIndex("City"))
                                +", Level =" +cursor.getString( cursor.getColumnIndex("Level"))
                                +", Comment =" +cursor.getString( cursor.getColumnIndex("Comment"))
                                +""
                );
            }while (cursor.moveToNext());
            cursor.close();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        userBDD.close();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        userBDD.open();
    }


}
