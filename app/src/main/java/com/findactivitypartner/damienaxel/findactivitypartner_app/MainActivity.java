package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText userLogin;
    String userLoginString;
    EditText userPass;
    String userPassString;
    UserBDD userBDD;
    CardBDD cardBDD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseUserCard.createFullList();
        userLogin = (EditText) findViewById(R.id.edit_text_login);
        userPass = (EditText) findViewById(R.id.edit_text_password);
        userBDD = new UserBDD(this);
        cardBDD = new CardBDD(this);

    }


    public void onHomeUser(View view) {
        userLoginString = userLogin.getText().toString();
        userPassString = userPass.getText().toString();
        checkUserLogin(userLoginString, userPassString);


    }

    private void checkUserLogin(String userLoginString, String userPassString) {
        Cursor cursor =userBDD.getUserList();
        while(cursor.moveToNext())
        {
            String c1=cursor.getString(1);
            String c2=cursor.getString(2);

            if(c1.equals(userLoginString))
            {
                if(c2.equals(userPassString))
                {
                    Toast.makeText(this,
                            "You are succesfully logged in.",
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, userHomeActivity.class);
                    intent.putExtra("userLoginString", userLoginString);
                    startActivity(intent);
                    break;
                }
                else
                {
                    Toast.makeText(this, "Incorrect password",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                }
            }

            if (cursor.isLast()){ Toast.makeText(this, "Incorrect login",Toast.LENGTH_LONG).show();}
        }

        userBDD.close();


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
        cardBDD.close();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        userBDD.open();
        cardBDD.open();
    }


}
