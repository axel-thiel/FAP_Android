package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
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
        while (cursor.moveToNext()) {
            String c1 = cursor.getString(1);
            String c2 = cursor.getString(2);

            if (c1.equals(userLoginString)) {
                if (c2.equals(userPassString)) {
                    Toast.makeText(this,
                            "Connexion",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, UserHomeActivity.class);
                    intent.putExtra("userLoginString", userLoginString);
                    startActivity(intent);
                    break;
                } else {
                    Toast.makeText(this, "Mot de passe incorrect", Toast.LENGTH_LONG).show();
                    break;
                }
            }

            if (cursor.isLast()) {
                Toast.makeText(this, "Identifiant incorrect", Toast.LENGTH_LONG).show();
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

    @Override
    public void onBackPressed()
    {

    }
}
