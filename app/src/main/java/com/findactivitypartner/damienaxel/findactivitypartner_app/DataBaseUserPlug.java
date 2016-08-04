package com.findactivitypartner.damienaxel.findactivitypartner_app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 04/08/16.
 */
public class DataBaseUserPlug {
    public static List<FicheActivity> createDataBaseUserPlug(){

        // bréation d'une base de donné avec 3 utilisateurs

        FicheActivity fiche1 = new FicheActivity("Footing", "Lyon", "Damien", R.drawable.damien
                ,"Dimanche", "Mardi", false, false, "commentaire", "Niveau1");
        FicheActivity fiche2 = new FicheActivity("Footing", "Bordeau", "Damien", R.drawable.damien
                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        FicheActivity fiche3 = new FicheActivity("Foot", "Lyon", "Damien", R.drawable.damien
                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        FicheActivity fiche4 = new FicheActivity("Footing", "Toulouse", "Damien", R.drawable.damien
                ,"lundi ", "lundi", false, false, "très aimable", "Niveau1");

        FicheActivity fiche5 = new FicheActivity("Footing", "Lyon", "Axel", R.drawable.axel
                ,"Dimanche", "Mardi", false, false, "commentaire", "Niveau1");
        FicheActivity fiche6 = new FicheActivity("Footing", "Troyes", "Axel", R.drawable.axel
                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        FicheActivity fiche7 = new FicheActivity("Foot", "Lyon", "Axel", R.drawable.axel
                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        FicheActivity fiche8 = new FicheActivity("Judo", "Toulouse", "Axel", R.drawable.axel
                ,"lundi ", "lundi", false, false, "très aimable", "Niveau1");

        FicheActivity fiche9 = new FicheActivity("Footing", "Lyon", "Mélanie", R.drawable.melanie
                ,"Dimanche", "Mardi", false, false, "commentaire", "Niveau1");
        FicheActivity fiche10 = new FicheActivity("Footing", "Dijon", "Mélanie", R.drawable.melanie
                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        FicheActivity fiche11 = new FicheActivity("Foot", "Lyon", "Mélanie", R.drawable.melanie
                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        FicheActivity fiche12 = new FicheActivity("Judo", "Toulouse", "Mélanie", R.drawable.melanie
                ,"lundi ", "lundi", false, false, "très aimable", "Niveau1");

        List<FicheActivity> listeFiches = new ArrayList<>();
        listeFiches.add(fiche1);
        listeFiches.add(fiche2);
        listeFiches.add(fiche3);
        listeFiches.add(fiche4);
        listeFiches.add(fiche5);
        listeFiches.add(fiche6);
        listeFiches.add(fiche7);
        listeFiches.add(fiche8);
        listeFiches.add(fiche9);
        listeFiches.add(fiche10);
        listeFiches.add(fiche11);
        listeFiches.add(fiche12);


        return listeFiches;
    }


}
