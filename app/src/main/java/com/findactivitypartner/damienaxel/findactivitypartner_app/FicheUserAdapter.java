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

        Button deleteBtn = (Button) convertView.findViewById(R.id.deleteButon);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardBDD cardBDD = BddFactory.getCardBdd(getContext());
                String IdCard = listOfActivity.get(position).getCardId();
                cardBDD.deleteCard(IdCard);
                listOfActivity.remove(position);
                notifyDataSetChanged();

            }
        });

        Button resultBtn = (Button) convertView.findViewById(R.id.resultButon);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardBDD cardBDD = BddFactory.getCardBdd(getContext());
                String IdCard = listOfActivity.get(position).getCardId();
                Intent intent = new Intent(getContext(), ResultCardActivity.class);
                Card choosedUserCard = (Card) listOfActivity.get(position);
                intent.putExtra("choosedUserCard", choosedUserCard);
                intent.putExtra("userLoginString", listOfActivity.get(position).getLogin());
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
