package org.example.annotations.AnnotedValidation;

public interface Validator<T> {
    boolean isValid(T value);
}
