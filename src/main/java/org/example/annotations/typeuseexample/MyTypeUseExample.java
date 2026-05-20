package org.example.annotations.typeuseexample;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

public class MyTypeUseExample {

    private @MyTypeUse(typeValue = " we are in String type value") String name;

    public MyTypeUseExample(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            Field name = MyTypeUseExample.class.getDeclaredField("name");
            AnnotatedType annotatedType = name.getAnnotatedType();
            MyTypeUse myTypeUse = annotatedType.getAnnotation(MyTypeUse.class);
            System.out.println("myTypeUse on field name:: " + myTypeUse.typeValue());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
