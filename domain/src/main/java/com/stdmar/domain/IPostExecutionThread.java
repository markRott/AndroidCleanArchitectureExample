package com.stdmar.domain;

import io.reactivex.Scheduler;

/**
 * Created by sma on 05.09.17.
 */

public interface IPostExecutionThread {

    Scheduler getScheduler();
}
