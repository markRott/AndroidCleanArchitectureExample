package com.stdmar.fcleanarchprj.login;

import com.stdmar.domain.interactors.login.LoginUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.subscribers.DisposableSubscriber;
import ru.terrakok.cicerone.Router;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by sma on 12.09.17.
 */

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    ILoginView loginView;
    @Mock
    ILoginView$$State loginViewState;
    @Mock
    Router router;
    @Mock
    LoginUseCase loginUseCase;

    LoginPresenter loginPresenter;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(loginView);
        loginPresenter.setViewState(loginViewState);
        loginPresenter.setRouter(router).setLoginUseCase(loginUseCase);
    }

    @Test
    public void testRunLoginRequest() {
        loginPresenter.runLoginRequest();
        verify(loginViewState).disableViews();
        verify(loginViewState).showProgressBar();
        verify(loginUseCase).execute(any(DisposableSubscriber.class), (LoginUseCase.Params) isNull());
    }

    @Test
    public void testOpenMainScreen() {
        loginPresenter.openMainScreen();
        verify(router).navigateTo(any(String.class));
        verify(router).exit();
    }

    @Test
    public void testOnBackPressed() {
        loginPresenter.onBackPressed();
        verify(router).exit();
    }

}