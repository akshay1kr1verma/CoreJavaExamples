package org.example.annotations.typeparamexample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER})
public @interface MyTypeParam {
    String value() default "default type param value";
}
