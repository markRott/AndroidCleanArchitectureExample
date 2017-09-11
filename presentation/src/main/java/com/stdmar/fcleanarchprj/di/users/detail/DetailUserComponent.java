package com.stdmar.fcleanarchprj.di.users.detail;

import com.sma.data.entity.mapper.UserEntityDataMapper;
import com.stdmar.domain.interactors.user.DetailUserUseCase;
import com.stdmar.domain.interfaces.IDetailUserRepository;
import com.stdmar.fcleanarchprj.di.app.MyApplicationComponent;
import com.stdmar.fcleanarchprj.di.customqualifier.DetailsQualifier;
import com.stdmar.fcleanarchprj.di.users.detail.modules.DetailUserRepositoryModule;
import com.stdmar.fcleanarchprj.di.users.detail.modules.DetailUserUseCaseModule;
import com.stdmar.fcleanarchprj.user.detailuser.DetailUserFragment;
import com.stdmar.fcleanarchprj.utils.image.IImageLoader;

import dagger.Component;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 11.09.17.
 */

@DetailUserScope
@Component(
        dependencies = {MyApplicationComponent.class},
        modules = {
                DetailUserUseCaseModule.class,
                DetailUserRepositoryModule.class})
public interface DetailUserComponent {

    void injectInDetailUserFragment(DetailUserFragment fragment);

    DetailUserUseCase detailUserUseCase();

    @DetailsQualifier
    UserEntityDataMapper userEntityDataMapper();

    IDetailUserRepository detailUserRepository();

    Router router();

    IImageLoader imageLoader();
}
