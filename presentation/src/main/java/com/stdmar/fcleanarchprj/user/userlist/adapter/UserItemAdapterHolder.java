package com.stdmar.fcleanarchprj.user.userlist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.stdmar.fcleanarchprj.R;

/**
 * Created by sma on 12.09.17.
 */

public class UserItemAdapterHolder extends RecyclerView.ViewHolder {

    public View rootView;
    public TextView tvUserName;

    public UserItemAdapterHolder(View itemView) {
        super(itemView);

        rootView = itemView;
        tvUserName = rootView.findViewById(R.id.tv_user_name);
    }
}
