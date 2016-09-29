package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 02/08/16.
 */
public class UserHomeActivity extends Activity {

    String userLogin = null;
    CardBDD cardBDD;
    ScrollView scrollView;
    ListView userCardsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");

        cardBDD = BddFactory.getCardBdd(this);
        scrollView = (ScrollView) findViewById(R.id.user_home_scroll_view);

        List<Card> sortedCardsList = new ArrayList<Card>();
        Cursor cursor = cardBDD.getCardList();

        while (cursor.moveToNext()) {
            String c1 = cursor.getString(1);

            if (c1.equals(userLogin)) {
                Card tmpCard = new Card(cursor.getString(3), cursor.getString(5), cursor.getString(1),
                        cursor.getString(6), cursor.getString(2), cursor.getString(4));
                tmpCard.setCardId(cursor.getString(0));
                sortedCardsList.add(tmpCard);
            }
        }

        userCardsList = (ListView) findViewById(R.id.user_card_list);
        // use custum adapter to show the list
        FicheUserAdapter ficheUserAdapter = new FicheUserAdapter(this, R.layout.adapter_detail_fiche_user, sortedCardsList);
        userCardsList.setAdapter(ficheUserAdapter);
        setListViewHeightBasedOnChildren(userCardsList);
        scrollView.smoothScrollTo(0, 0);
    }

    public void onCreateNewCard(View view) {
        UserBDD userBDD = BddFactory.getUserBdd(this);
        String userMail = new ReadSqliteUserBdd(userBDD, userLogin).getUserProfil().getMail();
        Intent intent = new Intent(this, CreateNewCardActivity.class);
        intent.putExtra("userLoginString", userLogin);
        intent.putExtra("userMailString", userMail);
        startActivity(intent);
    }

    public void onDisconnect(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        cardBDD.close();
        startActivity(intent);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) {
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public void onHomeUser(View view) {
        Intent intent = new Intent(this, UserHomeActivity.class);
        intent.putExtra("userLoginString", userLogin);
        startActivity(intent);
    }
}
