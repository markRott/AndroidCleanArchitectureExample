package com.stdmar.fcleanarchprj;

import android.app.Application;

/**
 * Created by sma on 06.09.17.
 */

public class MyApplication extends Application {

    private static ComponentsHelper componentsHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponentsHelper();
    }

    public static ComponentsHelper getComponentsHelper() {

        return componentsHelper;
    }

    private void initComponentsHelper() {
        componentsHelper = new ComponentsHelper();
        componentsHelper.initApplicationComponent(this);
    }
}
