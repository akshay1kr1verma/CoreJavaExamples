package org.example.annotations.AnnotedValidation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class ValidatorEngine {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        User validUser = new User("akshay", 1);
        User invalidUser = new User("", -1);
        System.out.println("is user valid :: " + validate(validUser));
        System.out.println("is user valid :: " + validate(invalidUser));

    }

    public static boolean validate(Object object) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> user = object.getClass();
        boolean allValidationSuccess = true;
        for (Field field : user.getDeclaredFields()) {
            if (field.isAnnotationPresent(ValidatedBy.class)) {
                ValidatedBy validatedBy = field.getAnnotation(ValidatedBy.class);
                field.setAccessible(true);
                Object value = field.get(object);
                Class<? extends Validator<?>> validatorClass = validatedBy.validate();
                allValidationSuccess = validateField(value, validatorClass.getDeclaredConstructor().newInstance());
                System.out.println("is field :: " + field.getName() + " a valid field :: " + allValidationSuccess);
            }
            if (!allValidationSuccess) {
                return false;
            }
        }
        return allValidationSuccess;
    }

    private static boolean validateField(Object value, Validator validator) {
        return validator.isValid(value);
    }
}
