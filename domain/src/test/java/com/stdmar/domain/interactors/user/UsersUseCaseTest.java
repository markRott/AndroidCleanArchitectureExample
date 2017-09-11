package com.stdmar.domain.interactors.user;

import com.stdmar.domain.interfaces.IPostExecutionThread;
import com.stdmar.domain.interfaces.IUserRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by sma on 11.09.17.
 */

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class UsersUseCaseTest {

    @Mock
    IPostExecutionThread testThread;
    @Mock
    IUserRepository testRepository;

    UsersUseCase testUsersUseCase;
    UsersUseCase testUsersUseCaseWithNullArguments;
    UsersUseCase testUsersUseCaseWithNullRepository;
    UsersUseCase testUsersUseCaseWithNullThread;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        testUsersUseCase = new UsersUseCase(testThread, testRepository);
        testUsersUseCaseWithNullArguments = new UsersUseCase(null, null);
        testUsersUseCaseWithNullRepository = new UsersUseCase(testThread, null);
        testUsersUseCaseWithNullThread = new UsersUseCase(null, testRepository);
    }

    @Test
    public void testUsersUseCaseWithNullArguments() {
        expectedException.expect(NullPointerException.class);
        testUsersUseCaseWithNullArguments.buildUseCaseObservable(null);
    }

    @Test
    public void testUsersUseCaseWithNullRepository() {
        expectedException.expect(NullPointerException.class);
        testUsersUseCaseWithNullArguments.buildUseCaseObservable(null);
    }

    @Test
    public void testUsersUseCaseWithNullThread() {
        expectedException.expect(NullPointerException.class);
        testUsersUseCaseWithNullArguments.buildUseCaseObservable(null);
    }

    @Test
    public void testCallRepositoryGetUsersMethod() {
        testUsersUseCase.buildUseCaseObservable(null);
        verify(testRepository).getUsers();
    }

    @Test
    public void testCheckUnverifiedInteractionForRepository() {
        testUsersUseCase.buildUseCaseObservable(null);
        verify(testRepository).getUsers();
        verifyNoMoreInteractions(testRepository);
    }

    @Test
    public void testVerifiesNoInteractionsHappenedWithThread() {
        verifyZeroInteractions(testThread);
    }
}