package com.stdmar.fcleanarchprj.di.users.list;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sma on 09.09.17.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface UsersListScope {
}
