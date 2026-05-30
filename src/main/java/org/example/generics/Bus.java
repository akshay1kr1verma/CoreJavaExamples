package org.example.generics;

public class Bus extends Vehicle {
    private String name;

    public Bus(String name, String name1) {
        super(name);
        this.name = name1;
    }

    @Override
    public void description() {
        System.out.println(" we are in bus class name : " + name);
    }
}
