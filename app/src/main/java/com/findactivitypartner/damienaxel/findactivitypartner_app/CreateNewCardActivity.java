package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maax on 07/08/16.
 */
public class CreateNewCardActivity extends Activity {

    private String userLogin;
    private CardBDD cardBdd;
    private TextView textViewLogin;
    private TextView textViewMail;
    private TextView textViewActivity;
    private TextView textViewCity;
    private TextView textViewLevel;
    private TextView textViewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");

        setContentView(R.layout.create_card_user);
        textViewLogin = (TextView) findViewById(R.id.new_card_login);
        textViewMail = (TextView) findViewById(R.id.new_card_email);
        textViewActivity = (TextView) findViewById(R.id.new_card_activity);
        textViewCity = (TextView) findViewById(R.id.new_card_city);
        textViewLevel = (TextView) findViewById(R.id.new_card_level);
        textViewComment = (TextView) findViewById(R.id.new_card_comment);

        textViewLogin.setText(userLogin);

    }


    public void onCreateResearchCard(View view) {

        Card newCard = new Card(textViewActivity.getText().toString(),
                textViewCity.getText().toString(),
                userLogin,
                textViewLevel.getText().toString(),
                textViewMail.getText().toString(),
                textViewComment.getText().toString());

        cardBdd = new CardBDD(this);
        cardBdd.open();
        cardBdd.insertNewCard(newCard);
        cardBdd.close();

        Intent intent = new Intent(this, userHomeActivity.class);
        intent.putExtra("userLoginString", userLogin);
        startActivity(intent);

    }
}
