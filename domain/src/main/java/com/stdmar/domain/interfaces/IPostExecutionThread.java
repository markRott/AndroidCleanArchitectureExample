package com.stdmar.domain.interfaces;

import io.reactivex.Scheduler;

/**
 * Created by sma on 05.09.17.
 */

public interface IPostExecutionThread {

    Scheduler getScheduler();
}
