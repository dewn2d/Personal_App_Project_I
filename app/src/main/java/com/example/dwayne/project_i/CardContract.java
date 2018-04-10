package com.example.dwayne.project_i;

import android.provider.BaseColumns;

public final class CardContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private CardContract() {}

    /* Inner class that defines the table contents */
    public static class cardEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String WORD = "word";
        public static final String SUB_WORD = "sub_word";
        public static final String POS = "part";
        public static final String TRANS = "translation";
    }

}
