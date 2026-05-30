package org.example.generics;

public class Car extends Vehicle{
    private String name;
    public Car(String name, String name1) {
        super(name);
        this.name = name1;
    }

    @Override
    public void description() {
        System.out.println("We are in car class name : " + name);
    }
}
