package com.ctrl.education.core.annotation;

import java.lang.annotation.*;

/**
 * com.ctrl.education.core.annotation
 *
 * @name BussinessLog
 * @description
 * @date 2018-06-24 17:13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BussinessLog {
    String value() default "";

    String type() default "";
}
