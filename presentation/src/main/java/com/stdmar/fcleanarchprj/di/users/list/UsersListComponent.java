package com.stdmar.fcleanarchprj.di.users.list;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.sma.data.repository.datasource.UserDataStoreFactory;
import com.stdmar.domain.interactors.user.UsersUseCase;
import com.stdmar.domain.interfaces.IUserRepository;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.di.customqualifier.UsersListQualifier;
import com.stdmar.fcleanarchprj.di.users.list.modules.RepositoryModule;
import com.stdmar.fcleanarchprj.di.users.list.modules.UsersAdapterModule;
import com.stdmar.fcleanarchprj.di.users.list.modules.UsersUseCaseModule;
import com.stdmar.fcleanarchprj.user.userlist.UsersAdapter;
import com.stdmar.fcleanarchprj.user.userlist.UsersFragment;

import dagger.Component;
import ru.terrakok.cicerone.Router;

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

    void injectInUsersFragment(UsersFragment usersFragment);

    UsersUseCase usersUseCase();

    UserDataStoreFactory userDataStoreFactory();

    @UsersListQualifier
    UserEntityDataMapper userEntityDataMapper();

    IUserRepository repository();

    UsersAdapter usersAdapter();

    Router router();
}
