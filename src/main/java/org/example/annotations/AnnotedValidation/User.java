package org.example.annotations.AnnotedValidation;

public class User {
    @ValidatedBy(validate = StringValidator.class)
    private String name;
    @ValidatedBy(validate = IntegerValidator.class)
    private Integer value;

    public User(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
