package com.stdmar.domain.interactors;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 08.09.17.
 */

abstract class LocalSubscriber extends DisposableSubscriber<Boolean> {

    @Override
    public void onNext(Boolean aBoolean) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}