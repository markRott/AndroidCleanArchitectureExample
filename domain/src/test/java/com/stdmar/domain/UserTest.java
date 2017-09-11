package com.stdmar.domain;

import com.stdmar.domain.models.UserDomainModel;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sma on 11.09.17.
 */

public class UserTest {

    private static final int FAKE_USER_ID = 8;
    private static final int ERROR_USER_ID = 218;
    private static String REAL_EMAIL = "realemail@.gmail.com";
    private static String FAKE_EMAIL = "notrealemail@.gmail.com";
    private UserDomainModel userDomainModel;

    @Before
    public void setUp() {
        userDomainModel = new UserDomainModel(FAKE_USER_ID);
        userDomainModel.setEmail(REAL_EMAIL);
    }

    @Test
    public void testUserConstructorHappyCase() {
        final int userId = userDomainModel.getUserId();
        assertThat(userId).isEqualTo(FAKE_USER_ID);
    }

    @Test
    public void testUserConstructorNotHappyCase() {
        final int userId = userDomainModel.getUserId();
        assertThat(userId).isNotEqualTo(ERROR_USER_ID);
    }

    @Test
    public void testUserEmailHappyCase() {
        final String userEmail = userDomainModel.getEmail();
        assertThat(userEmail).isEqualTo(REAL_EMAIL);
    }

    @Test
    public void testUserEmailNotHappyCase() {
        final String userEmail = userDomainModel.getEmail();
        assertThat(userEmail).isNotEqualTo(FAKE_EMAIL);
    }
}
