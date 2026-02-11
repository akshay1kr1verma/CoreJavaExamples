package org.example.corejava;

import java.time.LocalTime;

public class EagerInitialization {

    private EagerInitialization() {
    }

    private static EagerInitialization instance;
    public static LocalTime time1 = LocalTime.now();
    public static LocalTime time2;


    public static EagerInitialization getInstance() {
        System.out.println(" time1 :: " + time1 + " instance :: " + instance);
        if (instance == null) {
            instance = new EagerInitialization();
            System.out.println(" instance :: " + instance);
        }
        time2 = LocalTime.now();
        System.out.println(" time2 :: " + time2 + " instance :: " + instance);
        return instance;
    }
}
