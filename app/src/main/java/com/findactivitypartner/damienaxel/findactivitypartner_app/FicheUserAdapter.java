package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maax on 02/08/16.
 */
public class FicheUserAdapter extends ArrayAdapter {


    private  List<Card> listeActivite;

    public FicheUserAdapter(Context context, int resource, List<Card> liste) {
        super(context, resource, liste);
        listeActivite = liste;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_fiche_user, parent, false);
        TextView textViewSport = (TextView) convertView.findViewById(R.id.text_view_sport);
        TextView textViewVille = (TextView) convertView.findViewById(R.id.text_view_ville);
        TextView textViewPseudo = (TextView) convertView.findViewById(R.id.text_view_pseudo);
        TextView textViewLevel = (TextView) convertView.findViewById(R.id.text_view_level);


        textViewSport.setText(listeActivite.get(position).getActivity());
        textViewVille.setText(listeActivite.get(position).getCity());
        textViewPseudo.setText(listeActivite.get(position).getLogin());
        textViewLevel.setText(listeActivite.get(position).getLevel());




        return convertView;
    }
}
