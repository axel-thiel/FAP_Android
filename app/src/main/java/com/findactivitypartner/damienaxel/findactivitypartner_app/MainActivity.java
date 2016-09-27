package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
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
        userLogin = (EditText) findViewById(R.id.edit_text_login);
        userPass = (EditText) findViewById(R.id.edit_text_password);
        userBDD = BddFactory.getUserBdd(this);
        cardBDD = BddFactory.getCardBdd(this);

    }


    public void onHomeUser(View view) {
        userLoginString = userLogin.getText().toString();
        userPassString = userPass.getText().toString();
        checkUserLogin(userLoginString, userPassString);


    }

    private void checkUserLogin(String userLoginString, String userPassString) {
        Cursor cursor = userBDD.getUserList();
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

                    Intent intent = new Intent(this, UserHomeActivity.class);
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

            if (cursor.isLast()){ Toast.makeText(this, "Incorrect login",Toast.LENGTH_LONG).show();

                //to check all users and all cards in the log monitor
                Cursor cursor1 = userBDD.getUserList();
                if (cursor1 != null && cursor1.moveToFirst()) {
                    do{
                        Log.d(" UserBdd / Login =",
                                cursor1.getString( cursor1.getColumnIndex("Login"))+
                                        ", Password =" +cursor1.getString( cursor1.getColumnIndex("Password"))+
                                        ", Email =" +cursor1.getString( cursor1.getColumnIndex("Email")) +""
                        );
                    }while (cursor1.moveToNext());
                    cursor1.close();
                }

                Cursor cursor2 = cardBDD.getCardList();

                if (cursor2 != null && cursor2.moveToFirst()) {
                    do{
                        Log.d(" CardBdd / Login =",
                                cursor2.getString( cursor2.getColumnIndex("Login"))
                                        +", Mail =" +cursor2.getString( cursor2.getColumnIndex("Mail"))
                                        +", Activity =" +cursor2.getString( cursor2.getColumnIndex("Activity"))
                                        +", City =" +cursor2.getString( cursor2.getColumnIndex("City"))
                                        +", Level =" +cursor2.getString( cursor2.getColumnIndex("Level"))
                                        +", Comment =" +cursor2.getString( cursor2.getColumnIndex("Comment"))
                                        +""
                        );
                    }while (cursor2.moveToNext());
                    cursor2.close();
                }

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    public void onCreateNewUser(View view) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
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
