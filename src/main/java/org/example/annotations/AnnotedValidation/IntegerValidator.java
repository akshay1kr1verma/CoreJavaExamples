package org.example.annotations.AnnotedValidation;

public class IntegerValidator implements Validator<Integer>{
    @Override
    public boolean isValid(Integer value) {
        return !(value <=0);
    }
}
