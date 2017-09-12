package com.sma.data.repository;

import com.sma.data.entity.LoginEntity;
import com.sma.data.entity.mapper.LoginEntityDataMapper;
import com.sma.data.rest.IApplicationApi;
import com.stdmar.domain.models.LoginDomainModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Flowable;

import static org.mockito.BDDMockito.given;

/**
 * Created by sma on 12.09.17.
 */
@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class LoginRepositoryImplTest {

    @Mock
    IApplicationApi testApplicationApi;
    @Mock
    LoginEntityDataMapper testLoginEntityDataMapper;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private LoginRepositoryImpl testLoginRepository;
    private LoginRepositoryImpl testLoginRepositoryWitNullApi;
    private LoginRepositoryImpl testLoginRepositoryWitNullMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testLoginRepository = new LoginRepositoryImpl(testApplicationApi, testLoginEntityDataMapper);
        testLoginRepositoryWitNullApi = new LoginRepositoryImpl(null, testLoginEntityDataMapper);
        testLoginRepositoryWitNullMapper = new LoginRepositoryImpl(testApplicationApi, null);
    }

    @Test
    public void testLogin() {
        final LoginEntity loginEntity = new LoginEntity();
        final LoginDomainModel loginDomainModel = new LoginDomainModel();

        given(testApplicationApi.login()).willReturn(Flowable.just(loginEntity));
        testLoginRepository.login();

        given(testLoginRepository.login()).willReturn(Flowable.just(loginDomainModel));
        testLoginRepository.login();
    }

    @Test
    public void testLoginWithNullApi() {
        expectedException.expect(NullPointerException.class);
        testLoginRepositoryWitNullApi.login();
    }

    @Test
    public void testLoginWithNullMapper() {
        expectedException.expect(NullPointerException.class);
        testLoginRepositoryWitNullMapper.login();
    }
}