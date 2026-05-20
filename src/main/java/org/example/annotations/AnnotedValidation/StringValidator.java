package org.example.annotations.AnnotedValidation;

import java.util.Objects;

public class StringValidator implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        if (Objects.isNull(value) || value.isEmpty()) {
            return false;
        }
        return true;
    }
}
