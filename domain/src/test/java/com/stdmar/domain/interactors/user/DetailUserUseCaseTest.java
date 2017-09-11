package com.stdmar.domain.interactors.user;

import com.stdmar.domain.interfaces.IDetailUserRepository;
import com.stdmar.domain.interfaces.IPostExecutionThread;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by sma on 11.09.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class DetailUserUseCaseTest {

    public static final int USER_ID = 7;

    @Mock
    IPostExecutionThread testThread;
    @Mock
    IDetailUserRepository testRepository;

    DetailUserUseCase detailUserUseCase;

    @Before
    public void setUp() throws Exception {
        detailUserUseCase = new DetailUserUseCase(testThread, testRepository);
    }

    @Test
    public void testGetUserDetailsUseCaseObservableHappyCase() {
        DetailUserUseCase.Params params = DetailUserUseCase.Params.buildParams(USER_ID);
        detailUserUseCase.buildUseCaseObservable(params);

        verify(testRepository).getUserById(USER_ID);

        verifyNoMoreInteractions(testRepository);
        verifyNoMoreInteractions(testThread);

        verifyZeroInteractions(testRepository);
        verifyZeroInteractions(testThread);
    }

}