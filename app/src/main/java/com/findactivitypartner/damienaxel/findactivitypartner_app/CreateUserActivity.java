package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maax on 05/08/16.
 */
public class CreateUserActivity extends Activity {

    TextView textViewLogin;
    TextView textViewPassword;
    TextView textViewEmail;
    TextView textViewEmailConfirm;
    UserBDD userBDD = new UserBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_profile);
        textViewLogin = (TextView) findViewById(R.id.create_new_userlogin);
        textViewPassword = (TextView) findViewById(R.id.create_new_userpassword);
        textViewEmail = (TextView) findViewById(R.id.create_new_useremail);
        textViewEmailConfirm = (TextView) findViewById(R.id.create_confirm_new_useremail);
    }

    public void onCreateUser(View view) {

        User newUser = new User(textViewLogin.getText().toString(),textViewPassword.getText().toString(),
                textViewEmail.getText().toString());

        userBDD.open();
        userBDD.insertNewUser(newUser);
        userBDD.close();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
