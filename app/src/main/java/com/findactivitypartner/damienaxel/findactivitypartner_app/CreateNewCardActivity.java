package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by maax on 07/08/16.
 */
public class CreateNewCardActivity extends Activity {

    String userLogin;
    CardBDD cardBdd;
    TextView textViewLogin;
    TextView textViewMail;
    TextView textViewActivity;
    TextView textViewCity;
    TextView textViewLevel;
    TextView textViewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");
        setContentView(R.layout.create_card_user);
    }


    public void onCreateResearchCard(View view) {


    }
}
