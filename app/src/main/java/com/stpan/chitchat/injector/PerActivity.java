package com.stpan.chitchat.injector;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * 功能：
 * 创建时间:2016/4/9 13:13
 * 作者:pst
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {

}
