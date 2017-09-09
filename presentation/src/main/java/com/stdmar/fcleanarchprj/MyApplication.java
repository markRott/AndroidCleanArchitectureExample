package com.stdmar.fcleanarchprj;

import android.app.Application;

import com.stdmar.fcleanarchprj.di.login.LoginComponent;

/**
 * Created by sma on 06.09.17.
 */

public class MyApplication extends Application {

    public static MyApplication INSTANCE;
    private ComponentsHelper componentsHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initComponentsHelper();
    }

    public ComponentsHelper getComponentsHelper() {

        return componentsHelper;
    }

    public LoginComponent getLoginComponent() {

        return componentsHelper.getLoginComponent();
    }

    private void initComponentsHelper() {
        componentsHelper = new ComponentsHelper();
        componentsHelper.initMyApplicationComponent(this);
    }
}
