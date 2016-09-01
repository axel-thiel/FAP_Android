package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maax on 03/08/16.
 */
public class DetailAndResultCardActivity extends Activity {

//    UserBDD userBDD = new UserBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail_and_results);

        TextView textViewSport = (TextView) findViewById(R.id.detail_text_view_sport);
        TextView textViewVille = (TextView) findViewById(R.id.detail_text_view_ville);
        TextView textViewPseudo = (TextView) findViewById(R.id.detail_text_view_pseudo);

        ListView listAssociatedCard = (ListView) findViewById(R.id.list_view_associatedCards);

        Bundle bundle = getIntent().getExtras();
        Card UserCardChoose = (Card) bundle.get("choosedUserCard");
        textViewSport.setText(UserCardChoose.getActivity());
        textViewVille.setText(UserCardChoose.getCity());
        textViewPseudo.setText(UserCardChoose.getLogin());


        // method to find the associates cards in the fake database
        List<Card> associatedCards = DataBaseUserCard.createListOfAssociatedCard(UserCardChoose);

        FicheUserAdapter ficheUserAdapter = new FicheUserAdapter(this, R.layout.adapter_fiche_user, associatedCards);
        listAssociatedCard.setAdapter(ficheUserAdapter);
    }
}
