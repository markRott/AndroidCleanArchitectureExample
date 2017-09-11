package com.stdmar.fcleanarchprj.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.stdmar.fcleanarchprj.MyApplication;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;

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

    public MyApplicationComponent getMyApplicationComponent() {

        return ((MyApplication) getApplication()).getMyApplicationComponent();
    }
}
