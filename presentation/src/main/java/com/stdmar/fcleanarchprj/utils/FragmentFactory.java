package com.stdmar.fcleanarchprj.utils;

import android.support.v4.app.Fragment;

import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.user.detailuser.DetailUserFragment;
import com.stdmar.fcleanarchprj.user.userlist.UsersFragment;

/**
 * Created by sma on 10.09.17.
 */

public class FragmentFactory {

    private FragmentFactory() {
    }

    public static Fragment getFragmentByKey(final String key, final Object data) {
        switch (key) {
            case Const.ScreenKey.USERS_LIST_FRAGMENT_SCREEN:
                return UsersFragment.newInstance();
            case Const.ScreenKey.DETAIL_USER_FRAGMENT_SCREEN:
                return DetailUserFragment.newInstance(data);
            default:
                return null;
        }
    }

}
