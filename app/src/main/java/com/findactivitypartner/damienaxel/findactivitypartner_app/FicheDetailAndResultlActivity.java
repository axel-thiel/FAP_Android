package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by maax on 03/08/16.
 */
public class FicheDetailAndResultlActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fiche_detail_and_results);
        TextView textViewSport = (TextView) findViewById(R.id.detail_text_view_sport);
        TextView textViewVille = (TextView) findViewById(R.id.detail_text_view_ville);
        TextView textViewPseudo = (TextView) findViewById(R.id.detail_text_view_pseudo);
        TextView textViewDateIn = (TextView) findViewById(R.id.detail_text_view_dateIn);
        TextView textViewDateOut = (TextView) findViewById(R.id.detail_text_view_dateOut);
        TextView textViewNiveau = (TextView) findViewById(R.id.detail_text_view_niveau);
        TextView textViewPret = (TextView) findViewById(R.id.detail_text_view_pretbesoin);
        TextView textViewCommentaire = (TextView) findViewById(R.id.detail_text_view_commentaire);



        Bundle bundle = getIntent().getExtras();
        FicheActivity ficheUserChoisie = (FicheActivity) bundle.get("ficheUserChoisie");
        textViewSport.setText(ficheUserChoisie.getSport());
        textViewVille.setText(ficheUserChoisie.getVille());
        textViewPseudo.setText(ficheUserChoisie.getPseudo());
        textViewDateIn.setText(ficheUserChoisie.getDateDebut());
        textViewDateOut.setText(ficheUserChoisie.getDateFin());
        textViewNiveau.setText(ficheUserChoisie.getNiveauActivite());
        textViewCommentaire.setText(ficheUserChoisie.getComentaireActivite());





    }
}
