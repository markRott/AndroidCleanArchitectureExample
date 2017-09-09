package com.stdmar.fcleanarchprj.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * Created by sma on 09.09.17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    protected abstract void inject();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

}
