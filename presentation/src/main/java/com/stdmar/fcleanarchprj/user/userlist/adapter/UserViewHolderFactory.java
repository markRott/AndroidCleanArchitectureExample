package com.stdmar.fcleanarchprj.user.userlist.adapter;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sma on 12.09.17.
 */

public class UserViewHolderFactory {

    @LayoutRes
    private int layoutId;
    private LayoutInflater layoutInflater;

    public UserViewHolderFactory(LayoutInflater layoutInflater, @LayoutRes final int layoutId) {
        this.layoutInflater = layoutInflater;
        this.layoutId = layoutId;
    }

    public UserItemAdapterHolder createViewHolder(ViewGroup parent) {
        View view = layoutInflater.inflate(layoutId, parent, false);
        return new UserItemAdapterHolder(view);
    }

}
