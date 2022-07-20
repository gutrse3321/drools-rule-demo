package ru.reimu.alice.appserver.aop.annotation;

import java.lang.annotation.*;

/**
 * @author Tomonori
 * @mail gutrse3321@live.com
 * @data 2022-05-14 21:56
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {

    String value() default "";
}
