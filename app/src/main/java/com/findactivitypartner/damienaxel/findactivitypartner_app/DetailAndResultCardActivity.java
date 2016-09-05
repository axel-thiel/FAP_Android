package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maax on 03/08/16.
 */
public class DetailAndResultCardActivity extends Activity {
    String userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail_and_results);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");

        TextView textViewSport = (TextView) findViewById(R.id.detail_text_view_sport);
        TextView textViewVille = (TextView) findViewById(R.id.detail_text_view_ville);
        TextView textViewPseudo = (TextView) findViewById(R.id.detail_text_view_pseudo);
        TextView textViewLevel = (TextView) findViewById(R.id.detail_text_view_level);
        TextView textViewEmail = (TextView) findViewById(R.id.detail_text_view_email);
        TextView textViewComment = (TextView) findViewById(R.id.detail_text_view_comment);

        final ListView listAssociatedCard = (ListView) findViewById(R.id.list_view_associatedCards);

        Card UserCardChoose = (Card) bundle.get("choosedUserCard");
        textViewSport.setText(UserCardChoose.getActivity());
        textViewVille.setText(UserCardChoose.getCity());
        textViewPseudo.setText(UserCardChoose.getLogin());
        textViewLevel.setText(UserCardChoose.getLevel());
        textViewEmail.setText(UserCardChoose.getMail());
        textViewComment.setText(UserCardChoose.getComment());



        // method to find associated cards in the fake database
        List<Card> associatedCards = DataBaseUserCard.createListOfAssociatedCard(UserCardChoose);

        //method to fond associated cards in the sqlite bdd
        CardBDD cardBDD = new CardBDD(this);
        Cursor cursor = cardBDD.getCardList();
        String userLogin = UserCardChoose.getLogin();
        String activitySearched = UserCardChoose.getActivity();
        String citySearched = UserCardChoose.getCity();

        while(cursor.moveToNext())
        {
            String cursorLogin=cursor.getString(1);
            String cursorActivity=cursor.getString(3);
            String cursorCity=cursor.getString(5);

            if(!cursorLogin.equals(userLogin) && cursorActivity.equals(activitySearched) &&
                    cursorCity.equals(citySearched))
            {
                Card tmpCard = new Card(cursor.getString(3),cursor.getString(5),cursor.getString(1),
                        cursor.getString(6),cursor.getString(2), cursor.getString(4));
                associatedCards.add(tmpCard);
            }
        }



        FicheUserAdapter ficheUserAdapter = new FicheUserAdapter(this, R.layout.adapter_fiche_user, associatedCards);
        listAssociatedCard.setAdapter(ficheUserAdapter);

        //method to isolate the information on clicked card
        listAssociatedCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailAndResultCardActivity.class);
                Card choosedUserCard = (Card) listAssociatedCard.getItemAtPosition(i);
                intent.putExtra("choosedUserCard", choosedUserCard);
                startActivity(intent);
            }

        });

    }

    public void onDisconnect(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onHomeUser(View view) {
        Intent intent = new Intent(this, userHomeActivity.class);
        intent.putExtra("userLoginString",userLogin);
        startActivity(intent);
    }
}
