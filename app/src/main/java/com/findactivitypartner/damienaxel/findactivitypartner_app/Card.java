package com.findactivitypartner.damienaxel.findactivitypartner_app;

import java.io.Serializable;

/**
 * Created by maax on 02/08/16.
 */
public class Card implements Serializable {

    private String activity;
    private String city;
    private String login;
    private String level;
    private String mail;
    private String comment;
    private String cardId;

    public Card(){

    }

    public Card(String activity, String city, String login,
                String level, String mail, String comment) {

        this.activity = activity;
        this.city = city;
        this.login = login;
        this.level = level;
        this.mail = mail;
        this.comment = comment;



    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String sport) {
        this.activity = sport;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String ville) {
        this.city = ville;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
