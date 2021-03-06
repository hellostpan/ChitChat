package com.stpan.chitchat.injector;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 功能：
 * 创建时间:2016/4/10 12:09
 * 作者:pst
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerFragment {
}
