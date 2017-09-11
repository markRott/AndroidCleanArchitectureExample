package com.stdmar.domain.interactors.stubclasses;

/**
 * Created by sma on 11.09.17.
 */

public class TestParams {

    public static TestParams EMPTY = new TestParams();

    private int userId;

    public static TestParams forUser(final int userId) {
        return new TestParams(userId);
    }

    private TestParams() {
    }

    private TestParams(int userId) {
        this.userId = userId;
    }
}
