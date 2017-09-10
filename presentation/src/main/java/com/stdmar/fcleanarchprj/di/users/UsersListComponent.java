package com.stdmar.fcleanarchprj.di.users;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.stdmar.domain.IRepository;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.di.users.modules.RepositoryModule;
import com.stdmar.fcleanarchprj.di.users.modules.UsersAdapterModule;
import com.stdmar.fcleanarchprj.di.users.modules.UsersUseCaseModule;
import com.stdmar.fcleanarchprj.user.userlist.UsersAdapter;
import com.stdmar.fcleanarchprj.user.userlist.UsersFragment;
import com.stdmar.fcleanarchprj.user.userlist.UsersPresenter;

import dagger.Component;

/**
 * Created by sma on 09.09.17.
 */

@Component(
        dependencies = {MyApplicationComponent.class},
        modules = {
                UsersUseCaseModule.class,
                RepositoryModule.class,
                UsersAdapterModule.class})
@UsersListScope
public interface UsersListComponent {

    void injectInUsersPresenter(UsersPresenter usersPresenter);

    void injectInUsersFragment(UsersFragment usersFragment);

    UsersUseCase usersUseCase();

    UserDataStoreFactory userDataStoreFactory();

    UserEntityDataMapper userEntityDataMapper();

    IRepository repository();

    UsersAdapter usersAdapter();
}
