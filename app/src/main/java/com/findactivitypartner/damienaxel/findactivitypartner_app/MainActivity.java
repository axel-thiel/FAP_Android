package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userLogin;
    String userLoginString;

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
}
