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
public class FicheUserAdapterSmall extends ArrayAdapter {

    private  List<Card> listOfActivity;

    public FicheUserAdapterSmall(Context context, int resource, List<Card> liste) {
        super(context, resource, liste);
        listOfActivity = liste;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_fiche_user, parent, false);
        TextView textViewActivity = (TextView) convertView.findViewById(R.id.text_view_activity);
        TextView textViewCity = (TextView) convertView.findViewById(R.id.text_view_city);
        TextView textViewPseudo = (TextView) convertView.findViewById(R.id.text_view_pseudo);
        TextView textViewLevel = (TextView) convertView.findViewById(R.id.text_view_level);

        textViewActivity.setText(listOfActivity.get(position).getActivity());
        textViewCity.setText(listOfActivity.get(position).getCity());
        textViewPseudo.setText(listOfActivity.get(position).getLogin());
        textViewLevel.setText(listOfActivity.get(position).getLevel());

        return convertView;
    }
}
