package org.example.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Repeatable(Roles.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
    String value() default "Admin";
}
