package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by maax on 02/08/16.
 */
public class userHomeActivity extends Activity {


    String userLogin = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");


        List<Card> sortedCardsList = DataBaseUserCard.recuperationUserCard(userLogin);
        final ListView UserCardsList = (ListView) findViewById(R.id.user_card_list);

        // use custum adapter to show the list
        FicheUserAdapter ficheUserAdapter = new FicheUserAdapter(this, R.layout.adapter_fiche_user, sortedCardsList);
        UserCardsList.setAdapter(ficheUserAdapter);

        //method to isolate the information on clicked card
        UserCardsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailAndResultCardActivity.class);
                Card choosedUserCard = (Card) UserCardsList.getItemAtPosition(i);
                intent.putExtra("choosedUserCard", choosedUserCard);
                startActivity(intent);
            }

        });


    }

    public void onCreateNewCard(View view){
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");
        Intent intent = new Intent(this, CreateNewCardActivity.class);
        intent.putExtra("userLoginString", userLogin);
        startActivity(intent);

    }

}
