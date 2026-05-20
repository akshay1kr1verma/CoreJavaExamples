package org.example.annotations.typeparamexample;

public class MyTypeParamExample<@MyTypeParam("MyTypeExample on annotation type Param K") K,
        @MyTypeParam("MyTypeExample on annotation type Param V") V> {
    private K key;
    private V value;

    MyTypeParamExample(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
