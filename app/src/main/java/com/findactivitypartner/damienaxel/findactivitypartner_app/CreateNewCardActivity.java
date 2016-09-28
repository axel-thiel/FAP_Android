package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
    private Spinner spinnerActivity, spinnerCity, spinnerLevel;
    private String userMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");
        userMail = bundle.getString("userMailString");
        setContentView(R.layout.create_card_user);
        textViewLogin = (TextView) findViewById(R.id.new_card_login);
        textViewMail = (TextView) findViewById(R.id.new_card_email);
        textViewComment = (TextView) findViewById(R.id.new_card_comment);
        spinnerActivity = (Spinner) findViewById(R.id.spinner_activity);
        spinnerCity = (Spinner) findViewById(R.id.spinner_city);
        textViewLogin.setText(userLogin);

        ArrayAdapter<CharSequence> adaptercity = ArrayAdapter.createFromResource(this,
                R.array.city_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptercity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerActivity.setAdapter(adapter);
        spinnerCity.setAdapter(adaptercity);
        spinnerLevel = (Spinner) findViewById(R.id.spinner_level);
        ArrayAdapter<CharSequence> adapterlevel = ArrayAdapter.createFromResource(this,
                R.array.level_array, android.R.layout.simple_spinner_item);
        textViewMail.setText(userMail);
        adapterlevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLevel.setAdapter(adapterlevel);
    }

    public void onCreateResearchCard(View view) {

        Card newCard = new Card(spinnerActivity.getSelectedItem().toString(),
                spinnerCity.getSelectedItem().toString(),
                userLogin,
                spinnerLevel.getSelectedItem().toString(),
                userMail,
                textViewComment.getText().toString());

        cardBdd = BddFactory.getCardBdd(this);
        cardBdd.open();
        cardBdd.insertNewCard(newCard);
        cardBdd.close();

        Intent intent = new Intent(this, UserHomeActivity.class);
        intent.putExtra("userLoginString", userLogin);
        startActivity(intent);
    }

    public void onHomeUser(View view) {
        Intent intent = new Intent(this, UserHomeActivity.class);
        intent.putExtra("userLoginString", userLogin);
        startActivity(intent);
    }
}
