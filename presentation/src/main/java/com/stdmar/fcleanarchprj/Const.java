package com.stdmar.fcleanarchprj;

/**
 * Created by sma on 09.09.17.
 */

public final class Const {

    private Const() {
    }

    public final class ArgKey {

        private ArgKey() {
        }

        public static final String DETAIL_USER_ID = "DETAIL_USER_ID";

    }

    public final class ScreenKey {

        private ScreenKey() {
        }

        // ACTIVITIES
        public static final String MAIN_ACTIVITY_SCREEN = "MAIN_ACTIVITY_SCREEN";
        public static final String LOGIN_ACTIVITY_SCREEN = "LOGIN_ACTIVITY_SCREEN";
        public static final String SIGNUP_ACTIVITY_SCREEN = "SIGNUP_ACTIVITY_SCREEN";

        // FRAGMENTS
        public static final String USERS_LIST_FRAGMENT_SCREEN = "USERS_LIST_FRAGMENT_SCREEN";
        public static final String DETAIL_USER_FRAGMENT_SCREEN = "DETAIL_USER_FRAGMENT_SCREEN";

    }
}
