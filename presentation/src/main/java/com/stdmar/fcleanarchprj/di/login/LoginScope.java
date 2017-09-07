package com.stdmar.fcleanarchprj.di.login;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sma on 07.09.17.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface LoginScope {
}
