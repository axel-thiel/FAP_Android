package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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
    CardBDD cardBDD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");
        cardBDD = new CardBDD(this);


        List<Card> sortedCardsList = DataBaseUserCard.recuperationUserCard(userLogin);

        Cursor cursor = cardBDD.getCardList();

        while(cursor.moveToNext())
        {
            String c1=cursor.getString(1);

            if(c1.equals(userLogin))
            {
                Card tmpCard = new Card(cursor.getString(3),cursor.getString(5),cursor.getString(1),
                        cursor.getString(6),cursor.getString(2), cursor.getString(4));
                sortedCardsList.add(tmpCard);
            }
        }


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
                intent.putExtra("userLoginString", userLogin);
                startActivity(intent);
            }

        });


    }

    public void onCreateNewCard(View view){
        UserBDD userBDD = new UserBDD(this);
        String userMail = new ReadSqliteUserBdd(userBDD, userLogin).getUserProfil().getMail();

        Intent intent = new Intent(this, CreateNewCardActivity.class);
        intent.putExtra("userLoginString", userLogin);
        intent.putExtra("userMailString",userMail);
        startActivity(intent);

    }

    public void onDisconnect(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        cardBDD.close();
        startActivity(intent);
    }
}
