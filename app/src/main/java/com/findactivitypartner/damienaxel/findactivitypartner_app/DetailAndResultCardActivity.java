package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
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
        TextView textViewDateIn = (TextView) findViewById(R.id.detail_text_view_dateIn);
        TextView textViewDateOut = (TextView) findViewById(R.id.detail_text_view_dateOut);
        TextView textViewNiveau = (TextView) findViewById(R.id.detail_text_view_niveau);
        TextView textViewPret = (TextView) findViewById(R.id.detail_text_view_pretbesoin);
        TextView textViewCommentaire = (TextView) findViewById(R.id.detail_text_view_commentaire);
        ImageView imageView = (ImageView) findViewById(R.id.detail_image_user_fiche);
        ListView listAssociatedCard = (ListView) findViewById(R.id.list_view_associatedCards);

        Bundle bundle = getIntent().getExtras();
        ActivityCard UserCardChoose = (ActivityCard) bundle.get("choosedUserCard");
        textViewSport.setText(UserCardChoose.getSport());
        textViewVille.setText(UserCardChoose.getVille());
        textViewPseudo.setText(UserCardChoose.getLogin());
        textViewDateIn.setText(UserCardChoose.getDateDebut());
        textViewDateOut.setText(UserCardChoose.getDateFin());
        textViewNiveau.setText(UserCardChoose.getNiveauActivite());
        textViewCommentaire.setText(UserCardChoose.getComentaireActivite());
        imageView.setImageResource(UserCardChoose.getImage());

        // method to find the associates cards in the fake database
        List<ActivityCard> associatedCards = DataBaseUserCard.createListOfAssociatedCard(UserCardChoose);

        FicheUserAdapter ficheUserAdapter = new FicheUserAdapter(this, R.layout.adapter_fiche_user, associatedCards);
        listAssociatedCard.setAdapter(ficheUserAdapter);
    }
}
