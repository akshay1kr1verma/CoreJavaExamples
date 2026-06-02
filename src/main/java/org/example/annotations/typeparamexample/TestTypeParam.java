package org.example.annotations.typeparamexample;

import java.lang.reflect.TypeVariable;

public class TestTypeParam {
    public static void main(String[] args) {
        TypeVariable<Class<MyTypeParamExample>>[] typeParameters = MyTypeParamExample.class.getTypeParameters();
       for (TypeVariable<Class<MyTypeParamExample>> typeParameter : typeParameters) {
           MyTypeParam[] annotationsByType = typeParameter.getAnnotationsByType(MyTypeParam.class);
           for (MyTypeParam myTypeParam : annotationsByType) {
               System.out.println("myTypeParam :: " + myTypeParam.value());
               System.out.println("typeParameter :: " + typeParameter.getName());
           }
           System.out.println(" ********** ");
       }

    }
}
