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
    UserBDD userBDD = new UserBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseUserCard.createFullList();
        userLogin = (EditText) findViewById(R.id.edit_text_login);
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
        
        if (cursor.moveToFirst()) {
            do{
                Log.d("test",
                        cursor.getInt(cursor.getColumnIndex("Login"))+""
                        );
            }while (cursor.moveToNext());
        }cursor.close();
    }
}
