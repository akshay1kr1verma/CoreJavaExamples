package org.example.reflection;

import java.lang.reflect.*;

public class AnimalReflectionMainClass {
    public static void main(String [] args) {
        Class<AnimalReflectionExample> animalReflectionExampleClass = AnimalReflectionExample.class;
        //Declared Fields
        for (Field declaredField : animalReflectionExampleClass.getDeclaredFields()) {
            System.out.println("Name :: " + declaredField.getName() + " || Type :: " + declaredField.getType()
             + " ||  Modifier :: " + Modifier.toString(declaredField.getModifiers()));
        }
        System.out.println();
        //Declared Methods
        for (Method declaredMethod : animalReflectionExampleClass.getDeclaredMethods()) {
            System.out.println("Name :: " + declaredMethod.getName() + "|| Return Type :: " + declaredMethod.getReturnType()
                    + " || Modifier :: " + Modifier.toString(declaredMethod.getModifiers())
                    + " || get class " + declaredMethod.getDeclaringClass());
        }
        // invoking method
        try {
            Method run = animalReflectionExampleClass.getMethod("run", boolean.class, int.class,
                    String.class);
            AnimalReflectionExample animalReflectionExample = animalReflectionExampleClass.newInstance();
            run.invoke(animalReflectionExample, true, 1, "akshay");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            Constructor<AnimalReflectionExample> aanimalReflectionExample =
                    animalReflectionExampleClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
