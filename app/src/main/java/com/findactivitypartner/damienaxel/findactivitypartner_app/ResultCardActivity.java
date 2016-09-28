package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 03/08/16.
 */
public class ResultCardActivity extends Activity {
    String userLogin;
    ScrollView scrollView;
    ArrayList<Card> associatedCards = new ArrayList<Card>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_results);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");
        scrollView = (ScrollView) findViewById(R.id.card_detail_scroll_view);
        Card UserCardChoose = (Card) bundle.get("choosedUserCard");
        final ListView listAssociatedCard = (ListView) findViewById(R.id.list_view_associatedCards);

        //method to fond associated cards in the sqlite bdd
        CardBDD cardBDD = BddFactory.getCardBdd(this);
        Cursor cursor = cardBDD.getCardList();

        String activitySearched = UserCardChoose.getActivity();
        String citySearched = UserCardChoose.getCity();

        while (cursor.moveToNext()) {
            String cursorLogin = cursor.getString(1);
            String cursorActivity = cursor.getString(3);
            String cursorCity = cursor.getString(5);

            if (!cursorLogin.equals(userLogin)) {
                if (!activitySearched.equals("Tous les sports")) {
                    if (!citySearched.equals("Toutes les villes")) {
                        if (cursorActivity.equals(activitySearched) &&
                                cursorCity.equals(citySearched)) {
                            Card tmpCard = new Card(cursor.getString(3), cursor.getString(5), cursor.getString(1),
                                    cursor.getString(6), cursor.getString(2), cursor.getString(4));
                            tmpCard.setCardId(cursor.getString(0));
                            associatedCards.add(tmpCard);
                        }
                    }
                    if (citySearched.equals("Toutes les villes")) {
                        if (cursorActivity.equals(activitySearched)) {
                            Card tmpCard = new Card(cursor.getString(3), cursor.getString(5), cursor.getString(1),
                                    cursor.getString(6), cursor.getString(2), cursor.getString(4));
                            tmpCard.setCardId(cursor.getString(0));
                            associatedCards.add(tmpCard);
                        }
                    }
                }
                if (activitySearched.equals("Tous les sports")) {
                    if (!citySearched.equals("Toutes les villes")) {
                        if (cursorCity.equals(citySearched)) {
                            Card tmpCard = new Card(cursor.getString(3), cursor.getString(5), cursor.getString(1),
                                    cursor.getString(6), cursor.getString(2), cursor.getString(4));
                            tmpCard.setCardId(cursor.getString(0));
                            associatedCards.add(tmpCard);
                        }
                    }
                    if (citySearched.equals("Toutes les villes")) {
                        Card tmpCard = new Card(cursor.getString(3), cursor.getString(5), cursor.getString(1),
                                cursor.getString(6), cursor.getString(2), cursor.getString(4));
                        tmpCard.setCardId(cursor.getString(0));
                        associatedCards.add(tmpCard);
                    }
                }
            }
        }

        FicheUserAdapterSmall ficheUserAdapterSmall = new FicheUserAdapterSmall(this, R.layout.adapter_fiche_user, associatedCards);
        listAssociatedCard.setAdapter(ficheUserAdapterSmall);
        setListViewHeightBasedOnChildren(listAssociatedCard);
        scrollView.smoothScrollTo(0, 0);

        //method to isolate the information on clicked card
        listAssociatedCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailAndResultCardActivity.class);
                Card choosedUserCard = (Card) listAssociatedCard.getItemAtPosition(i);
                intent.putExtra("choosedUserCard", choosedUserCard);
                intent.putExtra("userLoginString", userLogin);
                intent.putExtra("associatedCardList", associatedCards);
                startActivity(intent);
            }

        });
    }

    public void onDisconnect(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onHomeUser(View view) {
        Intent intent = new Intent(this, UserHomeActivity.class);
        intent.putExtra("userLoginString", userLogin);
        startActivity(intent);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
