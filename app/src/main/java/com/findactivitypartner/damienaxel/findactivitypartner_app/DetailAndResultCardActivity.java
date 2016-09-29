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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 03/08/16.
 */
public class DetailAndResultCardActivity extends Activity {
    String userLogin;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_detail_and_results);
        Bundle bundle = getIntent().getExtras();
        userLogin = bundle.getString("userLoginString");
        scrollView = (ScrollView) findViewById(R.id.card_detail_scroll_view);

        TextView textViewActivity = (TextView) findViewById(R.id.detail_text_view_activity);
        TextView textViewCity = (TextView) findViewById(R.id.detail_text_view_city);
        TextView textViewPseudo = (TextView) findViewById(R.id.detail_text_view_pseudo);
        TextView textViewLevel = (TextView) findViewById(R.id.detail_text_view_level);
        TextView textViewEmail = (TextView) findViewById(R.id.detail_text_view_email);
        TextView textViewComment = (TextView) findViewById(R.id.detail_text_view_comment);

        Card UserCardChoose = (Card) bundle.get("choosedUserCard");
        textViewActivity.setText(UserCardChoose.getActivity());
        textViewCity.setText(UserCardChoose.getCity());
        textViewPseudo.setText(UserCardChoose.getLogin());
        textViewLevel.setText(UserCardChoose.getLevel());
        textViewEmail.setText(UserCardChoose.getMail());
        textViewComment.setText(UserCardChoose.getComment());

        final ListView listAssociatedCard = (ListView) findViewById(R.id.list_view_associatedCards2);
        final ArrayList<Card> associatedCards = (ArrayList<Card>) bundle.get("associatedCardList");

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
