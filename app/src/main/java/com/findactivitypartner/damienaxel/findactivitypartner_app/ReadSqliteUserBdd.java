package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by maax on 07/09/16.
 */
public class ReadSqliteUserBdd {

    private UserBDD userBDD;
    private Card userProfile = new Card();

    public ReadSqliteUserBdd(UserBDD userBdd, String loginUser) {
        String userLogin = loginUser;
        userBDD = userBdd;
        Cursor cursor = userBDD.getUserList();
     

        while (cursor.moveToNext()) {
            String c1 = cursor.getString(1);

            if (c1.equals(userLogin)) {

                userProfile.setMail(cursor.getString(3));

            }
        }

    }


    public Card getUserProfil() {
        return userProfile;
    }

    public void setUserProfil(Card userProfil) {
        this.userProfile = userProfil;
    }
}
