package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 04/08/16.
 */
public class DataBaseUserPlug {

    public static List<FicheActivity> listeComplete;



    public static List<FicheActivity> recuperationFichesUtilisateur(String userLogin){
        List<FicheActivity> listeFichesTriee = new ArrayList<>();

        for (FicheActivity ficheUser: listeComplete) {
            if(ficheUser.getPseudo().equals(userLogin)){
               listeFichesTriee.add(ficheUser);
            }
        }

       return listeFichesTriee;
    }

    public static void créerListeComplete(){

        // création d'une base de donné avec 3 utilisateurs

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

        listeComplete = new ArrayList<>();
        listeComplete.add(fiche1);
        listeComplete.add(fiche2);
        listeComplete.add(fiche3);
        listeComplete.add(fiche4);
        listeComplete.add(fiche5);
        listeComplete.add(fiche6);
        listeComplete.add(fiche7);
        listeComplete.add(fiche8);
        listeComplete.add(fiche9);
        listeComplete.add(fiche10);
        listeComplete.add(fiche11);
        listeComplete.add(fiche12);


       }


}
