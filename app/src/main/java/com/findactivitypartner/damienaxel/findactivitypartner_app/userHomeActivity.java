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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);

        Bundle bundle = getIntent().getExtras();
        String userLogin = bundle.getString("userLoginString");
        List<ActivityCard> listeFichesTriee = DataBaseUserCard.recuperationUserPlug(userLogin);
        final ListView listeUserFiches = (ListView) findViewById(R.id.liste_fiches_user);


        FicheUserAdapter ficheUserAdapter = new FicheUserAdapter(this, R.layout.adapter_fiche_user, listeFichesTriee);
        listeUserFiches.setAdapter(ficheUserAdapter);
        listeUserFiches.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailAndResultCardActivity.class);
                ActivityCard ficheUserchoisie = (ActivityCard) listeUserFiches.getItemAtPosition(i);
                intent.putExtra("ficheUserChoisie", ficheUserchoisie);
                startActivity(intent);
            }

        });



    }

}
