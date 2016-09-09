package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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
    private Spinner spinnerActivity;

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
        spinnerActivity = (Spinner) findViewById(R.id.spinner_activity);
        textViewLogin.setText(userLogin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
        spinnerActivity.setAdapter(adapter);

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
