package com.stdmar.fcleanarchprj.user.detailuser;

import com.stdmar.domain.interactors.user.DetailUserUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.subscribers.DisposableSubscriber;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by sma on 12.09.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class DetailUserPresenterTest {

    @Mock
    IDetailUserView testDetailUserView;
    @Mock
    IDetailUserView$$State testDetailUserViewState;
    @Mock
    DetailUserUseCase testDetailUserUseCase;

    private DetailUserPresenter testDetailUserPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        testDetailUserPresenter = new DetailUserPresenter();
        testDetailUserPresenter.attachView(testDetailUserView);
        testDetailUserPresenter.setViewState(testDetailUserViewState);
        testDetailUserPresenter.setDetailUserUseCase(testDetailUserUseCase);
    }

    @Test
    public void fetchUserById() throws Exception {
        final int USER_ID = 5;
        testDetailUserPresenter.fetchUserById(USER_ID);
        verify(testDetailUserViewState).showProgressBar();
        verify(testDetailUserUseCase).execute(
                any(DisposableSubscriber.class),
                any(DetailUserUseCase.Params.class));
    }

}