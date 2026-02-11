package org.example.corejava;

public interface Livingthing {
    default boolean canBreathe() {
        System.out.println("living thing can breathe");
        return true;
    }
}
