package com.stdmar.fcleanarchprj.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.stdmar.fcleanarchprj.MyApplication;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 06.09.17.
 */

public class BaseActivity extends MvpAppCompatActivity {

    @Inject
    public Router router;
    @Inject
    public NavigatorHolder navigatorHolder;

    protected MyApplication myApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    protected void inject() {

    }

    public void replaceFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerViewId, fragment);
        ft.commit();
    }
}
