package com.stdmar.domain.interactors;

import com.stdmar.domain.IPostExecutionThread;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 05.09.17.
 */

public abstract class BaseUseCase<T, Params> {

    private CompositeDisposable disposables;
    private IPostExecutionThread postExecutionThread;

    abstract Flowable<T> buildUseCaseObservable(Params params);

    public BaseUseCase(IPostExecutionThread thread) {

        this.postExecutionThread = thread;
        disposables = new CompositeDisposable();
    }

    public void execute(DisposableSubscriber<T> disposableSubscriber, Params params) {

        final Flowable<T> flowable =
                buildUseCaseObservable(params)
                        .subscribeOn(Schedulers.io())
                        .observeOn(postExecutionThread.getScheduler());

        addDisposable(flowable.subscribeWith(disposableSubscriber));
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private void addDisposable(Disposable localDisposable) {
        if (localDisposable == null) return;
        disposables.add(localDisposable);
    }
}
