package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maax on 02/08/16.
 */
public class FicheUserAdapter extends ArrayAdapter {

    private FicheActivity ficheActivity;
    private  List<FicheActivity> listeActivite;

    public FicheUserAdapter(Context context, int resource, List<FicheActivity> liste) {
        super(context, resource, liste);
        listeActivite = liste;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_fiche_user, parent, false);
        TextView textViewSport = (TextView) convertView.findViewById(R.id.text_view_sport);
        TextView textViewVille = (TextView) convertView.findViewById(R.id.text_view_ville);
        TextView textViewPseudo = (TextView) convertView.findViewById(R.id.text_view_pseudo);
        ImageView imageUser = (ImageView) convertView.findViewById(R.id.image_user_fiche);


        textViewSport.setText(listeActivite.get(position).getSport());
        textViewVille.setText(listeActivite.get(position).getVille());
        textViewPseudo.setText(listeActivite.get(position).getPseudo());
        imageUser.setImageResource(R.drawable.tintin);


        return convertView;
    }
}
