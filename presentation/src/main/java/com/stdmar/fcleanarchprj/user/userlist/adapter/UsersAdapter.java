package com.stdmar.fcleanarchprj.user.userlist.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.stdmar.domain.models.UserDomainModel;
import com.stdmar.fcleanarchprj.base.BaseRecyclerAdapter;

/**
 * Created by sma on 10.09.17.
 */

public class UsersAdapter extends BaseRecyclerAdapter<UserDomainModel, UserItemAdapterHolder> {

    private UserItemAdapterHolder rootHolder;
    private UserViewHolderFactory holderFactory;

    public UsersAdapter(Context context, UserViewHolderFactory factory) {
        super(context);
        this.holderFactory = factory;
    }

    @Override
    public UserItemAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        rootHolder = holderFactory.createViewHolder(parent);
        return rootHolder;
    }

    @Override
    public void onBindViewHolder(UserItemAdapterHolder holder, int position) {
        final UserDomainModel item = getItemByPosition(position);
        setupItemTouchListener(holder.rootView, position, item);
        holder.tvUserName.setText(item.getFullName());
    }
}
