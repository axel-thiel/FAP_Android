package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by maax on 05/08/16.
 */
public class CreateUserActivity extends Activity {

    private TextView textViewLogin;
    private TextView textViewPassword;
    private TextView textViewPasswordConfirm;
    private TextView textViewEmail;
    private TextView textViewEmailConfirm;
    private UserBDD userBDD;
    String tmpLogin;
    String tmpPass;
    String tmpPassConfirm;
    String tmpMail;
    String tmpMailConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_profile);
        textViewLogin = (TextView) findViewById(R.id.create_new_userlogin);
        textViewPassword = (TextView) findViewById(R.id.create_new_userpassword);
        textViewPasswordConfirm = (TextView) findViewById(R.id.confirm_new_userpassword);
        textViewEmail = (TextView) findViewById(R.id.create_new_useremail);
        textViewEmailConfirm = (TextView) findViewById(R.id.create_confirm_new_useremail);
    }

    public void onCreateUser(View view) {
        tmpLogin = textViewLogin.getText().toString();
        tmpPass = textViewPassword.getText().toString();
        tmpPassConfirm = textViewPasswordConfirm.getText().toString();
        tmpMail = textViewEmail.getText().toString();
        tmpMailConfirm = textViewEmailConfirm.getText().toString();
        userBDD = BddFactory.getUserBdd(this);
        userBDD.open();
        Cursor cursor = userBDD.getUserList();

        while (cursor.moveToNext()) {
            String c1 = cursor.getString(1);
            if (c1.equals(tmpLogin)) {
                Toast.makeText(this, " Login déjà utilisé ", Toast.LENGTH_LONG).show();
                break;
            } else if (!c1.equals(tmpLogin)) {
                if (tmpPass.equals("") || tmpPassConfirm.equals("") ||
                        tmpLogin.equals("") || tmpMail.equals("") ||
                        tmpMailConfirm.equals("")) {
                    Toast.makeText(this, " Login valide ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, " Merci de remplire tous les champs ", Toast.LENGTH_LONG).show();
                    break;
                } else {
                    if (tmpMail.equals(tmpMailConfirm) && tmpPass.equals(tmpPassConfirm)) {
                        User newUser = new User(tmpLogin, tmpPass, tmpMail);
                        userBDD.insertNewUser(newUser);
                        userBDD.close();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        break;
                    } else {
                        Toast.makeText(this, " Confirmation du mail ou du mot de passe incorrect ", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        }
    }
}
