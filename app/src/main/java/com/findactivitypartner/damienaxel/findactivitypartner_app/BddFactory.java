package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.content.Context;

/**
 * Created by maax on 26/09/16.
 */
public class BddFactory {

    public static UserBDD getUserBdd(Context context) {
        return new UserBDD(context, "toto", null, 1);
    }

    public static CardBDD getCardBdd(Context context) {
        return new CardBDD(context, null, 1);
    }
}
