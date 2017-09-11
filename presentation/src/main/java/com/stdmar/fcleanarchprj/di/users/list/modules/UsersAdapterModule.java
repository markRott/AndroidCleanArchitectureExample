package com.stdmar.fcleanarchprj.di.users.list.modules;

import android.content.Context;

import com.stdmar.fcleanarchprj.di.users.list.UsersListScope;
import com.stdmar.fcleanarchprj.user.userlist.UsersAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.09.17.
 */

@Module
public class UsersAdapterModule {

    @Provides
    @UsersListScope
    public UsersAdapter provideSocialNetworkAdapter(Context context) {
        final UsersAdapter usersAdapter = new UsersAdapter(context);
        return usersAdapter;
    }

}
