package org.example.corejava;

public interface Bird extends Livingthing {
    default boolean canBreathe() {
        return Livingthing.super.canBreathe();
    }
}
