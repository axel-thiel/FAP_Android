package com.findactivitypartner.damienaxel.findactivitypartner_app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maax on 04/08/16.
 */
public class DataBaseUserCard {

    public static List<Card> fullList;

    public static List<Card> recuperationUserCard(String userLogin){
        List<Card> listeFichesTriee = new ArrayList<>();

        for (Card ficheUser: fullList) {
            if(ficheUser.getLogin().equals(userLogin)){
               listeFichesTriee.add(ficheUser);
            }
        }

       return listeFichesTriee;
    }

    public static void createFullList(){

        // création d'une base de donné avec 3 utilisateurs

        Card fiche1 = new Card("Footing", "Lyon", "Damien", "Pro","damien@gmil.com", "j'aime courir");
        Card fiche2 = new Card("Footing", "Bordeau", "Damien",  "Niveau faible","damien@gmil.com", "pas de commentaire");
        Card fiche3 = new Card("Foot", "Lyon", "Damien", "Niveau moyen","damien@gmil.com", "dispo que le WE");
        Card fiche4 = new Card("Footing", "Toulouse", "Damien", "novice","damien@gmil.com", "n'aime pas courir en ville");

        Card fiche5 = new Card("Footing", "Lyon", "Axel", "Niveau expert","axel@gmail.com", "doucement mais surement");
        Card fiche6 = new Card("Footing", "Troyes", "Axel",  "bon","axel@gmail.com", "au centre ville");
        Card fiche7 = new Card("Foot", "Lyon", "Axel",  "débutant","axel@gmail.com", "dispo la semaine");
        Card fiche8 = new Card("Judo", "Toulouse", "Axel", "ceinture bleue","axel@gmail.com", "pas de commentaire");

        Card fiche9 = new Card("Footing", "Lyon", "Mélanie", "correct","melanie@gmail.com", "rien à dire");
        Card fiche10 = new Card("Footing", "Dijon", "Mélanie", "bon","melanie@gmail.com", "la semaine");
        Card fiche11 = new Card("Foot", "Lyon", "Mélanie", "expert","melanie@gmail.com", "en petit groupe");
        Card fiche12 = new Card("Judo", "Toulouse", "Mélanie", "novice","melanie@gmail.com", "en club");

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

    public static List<Card> createListOfAssociatedCard(Card card){
        List<Card> associatedCardList = new ArrayList<Card>();
        for (Card cards : fullList) {
            if ((!card.getLogin().equals(cards.getLogin())) &&
                    card.getActivity().equals(cards.getActivity()) &&
                    card.getCity().equals(cards.getCity())){
                associatedCardList.add(cards);
            }
        }
        return associatedCardList;
    }

}
