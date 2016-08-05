package com.findactivitypartner.damienaxel.findactivitypartner_app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 04/08/16.
 */
public class DataBaseUserCard {

    public static List<ActivityCard> fullList;

    public static List<ActivityCard> recuperationUserCard(String userLogin){
        List<ActivityCard> listeFichesTriee = new ArrayList<>();

        for (ActivityCard ficheUser: fullList) {
            if(ficheUser.getPseudo().equals(userLogin)){
               listeFichesTriee.add(ficheUser);
            }
        }

       return listeFichesTriee;
    }

    public static void createFullList(){

        // création d'une base de donné avec 3 utilisateurs

        ActivityCard fiche1 = new ActivityCard("Footing", "Lyon", "Damien", R.drawable.damien
                ,"Dimanche", "Mardi", false, false, "commentaire", "Niveau1");
        ActivityCard fiche2 = new ActivityCard("Footing", "Bordeau", "Damien", R.drawable.damien
                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        ActivityCard fiche3 = new ActivityCard("Foot", "Lyon", "Damien", R.drawable.damien
                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        ActivityCard fiche4 = new ActivityCard("Footing", "Toulouse", "Damien", R.drawable.damien
                ,"lundi ", "lundi", false, false, "très aimable", "Niveau1");

        ActivityCard fiche5 = new ActivityCard("Footing", "Lyon", "Axel", R.drawable.axel
                ,"Dimanche", "Mardi", false, false, "commentaire", "Niveau1");
        ActivityCard fiche6 = new ActivityCard("Footing", "Troyes", "Axel", R.drawable.axel
                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        ActivityCard fiche7 = new ActivityCard("Foot", "Lyon", "Axel", R.drawable.axel
                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        ActivityCard fiche8 = new ActivityCard("Judo", "Toulouse", "Axel", R.drawable.axel
                ,"lundi ", "lundi", false, false, "très aimable", "Niveau1");

        ActivityCard fiche9 = new ActivityCard("Footing", "Lyon", "Mélanie", R.drawable.melanie
                ,"Dimanche", "Mardi", false, false, "commentaire", "Niveau1");
        ActivityCard fiche10 = new ActivityCard("Footing", "Dijon", "Mélanie", R.drawable.melanie
                ,"jeudi", "Mardi", true, false, "commentaire 2", "Niveau1");
        ActivityCard fiche11 = new ActivityCard("Foot", "Lyon", "Mélanie", R.drawable.melanie
                ,"mercredi", "Mardi", true, false, "commentaire 3", "Niveau1");
        ActivityCard fiche12 = new ActivityCard("Judo", "Toulouse", "Mélanie", R.drawable.melanie
                ,"lundi ", "lundi", false, false, "très aimable", "Niveau1");

        fullList = new ArrayList<>();
        fullList.add(fiche1);
        fullList.add(fiche2);
        fullList.add(fiche3);
        fullList.add(fiche4);
        fullList.add(fiche5);
        fullList.add(fiche6);
        fullList.add(fiche7);
        fullList.add(fiche8);
        fullList.add(fiche9);
        fullList.add(fiche10);
        fullList.add(fiche11);
        fullList.add(fiche12);
    }

    public static List<ActivityCard> createListOfAssociatedCard(ActivityCard activityCard){
        List<ActivityCard> associatedCardList = new ArrayList<ActivityCard>();
        for (ActivityCard activityCards: fullList) {
            if ((!activityCard.getPseudo().equals(activityCards.getPseudo())) &&
                    activityCard.getSport().equals(activityCards.getSport()) &&
                    activityCard.getVille().equals(activityCards.getVille())){
                associatedCardList.add(activityCards);
            }
        }
        return associatedCardList;
    }

}
