package org.example.generics;

public class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void description() {
        System.out.println("we are in vehicle class name : " + name);
    }
}
