package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maax on 02/08/16.
 */
public class FicheUserAdapter extends ArrayAdapter {

    private List<Card> listOfActivity;

    public FicheUserAdapter(Context context, int resource, List<Card> liste) {
        super(context, resource, liste);
        listOfActivity = liste;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_detail_fiche_user, parent, false);
        TextView textViewSport = (TextView) convertView.findViewById(R.id.detail_view_activity);
        TextView textViewVille = (TextView) convertView.findViewById(R.id.detail_view_city);
        TextView textViewPseudo = (TextView) convertView.findViewById(R.id.detail_view_pseudo);
        TextView textViewLevel = (TextView) convertView.findViewById(R.id.detail_view_level);
        TextView textViewEmail = (TextView) convertView.findViewById(R.id.detail_view_email);
        TextView textViewComment = (TextView) convertView.findViewById(R.id.detail_view_comment);

        textViewSport.setText(listOfActivity.get(position).getActivity());
        textViewVille.setText(listOfActivity.get(position).getCity());
        textViewPseudo.setText(listOfActivity.get(position).getLogin());
        textViewLevel.setText(listOfActivity.get(position).getLevel());
        textViewEmail.setText(listOfActivity.get(position).getMail());
        textViewComment.setText(listOfActivity.get(position).getComment());

        return convertView;
    }

    public void deleteItemOnView(View v, List<Card> listCards, int position) {
        CardBDD cardBDD = BddFactory.getCardBdd(getContext());
        String IdCard = listCards.get(position).getCardId();
        cardBDD.deleteCard(IdCard);
        listCards.remove(position);
        notifyDataSetChanged();

    }
}
