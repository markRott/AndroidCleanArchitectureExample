package com.stdmar.fcleanarchprj.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.stdmar.fcleanarchprj.MyApplication;

/**
 * Created by sma on 06.09.17.
 */

public class BaseActivity extends MvpAppCompatActivity {

    protected MyApplication myApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    protected void inject(){

    }
}
