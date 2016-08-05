package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.media.Image;

/**
 * Created by maax on 05/08/16.
 */
public class User {
    private String login;
    private String password;
    private Image imageUser;
    private String userMail;
    private String userPresentation;

    public User(String login, String password, String userMail) {
        this.login = login;
        this.password = password;
        this.userMail = userMail;
    }

    public String getUserPresentation() {
        return userPresentation;
    }

    public void setUserPresentation(String userPresentation) {
        this.userPresentation = userPresentation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Image getImageUser() {
        return imageUser;
    }

    public void setImageUser(Image imageUser) {
        this.imageUser = imageUser;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
