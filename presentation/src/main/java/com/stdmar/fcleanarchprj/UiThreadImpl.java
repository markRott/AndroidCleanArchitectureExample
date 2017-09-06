package com.stdmar.fcleanarchprj;

import com.stdmar.domain.IPostExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by sma on 06.09.17.
 */

public class UiThreadImpl implements IPostExecutionThread {

    @Override
    public Scheduler getScheduler() {

        return AndroidSchedulers.mainThread();
    }
}
