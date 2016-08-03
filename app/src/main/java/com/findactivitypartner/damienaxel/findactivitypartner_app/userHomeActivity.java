package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 02/08/16.
 */
public class userHomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        TextView userNameTextView = (TextView) findViewById(R.id.userNameTextView);
        userNameTextView.setText("Tintin Milou");

        FicheActivity fiche1 = new FicheActivity("Ponney aquatique", "troyes", "Tintin", R.drawable.tintin
                                                ,"Lundi", "Mardi", false, false, "commentaire 1", "Niveau1");
        FicheActivity fiche2 = new FicheActivity("Babyfoot", "Bordeau", "Tintin", R.drawable.tintin
                                                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        FicheActivity fiche3 = new FicheActivity("pétanque", "Paris", "Tintin", R.drawable.tintin
                                                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        FicheActivity fiche4 = new FicheActivity("FF", "Lyon", "Tintin", R.drawable.tintin
                                                ,"Lundi", "Lundi", false, false, "commentaire 4", "Niveau1");

        List<FicheActivity> listeFiches = new ArrayList<>();
        listeFiches.add(fiche1);
        listeFiches.add(fiche2);
        listeFiches.add(fiche3);
        listeFiches.add(fiche4);


        ListView listeUserFiches = (ListView) findViewById(R.id.liste_fiches_user);
        FicheUserAdapter ficheUserAdapter= new FicheUserAdapter(this, R.layout.adapter_fiche_user,listeFiches);
        listeUserFiches.setAdapter(ficheUserAdapter);

    }
}
