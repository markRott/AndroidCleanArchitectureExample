package com.stdmar.fcleanarchprj.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.stdmar.fcleanarchprj.Const;
import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.base.BaseActivity;
import com.stdmar.fcleanarchprj.user.userlist.IBackButtonListener;
import com.stdmar.fcleanarchprj.utils.FragmentFactory;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;

/**
 * MainActivity - displays 2 fragments: UsersFragment and DetailUserFragment
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            navigator.applyCommand(new Replace(Const.ScreenKey.USERS_LIST_FRAGMENT_SCREEN, null));
        }
    }

    @Override
    protected void inject() {
        getMyApplicationComponent().inject(this);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frm_main_container);
        if (fragment != null && fragment instanceof IBackButtonListener
                && ((IBackButtonListener) fragment).onBackPressed()) {
            //
            return;

        } else {
            super.onBackPressed();
        }
    }

    private Navigator navigator = new
            SupportFragmentNavigator(getSupportFragmentManager(), R.id.frm_main_container) {

                @Override
                protected Fragment createFragment(String screenKey, Object data) {

                    return FragmentFactory.getFragmentByKey(screenKey, data);
                }

                @Override
                protected void showSystemMessage(String message) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }

                @Override
                protected void exit() {

                    finish();
                }

                @Override
                public void applyCommand(Command command) {
                    super.applyCommand(command);
                    updateScreenNames(command);
                }
            };

    private void updateScreenNames(Command command) {
        if (command instanceof Back) {
        } else if (command instanceof Forward) {

        } else if (command instanceof Replace) {
        } else if (command instanceof BackTo) {
        }
    }

//    private Fragment getFragmentByKey(final String key) {
//        switch (key) {
//            case Const.ScreenKey.USERS_LIST_FRAGMENT_SCREEN:
//                return UsersFragment.newInstance();
//            case Const.ScreenKey.DETAIL_USER_FRAGMENT_SCREEN:
//                return DetailUserFragment.newInstance();
//            default:
//                return null;
//        }
//    }

}
