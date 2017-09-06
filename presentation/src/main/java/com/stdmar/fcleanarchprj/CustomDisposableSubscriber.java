package com.stdmar.fcleanarchprj;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 06.09.17.
 */

public class CustomDisposableSubscriber<T> extends DisposableSubscriber<T> {

    @Override
    public void onNext(T o) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
