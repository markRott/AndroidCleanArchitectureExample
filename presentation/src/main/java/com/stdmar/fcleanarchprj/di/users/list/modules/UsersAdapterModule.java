package com.stdmar.fcleanarchprj.di.users.list.modules;

import android.content.Context;
import android.view.LayoutInflater;

import com.stdmar.fcleanarchprj.R;
import com.stdmar.fcleanarchprj.di.users.list.UsersListScope;
import com.stdmar.fcleanarchprj.user.userlist.adapter.UsersAdapter;
import com.stdmar.fcleanarchprj.user.userlist.adapter.UserViewHolderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.09.17.
 */

@Module
public class UsersAdapterModule {

    @Provides
    @UsersListScope
    public UserViewHolderFactory provideUserViewHolderFactory(LayoutInflater layoutInflater) {
        return new UserViewHolderFactory(layoutInflater, R.layout.item_user);
    }

    @Provides
    @UsersListScope
    public UsersAdapter provideSocialNetworkAdapter(Context context, UserViewHolderFactory factory) {
        return new UsersAdapter(context, factory);
    }

}
