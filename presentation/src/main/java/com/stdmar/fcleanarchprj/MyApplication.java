package com.stdmar.fcleanarchprj;

import android.app.Application;

import com.stdmar.fcleanarchprj.di.ComponentsHelper;

/**
 * Created by sma on 06.09.17.
 */

public class MyApplication extends Application {

    public static MyApplication INSTANCE;
    public static ComponentsHelper COMPONENTS_HELPER;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initComponentsHelper();
    }

    private void initComponentsHelper() {
        COMPONENTS_HELPER = new ComponentsHelper();
        COMPONENTS_HELPER.initMyApplicationComponent(this);
    }
}
