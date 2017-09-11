package com.stdmar.domain.interactors.login;

import com.stdmar.domain.interfaces.ILoginRepository;
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
public class LoginUseCaseTest {

    @Mock
    IPostExecutionThread testThread;
    @Mock
    ILoginRepository testRepository;

    LoginUseCase loginUseCase;

    @Before
    public void setUp() throws Exception {
        loginUseCase = new LoginUseCase(testThread, testRepository);
    }

    @Test
    public void testGetUserDetailsUseCaseObservableHappyCase() {
        loginUseCase.buildUseCaseObservable(null);

        verify(testRepository).login();

        verifyNoMoreInteractions(testRepository);
        verifyNoMoreInteractions(testThread);

        verifyZeroInteractions(testRepository);
        verifyZeroInteractions(testThread);
    }

}