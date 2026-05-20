package org.example.annotations.annotationparametertypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationWithAllParam {
    int version() default 1;

    boolean enabled() default false;

    String name() default "default";

    Class<?> annotationClass() default Object.class;

    Role role() default Role.GUEST;

    Info info() default @Info(description = "default value");

    String[] tags() default {};
}
