package com.stdmar.fcleanarchprj.user.userlist;

import com.stdmar.domain.interactors.user.UsersUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.subscribers.DisposableSubscriber;
import ru.terrakok.cicerone.Router;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

/**
 * Created by sma on 12.09.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class UsersPresenterTest {

    private static final int FAKE_USER_ID = 120;

    @Mock
    ILoadUsersView testLoadUsersView;
    @Mock
    ILoadUsersView$$State testLoadUsersViewState;
    @Mock
    Router router;
    @Mock
    UsersUseCase usersUseCase;

    UsersPresenter testUsersPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testUsersPresenter = new UsersPresenter();
        testUsersPresenter.attachView(testLoadUsersView);
        testUsersPresenter.setViewState(testLoadUsersViewState);
        testUsersPresenter.setRouter(router).setUsersUseCase(usersUseCase);
    }

    @Test
    public void testFetchUsers() {
        testUsersPresenter.fetchUsers();
        verify(testLoadUsersViewState).showProgressBar();
        verify(usersUseCase).execute(any(DisposableSubscriber.class), (Void) isNull());
    }

    @Test
    public void testOnBackPressed() {
        testUsersPresenter.onBackPressed();
        verify(router).exit();
    }

    @Test
    public void testOnOpenDetailScreen() {
        testUsersPresenter.onOpenDetailScreen(FAKE_USER_ID);
        verify(router).navigateTo(any(String.class), any(Integer.class));
    }

}