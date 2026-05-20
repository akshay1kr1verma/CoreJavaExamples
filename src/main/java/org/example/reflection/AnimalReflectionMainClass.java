package org.example.reflection;

import java.lang.reflect.*;

public class AnimalReflectionMainClass {
    public static void main(String [] args) throws IllegalAccessException {
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
            Constructor<AnimalReflectionExample> constructor = animalReflectionExampleClass.getConstructor(String.class, boolean.class);
            AnimalReflectionExample animalReflectionExample = constructor.newInstance("lhasa", true);
            System.out.println("breed : " + animalReflectionExample.getBreed() + " can swim : " + animalReflectionExample.isCanSwim());
            run.invoke(animalReflectionExample, true, 1, "akshay");
            try {
                Field breed = animalReflectionExample.getClass().getDeclaredField("breed");
                breed.setAccessible(true);
                breed.set(animalReflectionExample, "labrador");
                System.out.println("breed value :: " + animalReflectionExample.getBreed());
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            Constructor<AnimalReflectionExample> animalReflectionConstructorExample =
                    animalReflectionExampleClass.getDeclaredConstructor();
            animalReflectionConstructorExample.setAccessible(true);
            AnimalReflectionExample animalReflectionExample = animalReflectionConstructorExample.newInstance();
            System.out.println("breed : " + animalReflectionExample.getBreed()+ " can swim : " + animalReflectionExample.isCanSwim());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
