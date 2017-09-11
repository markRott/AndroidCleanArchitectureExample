package com.stdmar.domain.interactors.stubclasses;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 11.09.17.
 */

public class TestDisposableSubscriber<T> extends DisposableSubscriber<T> {

    private int valuesCount = 0;

    public int getValuesCount() {
        return valuesCount;
    }

    @Override
    public void onNext(T t) {
        valuesCount++;
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
